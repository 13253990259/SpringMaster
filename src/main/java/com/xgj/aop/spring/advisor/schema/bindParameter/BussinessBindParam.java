package com.xgj.aop.spring.advisor.schema.bindParameter;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessBindParam
 * 
 * @Description: ʹ��ע�ⶨ���Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����8:25:23
 */

@Component
public class BussinessBindParam {

	public void program(String name, int number) {
		System.out.println("BussinessBindParam program execute");
		System.out.println("program��" + name + ", number:" + number);
	}

	public void fixbug(String name, int number, double salary) {
		System.out.println("BussinessBindParam fixBug executed");
		System.out.println("program��" + name + ", number:" + number + ",salary"
				+ salary);
	}
}
