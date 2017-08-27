package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTestAspcetTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/aop/spring/advisor/aspectJ/function/annotationFun/conf-annotation.xml");

		// �����ǽӿ�����,����������ת���쳣,�����������ļ���<aop:aspectj-autoproxy
		// proxy-target-class="true"/> ��proxy-target-class����Ϊture
		NaiveWaiter naiveWaiter = (NaiveWaiter) ctx.getBean("naiveWaiter");

		// ��ΪgreetTo��ע��@NeedTest,��˻ᱻ������ǿ
		naiveWaiter.greetTo("XiaoGongJiang");
		naiveWaiter.serverTo("XiaoGongJiang");

		Waiter naughtWaiter = (Waiter) ctx.getBean("naughtWaiter");
		// serverTo��ע��@NeedTest,��˻ᱻ������ǿ
		naughtWaiter.serverTo("XiaoGongJiang");
	}
}
