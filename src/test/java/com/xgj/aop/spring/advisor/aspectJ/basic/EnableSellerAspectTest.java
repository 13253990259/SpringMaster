package com.xgj.aop.spring.advisor.aspectJ.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnableSellerAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/basic/conf-aspectJ.xml");

		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		waiter.greetTo("XiaoGongJiang");
		// ���Գɹ��Ľ���ǿ������ת��
		Seller seller = (Seller) waiter;
		seller.sell("beer", "XiaoGongJiang");
	}
}
