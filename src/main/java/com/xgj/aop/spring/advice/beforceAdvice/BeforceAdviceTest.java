package com.xgj.aop.spring.advice.beforceAdvice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforceAdviceTest {
	@Test
	public void test() {
		// ����Ŀ�����
		Waiter target = new NaiveWaiter();
		// ������ǿ�����
		BeforeAdvice advice = new GreetingBeforeAdvice();

		// (1)�������������� - Spring�ṩ�Ĵ�����
		ProxyFactory factory = new ProxyFactory();

		// (2)���ô���Ŀ��
		factory.setTarget(target);

		// (3)Ϊ����Ŀ�������ǿ
		factory.addAdvice(advice);

		// (4)��ȡ������
		Waiter proxy = (Waiter) factory.getProxy();

		// ����Ŀ���෽��
		proxy.greetTo("Xiao");
		proxy.serverTo("GongJiang");
	}
}
