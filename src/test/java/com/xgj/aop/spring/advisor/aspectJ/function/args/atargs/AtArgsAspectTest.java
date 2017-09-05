package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtArgsAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/atargs/conf-atargs.xml");

		T0 t0 = ctx.getBean("t0", T0.class);
		T1 t1 = ctx.getBean("t1", T1.class);
		T2 t2 = ctx.getBean("t2", T2.class);
		T3 t3 = ctx.getBean("t3", T3.class);

		// ��t1�е�fun���Ϊt2,��ע���ע����T2���ϣ�t3����t2�����࣬���� �����������ö���֯����ǿ
		t1.fun(t2);
		t1.fun(t3);

	}
}
