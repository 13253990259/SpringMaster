package com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: LogicService
 * 
 * @Description: @Component��ע��Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����1:09:38
 */

@Component
public class LogicService {

	public void dealLogic(String bussiness) {
		System.out.println("deal Logic��" + bussiness);
	}
}
