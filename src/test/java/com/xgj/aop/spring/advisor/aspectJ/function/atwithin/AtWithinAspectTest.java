package com.xgj.aop.spring.advisor.aspectJ.function.atwithin;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtWithinAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/atwithin/conf-atwithin.xml");

		A0 a0 = ctx.getBean("a0", A0.class);
		A1 a1 = ctx.getBean("a1", A1.class);
		A2 a2 = ctx.getBean("a2", A2.class);
		A3 a3 = ctx.getBean("a3", A3.class);

		// A0û�б�ע@Mark�����ᱻ֯����ǿ
		a0.methodName();
		// A1��ע��@Mark���ᱻ֯����ǿ
		a1.methodName();
		// A2û�б�ע@Mark�����ᱻ֯����ǿ
		a2.methodName();
		// A3û�б�ע@Mark�����ᱻ֯����ǿ
		a3.methodName();
	}
}
