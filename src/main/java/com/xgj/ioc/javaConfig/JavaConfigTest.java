package com.xgj.ioc.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTest {

	public static void main(String[] args) {
		// ͨ�����캯������������
		// ApplicationContext ctx = new AnnotationConfigApplicationContext(
		// Teacher.class);

		// AnnotationConfigApplicationContext ctx = new
		// AnnotationConfigApplicationContext();
		// ע��@Configuration�������࣬��ע����
		// ctx.register(Teacher.class);
		// ˢ��������Ӧ����Щע���������
		// ctx.refresh();

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/javaConfig/beans.xml");

		Teacher teacher = ctx.getBean("teacher", Teacher.class);
		teacher.arrangeStudent();

	}
}
