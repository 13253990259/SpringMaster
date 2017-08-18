package com.xgj.aop.base.jdkproxy;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

	public static void main(String[] args) {
		// ϣ���������Ŀ��ҵ����
		ForumService target = new ForumServiceImpl();

		// ��Ŀ����ҵ��ͺ��д����֯��һ��
		PerformanceHandler handler = new PerformanceHandler(target);
		// ���ݱ�֯��Ŀ��ҵ�����߼������ܼ�غ����߼���InvocationHandlerʵ����������ʵ��
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);

		// ���ô���ʵ��
		proxy.removeTopic(3);
		proxy.removeForum(1);

	}
}
