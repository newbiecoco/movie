package com.movie.vo;

public class UserVO {
    private String userId;
    private String userName;
    private Integer userAge;
//    private Character userSex;
    private String userSexStr;
    private String loginName;
    private String loginPassword;
//    private Date birthdate;
    private String birthdateStr;
    private String imgPath;

    public UserVO() {}

    public UserVO(String userId, String userName, Integer userAge, String userSexStr, String loginName, String loginPassword, String birthdateStr, String imgPath) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userSexStr = userSexStr;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.birthdateStr = birthdateStr;
        this.imgPath = imgPath;
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

    public String getUserSexStr() {
        return userSexStr;
    }

    public void setUserSexStr(String userSexStr) {
        this.userSexStr = userSexStr;
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

    public String getBirthdateStr() {
        return birthdateStr;
    }

    public void setBirthdateStr(String birthdateStr) {
        this.birthdateStr = birthdateStr;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSexStr='" + userSexStr + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", birthdateStr='" + birthdateStr + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
