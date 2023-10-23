package com.kangkang;

import com.kangkang.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;
/**
 * @author ablaze
 * @Date: 2023/10/11/13:47
 */
public class Test01 {


    @Test
    public void test01() {

        // 1. ��ȡ������������
        ApplicationContext context = new ClassPathXmlApplicationContext("chenxuanheapplicationContext.xml");

        // 2. ����id��ȡbean����
        ProductService service = (ProductService) context.getBean("userServiceImpl");
        service.browse();

        // 3.�ر�������������ǵùر�����������͵�����������ݿ����Ӳ����ͷţ�
        ((ClassPathXmlApplicationContext) context).close();

    }
}
