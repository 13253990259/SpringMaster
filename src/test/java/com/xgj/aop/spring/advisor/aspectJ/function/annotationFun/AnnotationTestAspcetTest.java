package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.aop.spring.advisor.aspectJ.function.Waiter;

public class AnnotationTestAspcetTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/annotationFun/conf-annotation.xml");

		// �����ǽӿ�����,����������ת���쳣
		Waiter waiter = (Waiter) ctx.getBean("naiveWaiter");

		// ��ΪgreetTo��ע��@NeedTest,��˻ᱻ������ǿ
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");

		Waiter naughtWaiter = (Waiter) ctx.getBean("naughtWaiter");
		// serverTo��ע��@NeedTest,��˻ᱻ������ǿ
		naughtWaiter.serverTo("XiaoGongJiang");
	}
}
