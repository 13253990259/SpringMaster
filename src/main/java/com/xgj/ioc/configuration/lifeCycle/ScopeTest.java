package com.xgj.ioc.configuration.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

	public static void main(String[] args) {
		// ��������
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/lifeCycle/beanLifeCycle.xml");

		System.out.println("isPrototype:" + ctx.isPrototype("teacher"));
		System.out.println("isSingleton:" + ctx.isSingleton("teacher"));
		// �ر�����������singleton��Bean����������prototype�ɵ����߹���Spring������
		((ClassPathXmlApplicationContext) ctx).destroy();

	}
}
