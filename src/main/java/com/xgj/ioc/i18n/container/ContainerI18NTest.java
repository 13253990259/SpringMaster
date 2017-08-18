package com.xgj.ioc.i18n.container;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerI18NTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/i18n/container/beans.xml");
		// ��̬����
		Object[] params = { "XiaoGongJiang", new GregorianCalendar().getTime() };
		// ֱ��ͨ���������ʹ��ʻ���Ϣ
		String msg1 = ctx.getMessage("greeting.common", params, Locale.US);
		String msg2 = ctx.getMessage("greeting.morning", params, Locale.CHINA);
		System.out.println(msg1);
		System.out.println(msg2);
	}
}
