package com.spring.test;

import com.spring.entity.Medicine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ablaze
 * @Date: 2023/10/23/15:34
 */
public class Springtest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springBean.xml");

        Medicine medicineSet = (Medicine) ctx.getBean("medicineSet");
        System.out.println(medicineSet);

        Medicine medicine = (Medicine) ctx.getBean("medicine");

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
