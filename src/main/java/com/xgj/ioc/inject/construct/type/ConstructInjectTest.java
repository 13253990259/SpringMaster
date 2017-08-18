package com.xgj.ioc.inject.construct.type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		// ���������ļ�,ʵ����Bean
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/type/tank.xml");
		// �������л�ȡBean
		Tank tank = ctx.getBean("tank", Tank.class);
		
		tank.introduce();
	}

}
