package com.xgj.aop.spring.advisor.aspectJAdvance.bindProxyObj;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessLogicService
 * 
 * @Description: @Component��ע��bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����12:11:28
 */

@Component
public class BussinessLogicService {

	public void doLogic() {
		System.out.println("BussinessLogicService doLogic executed ");
	}
}
