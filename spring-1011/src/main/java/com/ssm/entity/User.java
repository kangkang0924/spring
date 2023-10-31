package com.ssm.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private int money;

    public User(Integer userID, String userName) {
        this.id = userID;
        this.userName = userName;
    }

    public User() {

    }


}
