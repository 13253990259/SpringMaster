package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: @Component��ע��Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����1:30:52
 */

@Component
public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greetTo " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NaiveWaiter serverTo " + clientName);

	}

}
