package com.ssm.service;

public interface UserService {
    public boolean login(String loginName, String loginPwd);
    public void transMoney(int fromID,int toID);
}
