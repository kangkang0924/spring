package com.ssm.entity;

public class User {
    private String userID;
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User [userID=" + userID + ", userName=" + userName + "]";
    }

}
