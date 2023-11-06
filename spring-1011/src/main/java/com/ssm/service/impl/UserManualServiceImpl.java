package com.ssm.service.impl;

import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.TransactionStatus;
import com.ssm.dao.UserDAO;
import com.ssm.service.UserService;

public class UserManualServiceImpl implements UserService {

	UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// 注入TransactionTemplate对象
	private TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public boolean login(String loginName, String loginPwd) {
		return false;
	}

	@Override
	public void transMoney(int fromID, int toID) {
		// TODO Auto-generated method stub
		transactionTemplate.execute(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus status) {
				Object result = null;
				try {
					userDAO.updateMoney(1500, 2);
					//int i = 10 / 0;
					userDAO.updateMoney(3000, 3);
				} catch (Exception e) {
					status.setRollbackOnly();
					result = false;
					System.out.println("Transfer Error!");
				}
				return result;
			}
		});

	}
}
