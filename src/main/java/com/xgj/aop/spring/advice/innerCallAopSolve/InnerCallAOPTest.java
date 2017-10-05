package com.xgj.aop.spring.advice.innerCallAopSolve;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerCallAOPTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advice/innerCallAopSolve/conf-advice.xml");
		NaiveWaiter waiter = ctx.getBean("naiveWaiter", NaiveWaiter.class);
		// ���������serveTo�ڲ�����greetTo�أ�
		waiter.serveTo("Xiao");
		
	}

}
