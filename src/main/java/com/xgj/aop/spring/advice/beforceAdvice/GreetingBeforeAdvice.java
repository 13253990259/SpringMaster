package com.xgj.aop.spring.advice.beforceAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	/**
	 * ǰ����ǿ���� ���÷��������쳣ʱ������ֹĿ�귽����ִ��
	 * 
	 * @param method
	 *            Ŀ���෽��
	 * @param objects
	 *            Ŀ���෽�����
	 * @param target
	 *            Ŀ�������ʵ��
	 * @throws Throwable
	 */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		String clientName = (String) args[0];
		System.out.println("How are you " + clientName + " ?");
	}
}
