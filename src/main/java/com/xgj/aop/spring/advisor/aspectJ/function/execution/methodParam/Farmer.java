package com.xgj.aop.spring.advisor.aspectJ.function.execution.methodParam;

/**
 * 
 * 
 * @ClassName: Farmer
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��30�� ����11:31:20
 */

public class Farmer {

	public void doSomething(String farm, int time) {
		System.out.println("Farmer do someThing and it costs " + time
				+ " minutes");
	}

}
