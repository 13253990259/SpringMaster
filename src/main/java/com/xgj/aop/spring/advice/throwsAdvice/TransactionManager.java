package com.xgj.aop.spring.advice.throwsAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class TransactionManager implements ThrowsAdvice {
	/**
	 * �����쳣����ӡ�쳣����
	 * 
	 * @param method
	 *            Ŀ������Ӧ����
	 * @param args
	 *            �������
	 * @param target
	 *            Ŀ�����
	 * @param ex
	 *            ���з�����������쳣
	 * @throws Throwable
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		System.out.println("method:" + method.getName());
		System.out.println("�׳��쳣��" + ex.getMessage());
		System.out.println("�ɹ��ع�����");
	}
}
