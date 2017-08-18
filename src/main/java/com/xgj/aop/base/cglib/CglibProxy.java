package com.xgj.aop.base.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		// ������Ҫ�������������
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// ͨ���ֽ��붯̬��������ʵ��
		return enhancer.create();

	}

	// ���ظ������з����ĵ���
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// �����߼�����
		PerformanceMonitor.begin(obj.getClass().getName() + "."
				+ method.getName());
		// ҵ���߼���ͨ����������ø����еķ���
		Object result = proxy.invokeSuper(obj, args);
		// �����߼�����
		PerformanceMonitor.end();
		return result;
	}

}
