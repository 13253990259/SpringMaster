package com.xgj.ioc.configuration.lazyLoad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyLoadTest {

	public static void main(String[] args) {
		// ��ʼ������
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/lazyLoad/beans.xml");
	}
}
