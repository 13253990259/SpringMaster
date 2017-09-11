package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: @Componentע���ע��bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��10�� ����11:55:00
 */

@Component
public class NaiveWaiter {

	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greetTo " + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("NaiveWaiter serverTo " + clientName);
	}
}
