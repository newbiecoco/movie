package com.movie.service;

import com.movie.domain.User;
import com.movie.vo.UserVO;

public interface UserService {

    UserVO getUser(User user);

    UserVO getUserByUserId(String userId);

    String changePassword(String userId, String newPsw);

    String changeUserinfo(User user);

    String cancellation(String userId);

    String addUser(User user);
}
