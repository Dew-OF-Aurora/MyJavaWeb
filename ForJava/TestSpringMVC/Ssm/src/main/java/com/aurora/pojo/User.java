package com.aurora.pojo;

public class User {

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public User(String userId, String cardType, String cardNo, String userName, String userSex, String userAge, String userRole) {
        this.userId = userId;
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userRole = userRole;
    }

    private String userId;

    private String cardType;

    private String cardNo;

    private String userName;

    private String userSex;

    private String userAge;

    private String userRole;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }
}