package com.movie.dao;

import com.movie.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User getUserByLoginName(String loginName);

    User getUserByUserId(String userId);

    int changePasswordByUserId(@Param("userId") String userId, @Param("newPsw") String newPsw);

    int changeUserinfo(User user);

    int cancellation(String userId);

    int addUser(User user);

    int checkUserId(String userId);
}
