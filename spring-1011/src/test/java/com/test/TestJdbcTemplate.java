package com.test;

import com.ssm.dao.UserDAO;
import com.ssm.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.function.Consumer;

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
        String sql = "create table scott.usert("
                + "id int primary key auto_increment,"
                + "userName varchar(20),"
                + "password varchar(32),"
                + "money int"
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

    @Test
    public void test04() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDao = (UserDAO) ctx.getBean("userDao");

        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        user.setPassword("123456");
        int result = userDao.updateUser(user);
        if (result > 0) {

            System.out.println("成功修改了了" + result + "条数据");
        } else {
            System.out.println("失败了");
        }
    }

    @Test
    public void deleteUserTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDao");

        int result = userDAO.deleteUser(1);

        if (result > 0) {
            System.out.println("成功删除了" + result + "条数据");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void findUserByIdTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDao");

        User user = userDAO.findUserById(2);
        System.out.println(user);

    }

    @Test
    public void findAllUserTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDao");

        List<User> allUser = userDAO.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        allUser.forEach(System.out::println);
        allUser.forEach(user -> System.out.println(user));
        allUser.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });
    }
}

