package com.xgj.aop.spring.advisor.schema.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * 
 * @ClassName: GreetingBeforeAdvice
 * 
 * @Description: ǰ����ǿ
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����8:55:12
 */

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
