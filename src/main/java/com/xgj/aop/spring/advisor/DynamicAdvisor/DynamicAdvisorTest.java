package com.xgj.aop.spring.advisor.DynamicAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicAdvisorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/DynamicAdvisor/conf-dynamicAdvisor.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		// list�е�����ͻ�
		waiter.greetTo("XiaoGongJiangOne");
		waiter.serverTo("XiaoGongJiangOne");
		// list�е�����ͻ�
		waiter.greetTo("XiaoGongJiangTwo");
		waiter.serverTo("XiaoGongJiangTwo");
		// ����list�еĿͻ�
		waiter.greetTo("Smart");
		waiter.serverTo("Smart");

	}
}
