package com.xgj.aop.spring.advice.methodInterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
	/**
	 * ��ȡĿ���෽����ִ�У�����ǰ����Ӻ����߼�
	 * 
	 * @param invocation
	 *            ��װ��Ŀ�귽������������Լ�Ŀ�귽��������ʵ������
	 * @return �������
	 * @throws Throwable
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// ��ȡĿ�귽�������
		Object[] args = invocation.getArguments();
		// ��Ŀ�귽��ִ��ǰ����
		String clientName = (String) args[0];
		System.out.println("GreetingInterceptor��How are you!" + clientName);
		// ���÷������������Ŀ�귽��
		Object object = invocation.proceed();
		// ��Ŀ�귽��ִ�к����
		System.out.println("GreetingInterceptor: please enjoy youself!");
		return object;
	}

}
