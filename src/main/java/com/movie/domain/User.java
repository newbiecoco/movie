package com.movie.domain;

import java.sql.Date;

public class User {
    private String userId;
    private String userName;
    private Integer userAge;
    private Character userSex;
    private String loginName;
    private String loginPassword;
    private Date birthdate;
    private String imgPath;
    private Boolean isDelete;

    public User() {}

    public User(String userId, String userName, Integer userAge, Character userSex, String loginName, String loginPassword, Date birthdate, String imgPath, Boolean isDelete) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.birthdate = birthdate;
        this.imgPath = imgPath;
        this.isDelete = isDelete;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Character getUserSex() {
        return userSex;
    }

    public void setUserSex(Character userSex) {
        this.userSex = userSex;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", birthdate=" + birthdate +
                ", imgPath='" + imgPath + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
