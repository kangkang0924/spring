package com.ssm.dao.impl;

import com.ssm.dao.UserDAO;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAOimpl implements UserDAO{

	@Override
	public boolean login(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		if(loginName.equals("admin") && loginPwd.equals("123456")) {
			return true;
		}
		return false;
	}
    
	
}
