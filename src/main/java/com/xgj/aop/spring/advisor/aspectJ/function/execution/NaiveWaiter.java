package com.xgj.aop.spring.advisor.aspectJ.function.execution;

public class NaiveWaiter {

	/**
	 * public��������ʾexecution(public * *(..)),��ƥ�䵽
	 */
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greet to " + clientName);
	}

}
