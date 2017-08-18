package com.xgj.aop.spring.advice.afterRetruingAdivce;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {

	/**
	 * ������ǿ����ʵ�֣���Ŀ�귽��ִ�к����
	 * 
	 * @param returnValue
	 *            �����ض���
	 * @param method
	 *            Ŀ����󷽷�
	 * @param args
	 *            Ŀ����󷽷�����
	 * @param target
	 *            Ŀ�����
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {

		System.out.println("please enjoy youself,Sir!");
	}

}
