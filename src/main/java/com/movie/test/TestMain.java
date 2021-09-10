package com.movie.test;

import com.movie.domain.User;
import com.movie.util.Md5Utils;
import com.movie.vo.UserVO;
import org.springframework.beans.BeanUtils;

import java.security.NoSuchAlgorithmException;

public class TestMain {

    public static void main(String[] args) {
        System.out.println(Md5Utils.encryption("admin"));
    }
}