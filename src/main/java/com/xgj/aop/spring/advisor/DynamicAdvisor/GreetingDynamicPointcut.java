package com.xgj.aop.spring.advisor.DynamicAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

	public static List<String> specialClientList = new ArrayList<String>();

	static {
		specialClientList.add("XiaoGongJiangOne");
		specialClientList.add("XiaoGongJiangTwo");
	}

	/**
	 * ��1��������о�̬�е���
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("����getClassFilter()�� �ࡾ " + clazz.getName()
						+ "������̬���\n");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

	/**
	 * ��2���Է������о�̬�е���
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out
				.println("����matches(Method method, Class<?> targetClass),�Է�����"
						+ targetClass.getName() + "." + method.getName()
						+ "������̬���\n");
		return "greetTo".equals(method.getName());
	}

	/**
	 * ��3���Է������ж�̬�е���
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out
				.println("����matches(Method method, Class<?> targetClass, Object... args)�Է�����"
						+ targetClass.getName()
						+ "."
						+ method.getName()
						+ "������̬���\n");
		String clientName = (String) args[0];
		return specialClientList.contains(clientName);
	}
}
