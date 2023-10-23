package com.test;

import com.ssm.dao.UserDAO;
import com.ssm.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "drop table scott.userT";
        jdbcTemplate.execute(sql);
        System.out.println("create table success");
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "create table scott.userT("
                + "id int primary key auto_increment,"
                + "userName varchar(20),"
                + "password varchar(32)"
                + ")";
        jdbcTemplate.execute(sql);
        System.out.println("create table success");
    }


    @Test
    public void test03() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDao = (UserDAO) ctx.getBean("userDao");

        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        int i = 0;
        for (int j = 1; j < 10; j++) {
            i = userDao.addUser(user);
        }

        if (i > 0) {

            System.out.println("插入了" + i + "条数据");
        } else {
            System.out.println("失败了");
        }
    }
}
