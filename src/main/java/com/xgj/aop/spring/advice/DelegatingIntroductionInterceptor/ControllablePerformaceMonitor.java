package com.xgj.aop.spring.advice.DelegatingIntroductionInterceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformaceMonitor extends
		DelegatingIntroductionInterceptor implements Monitorable {

	private static final long serialVersionUID = 1L;
	// ����ThreadLocal���͵ı��������ڱ������ܼ��ӿ���״̬�� Ϊ�˽����ʵ���̰߳�ȫ�����⣬ͨ��ThreadLocal
	// ��ÿ���̵߳���ʹ��һ��״̬
	private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

	@Override
	public void setMonitorActive(boolean active) {
		MonitorStatusMap.set(active);
	}

	/**
	 * ���ط���
	 */
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		// ����֧���¸��Ǹ����ӿɿش���ͨ���ж���״̬�����Ƿ������ܼ�ع���
		// Java5.0���Զ�������ܣ�get�������ص�Boolean���Զ����Ϊboolean���͵�ֵ
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}

}
