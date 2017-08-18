package com.xgj.aop.base.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

	private Object target;

	/**
	 * 
	 * 
	 * @Title:PerformanceHandler
	 * 
	 * @Description:���캯���� ���targetΪҵ��Ŀ����
	 * 
	 * @param target
	 */
	public PerformanceHandler(Object target) {
		this.target = target;
	}

	// ���ܼ��ӵĺ��д��� + ҵ�����
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ��ʼ��� ��� ������ȫ�޶�����
		PerformanceMonitor.begin(target.getClass().getName() + "."
				+ method.getName());
		// ͨ���������ҵ�����Ŀ�귽��
		Object object = method.invoke(target, args);
		// �������
		PerformanceMonitor.end();
		return object;
	}
}
