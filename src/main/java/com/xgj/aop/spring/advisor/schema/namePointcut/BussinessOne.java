package com.xgj.aop.spring.advisor.schema.namePointcut;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessOne
 * 
 * @Description: ʹ��ע�ⶨ���Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����5:17:24
 */

@Component
public class BussinessOne {

	public void program() {
		System.out.println("BussinessOne program executed");
	}

	public void fixBug() {
		System.out.println("BussinessOne fixBug executed");
	}
}
