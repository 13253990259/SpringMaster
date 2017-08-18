package com.xgj.ioc.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ���������ļ�
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		// �������л�ȡʵ�������bean
		Boss boss = ctx.getBean("boss", Boss.class);
		Plane plane = ctx.getBean("plane", Plane.class);
		
		// ��������
		boss.setName("XGJ");
		boss.setSex("MALE");
		boss.setAge(20);
		boss.setPlane(plane);
		// ��������
		plane.setBrand("A380");
		plane.setColor("red");
		plane.setSpeed(900);
		// ���÷���
		boss.introduce();

	}

}
