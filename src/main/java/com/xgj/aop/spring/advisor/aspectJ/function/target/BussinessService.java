package com.xgj.aop.spring.advisor.aspectJ.function.target;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessService
 * 
 * @Description: @Component��ע��bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����8:18:03
 */

@Component
public class BussinessService {

	public String doSomething() {
		System.out.println("doSomething executed");
		return "success";
	}
}
