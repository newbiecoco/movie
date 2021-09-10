package com.movie.controller;

import com.movie.domain.User;
import com.movie.service.UserService;
import com.movie.util.LocalUtils;
import com.movie.util.Md5Utils;
import com.movie.vo.Msg;
import com.movie.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    public void checkLoginField(User user, Msg msg) {
        if (user.getLoginName() == null || "".equals(user.getLoginName())) {
            msg.setData("登录名不能为空");
        }
        if (user.getLoginPassword() == null || "".equals(user.getLoginPassword())) {
            msg.setData("登录密码不能为空");
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public Msg login(User user, HttpSession session) {
        Msg msg = new Msg();
        // 检查登录字段是否为空
        checkLoginField(user, msg);
        UserVO userVO = userService.getUser(user);
        if (userVO != null) {
            session.setAttribute("userVO", userVO);
        }
        msg.setData((String) LocalUtils.get("msg"));
        return msg;
    }

    @RequestMapping("/change")
    public String change() {
        return "change";
    }

    @PostMapping("/change")
    @ResponseBody
    public Msg change(@RequestParam("oldPsw") String oldPsw,
                       @RequestParam("newPsw") String newPsw,
                       @RequestParam("confirmPsw") String confirmPsw,
                       HttpSession session) {
        Msg msg = new Msg();
        if (oldPsw == null || "".equals(oldPsw)) {
            msg.setData("原密码不能为空");
            return msg;
        }
        if (newPsw == null || "".equals(newPsw)) {
            msg.setData("新密码不能为空");
            return msg;
        }
        if (confirmPsw == null || "".equals(confirmPsw)) {
            msg.setData("确认密码不能为空");
            return msg;
        }

        UserVO userVO = (UserVO) session.getAttribute("userVO");
        if (userVO == null) {
            msg.setData("请先登录");
            return msg;
        }
        if (!userVO.getLoginPassword().equals(Md5Utils.encryption(oldPsw))) {
            msg.setData("原密码错误");
            return msg;
        }
        if (!newPsw.equals(confirmPsw)) {
            msg.setData("新密码与确认密码不一致");
            return msg;
        }
        String result = userService.changePassword(userVO.getUserId(), newPsw);
        if (result.equals("修改成功")) {
            userVO.setLoginPassword(Md5Utils.encryption(newPsw));
        }
        msg.setData(result);
        return msg;
    }

    @RequestMapping("userinfo")
    @ResponseBody
    public UserVO userinfo(HttpSession session) {
        return (UserVO) session.getAttribute("userVO");
    }

    @RequestMapping("/change-userinfo")
    public String changeUserinfo(HttpSession session, Model model) {
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        if (userVO == null) {
            return "login";
        }
        model.addAttribute("userVO", userVO);
        return "change-userinfo";
    }

    @PostMapping("/change-userinfo")
    @ResponseBody
    public Msg changeUserinfo(User user, HttpSession session) {
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        user.setUserId(userVO.getUserId());
        String result = userService.changeUserinfo(user);
        if ("修改成功".equals(result)) {
            UserVO queryUserVO = userService.getUserByUserId(userVO.getUserId());
            BeanUtils.copyProperties(queryUserVO, userVO);
        }
        return new Msg(result);
    }

    @RequestMapping("cancellation")
    @ResponseBody
    public Msg cancellation(HttpSession session) {
        Msg msg = new Msg();
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        if (userVO == null) {
            msg.setData("请先登录");
            return msg;
        }
        String result = userService.cancellation(userVO.getUserId());
        if ("注销成功".equals(result)) {
            session.removeAttribute("userVO"); // 清空用户
        }
        msg.setData(result);
        return msg;
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Msg register(User user) {
        System.out.println(user);
        Msg msg = new Msg();
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            msg.setData("用户名不能为空");
            return msg;
        }
        // 检查登录字段是否为空
        checkLoginField(user, msg);
        if (user.getBirthdate() == null) {
            msg.setData("出生日期不能为空");
            return msg;
        }
        String result = userService.addUser(user);
        msg.setData(result);
        return msg;
    }
}