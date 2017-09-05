package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaughtyWaiter
 * 
 * @Description: @Component��ע��bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����1:31:10
 */

@Component
public class NaughtyWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NaughtyWaiter greetTo " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NaughtyWaiter greetTo " + clientName);
	}

}
