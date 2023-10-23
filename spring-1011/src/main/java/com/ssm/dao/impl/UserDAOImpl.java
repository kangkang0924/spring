package com.ssm.dao.impl;

import com.ssm.dao.UserDAO;
import com.ssm.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTempLate;

    public void setJdbcTempLate(JdbcTemplate jdbcTempLate) {
        this.jdbcTempLate = jdbcTempLate;
    }


    @Override
    public boolean login(String loginName, String loginPwd) {
        // TODO Auto-generated method stub
        if (loginName.equals("admin") && loginPwd.equals("123456")) {
            return true;
        }
        return false;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into scott.userT(userName, password) values(?,?)";
        Object[] objects = new Object[]{user.getUserName(), user.getPassword()};
        int result = jdbcTempLate.update(sql, objects);
        return result;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }


}
