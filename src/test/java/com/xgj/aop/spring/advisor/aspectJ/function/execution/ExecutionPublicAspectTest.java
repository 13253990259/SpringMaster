package com.xgj.aop.spring.advisor.aspectJ.function.execution;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: ExecutionPublicAspectTest
 * 
 * @Description: execution(public * *(..)) ������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��27�� ����1:52:25
 */
public class ExecutionPublicAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/execution/conf-execution.xml");

		SmartSeller smartSeller = (SmartSeller) ctx.getBean("smartSeller");
		// sell������public,��֯��ǰ����ǿ�еĺ����߼�
		smartSeller.sell("bread");
		// smileTo������protec,����֯��ǰ����ǿ�еĺ����߼�
		smartSeller.smileTo("XiaoGongJiang");

		NaiveWaiter naiveWaiter = (NaiveWaiter) ctx.getBean("naiveWaiter");
		// greetTo������public,��֯��ǰ����ǿ�еĺ����߼�
		naiveWaiter.greetTo("XiaoGongJiang");

	}

}
