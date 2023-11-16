package com.ssm.dao.impl;

import com.ssm.dao.HandekangDAO;
import com.ssm.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2023/11/16/8:56
 */
public class HandekangDAOImpl implements HandekangDAO {
    private JdbcTemplate jdbcTempLate;

    public void setJdbcTempLate(JdbcTemplate jdbcTempLate) {
        this.jdbcTempLate = jdbcTempLate;
    }
    @Override
    public int addUser(User user) {
        String sql = "insert into scott.userT(userName, password) values(?,?)";
        Object[] objects = new Object[]{user.getUserName(), user.getPassword()};
        int result = jdbcTempLate.update(sql, objects);
        return result;
    }
}
