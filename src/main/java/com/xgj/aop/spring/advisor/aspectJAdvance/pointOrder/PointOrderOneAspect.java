package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * 
 * 
 * @ClassName: PointOrderOneAspect
 * 
 * @Description: @Aspect��ע������,ʵ��Ordered�ӿ� ��дgetOrder���� ���� ʹ��ע�� @Order(value = 1)
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��11�� ����1:35:42
 */

@Aspect
@Order(value = 1)
public class PointOrderOneAspect {

	@Before("execution(* dealBussiness(..))")
	public void method1() {
		System.out.println("method1 executed");
	}

	@Before("execution(* dealBussiness(..))")
	public void method2() {
		System.out.println("method2 executed");
	}

	@Before("execution(* dealBussiness(..))")
	public void method3() {
		System.out.println("method3 executed");
	}

}
