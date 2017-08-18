package com.xgj.ioc.inject.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectTest {

	public static void main(String[] args) {
		// ���������ļ�,ʵ����bean
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/set/plane.xml");
		// �������л�ȡbean
		Plane plane = ctx.getBean("plane",Plane.class);
		// ���÷���
		plane.introduce();
	}

}
