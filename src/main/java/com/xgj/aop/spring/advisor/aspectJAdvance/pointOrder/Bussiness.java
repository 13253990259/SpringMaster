package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: Bussiness
 * 
 * @Description: @Component��ע��Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��11�� ����1:38:06
 */

@Component
public class Bussiness {

	public void dealBussiness() {
		System.out.println("dealBussiness executed");
	}
}
