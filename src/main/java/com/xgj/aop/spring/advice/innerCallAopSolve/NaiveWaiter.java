package com.xgj.aop.spring.advice.innerCallAopSolve;

import com.xgj.aop.spring.advice.innerCallAopSolve.innerCallAOPInterceptor.BeanSelfProxyAware;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: ���AOP�ڲ������޷�֯������⣬ʵ���Զ����BeanSelfProxyAware�ӿ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��5�� ����1:50:58
 */
public class NaiveWaiter implements BeanSelfProxyAware {

	private NaiveWaiter waiter;

	public void setSelfProxy(Object object) {
		waiter = (NaiveWaiter) object;
	}

	public void serveTo(String name) {
		System.out.println("waiter serving " + name + "...");
		// ����ʹ��waiter���������ã� ���ֱ��ʹ��greetTo���൱����this.greetTo���ڲ����ã��޷�AOP֯��
		waiter.greetTo(name);
	}

	public void greetTo(String name) {
		System.out.println("waiter greet to "+name+"...");
	}



}
