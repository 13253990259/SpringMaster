package com.xgj.aop.spring.advisor.aspectJ.function.execution;

public class SmartSeller {

	/**
	 * public��������ʾexecution(public * *(..)),��ƥ�䵽
	 */
	public void sell(String goods) {
		System.out.println("SmartSeller sells " + goods);
	}

	/**
	 * 
	 * 
	 * @Title: smileTo
	 * 
	 * @Description: ��public��������ʾexecution(public * *(..))������ƥ�䵽
	 * 
	 * @param clientName
	 * 
	 * @return: void
	 */
	protected void smileTo(String clientName) {
		System.out.println("SmartSeller simles to " + clientName);
	}

}
