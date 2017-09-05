package com.xgj.aop.spring.advisor.aspectJ.function.within.seller;

import org.springframework.stereotype.Component;

import com.xgj.aop.spring.advisor.aspectJ.function.within.Mart;

/**
 * 
 * 
 * @ClassName: SmartSeller
 * 
 * @Description: @Component��ע��Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����1:30:52
 */

@Mart
@Component
public class SmartSeller {

	public void jokeTo(String clientName) {
		System.out.println("SmartSeller greetTo " + clientName);
	}

	public void smileTo(String clientName) {
		System.out.println("SmartSeller serverTo " + clientName);

	}

}
