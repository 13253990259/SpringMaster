package com.xgj.aop.spring.advisor.ComposablePointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {

	public Pointcut getIntersectionPointcut() {
		// ����һ�������е�
		ComposablePointcut composablePointcut = new ComposablePointcut();

		// ����һ�������е�
		Pointcut controlFlowPointcut = new ControlFlowPointcut(
				WaiterDelegate.class, "service");
		// ����һ���������е�
		NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
		nameMatchMethodPointcut.addMethodName("greetTo");

		// �������е���н�������
		return composablePointcut.intersection(controlFlowPointcut)
				.intersection((Pointcut) nameMatchMethodPointcut);

	}
}
