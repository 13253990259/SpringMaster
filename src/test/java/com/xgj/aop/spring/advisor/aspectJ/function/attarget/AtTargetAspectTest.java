package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtTargetAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/attarget/conf-attarget.xml");

		C0 c0 = ctx.getBean("c0", C0.class);
		C1 c1 = ctx.getBean("c1", C1.class);
		C2 c2 = ctx.getBean("c2", C2.class);
		C3 c3 = ctx.getBean("c3", C3.class);

		// C0û�б�ע��@Mark�����ᱻ֯����ǿ
		c0.methodName();
		// C1��ע��@Mark���ᱻ֯����ǿ
		c1.methodName();
		// C2��ע��@Mark���ᱻ֯����ǿ
		c2.methodName();
		// C3û�б�ע��@Mark�����ᱻ֯����ǿ
		c3.methodName();
	}
}
