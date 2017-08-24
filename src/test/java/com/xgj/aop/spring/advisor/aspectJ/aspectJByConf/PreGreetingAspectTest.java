package com.xgj.aop.spring.advisor.aspectJ.aspectJByConf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: PreGreetingAspectTest
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��24�� ����3:21:29
 */
public class PreGreetingAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/aspectJByConf/conf-aspectJ.xml");

		Waiter naiveWaiter = ctx.getBean("waiter", Waiter.class);

		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");
	}
}
