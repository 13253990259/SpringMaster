package com.xgj.aop.spring.advisor.ControlFlowAdvisor;

public class WaiterDelegate {

	private Waiter waiter;

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	/**
	 * 
	 * 
	 * @Title: service
	 * 
	 * @Description: waiter���з����ĵ��ã�ͨ���÷�������
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void service(String name) {
		waiter.greetTo(name);
		waiter.serverTo(name);
	}

}
