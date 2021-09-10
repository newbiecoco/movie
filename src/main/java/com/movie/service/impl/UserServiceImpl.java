package com.movie.service.impl;

import com.movie.dao.UserDao;
import com.movie.domain.User;
import com.movie.service.UserService;
import com.movie.util.LocalUtils;
import com.movie.util.Md5Utils;
import com.movie.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    // 将源对象中属性copy到目标对象
    public void copyUser(User source, UserVO target) {
        BeanUtils.copyProperties(source, target);
        // 格式化性别
        // 性别为空处理
        if (source.getUserSex() == null) {
            target.setUserSexStr("未知");
        } else {
            switch (source.getUserSex()) {
                case 'p':
                    target.setUserSexStr("保密");
                    break;
                case 'm':
                    target.setUserSexStr("男");
                    break;
                case 'f':
                    target.setUserSexStr("女");
                    break;
            }
        }
        // 格式化出生日期
        target.setBirthdateStr(source.getBirthdate().toString());
    }

    @Override
    public UserVO getUser(User user) {
        User queryUser = userDao.getUserByLoginName(user.getLoginName());
        if (queryUser == null) {
            LocalUtils.set("msg", "用户未注册或已注销");
            return null;
        }
        // 密码加密处理
        String md5Psw = Md5Utils.encryption(user.getLoginPassword());
        user.setLoginPassword(md5Psw);
        // 判断密码一致性
        if (!user.getLoginPassword().equals(queryUser.getLoginPassword())) {
            LocalUtils.set("msg", "账号或密码错误");
            return null;
        }

        UserVO vo = new UserVO();
        // 数据装配
        copyUser(queryUser, vo);
        LocalUtils.set("msg", "登录成功");
        System.out.println(vo);
        return vo;
    }

    @Override
    public UserVO getUserByUserId(String userId) {
        User queryUser = userDao.getUserByUserId(userId);
        if (queryUser == null) {
            return null;
        }

        UserVO vo = new UserVO();
        // 数据装配
        copyUser(queryUser, vo);
        return vo;
    }

    @Override
    public String changePassword(String userId, String newPsw) {
        int row = userDao.changePasswordByUserId(userId, Md5Utils.encryption(newPsw));
        return row == 0 ? "修改失败" : "修改成功";
    }

    @Override
    public String changeUserinfo(User user) {
        int row = userDao.changeUserinfo(user);
        return row == 0 ? "修改失败" : "修改成功";
    }

    @Override
    public String cancellation(String userId) {
        int row = userDao.cancellation(userId);
        return row == 0 ? "注销失败" : "注销成功";
    }

    @Override
    public String addUser(User user) {
        // 判断登录名是否重复
        User queryUser = userDao.getUserByLoginName(user.getLoginName());
        if (queryUser != null) {
            return "登录名已存在";
        }
        while(true) {
            // 随机生成用户ID
            String randomUserId = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
            StringBuilder userId = new StringBuilder();
            userId.append("User_");
            userId.append(randomUserId);
            // 查询重复
            int row = userDao.checkUserId(userId.toString());
            // 没有出现重复userId
            if (row == 0) {
                user.setUserId(userId.toString());
                break;
            }
        }
        // 设置用户为可用
        user.setIsDelete(false);
        // 密码加密处理
        user.setLoginPassword(Md5Utils.encryption(user.getLoginPassword()));
        int row = userDao.addUser(user);
        return row == 0 ? "注册失败" : "注册成功";
    }
}
