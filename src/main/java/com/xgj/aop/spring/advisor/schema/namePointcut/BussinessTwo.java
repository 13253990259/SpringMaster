package com.xgj.aop.spring.advisor.schema.namePointcut;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessTwo
 * 
 * @Description: ʹ��ע�ⶨ���Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����5:17:33
 */

@Component
public class BussinessTwo {
	public void program() {
		System.out.println("BussinessOne program executed");
	}

	public void fixBug() {
		System.out.println("BussinessOne fixBug executed");
	}
}
