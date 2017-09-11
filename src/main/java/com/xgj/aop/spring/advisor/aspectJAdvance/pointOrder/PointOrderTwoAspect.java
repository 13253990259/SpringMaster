package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * 
 * 
 * @ClassName: PointOrderTwoAspect
 * 
 * @Description: @Aspect��ע������,ʵ��Ordered�ӿ� ��дgetOrder���� ���� ʹ��ע�� @Order(value = 2)
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��11�� ����1:36:02
 */

@Aspect
@Order(value = 2)
public class PointOrderTwoAspect {

	@Before("execution(* dealBussiness(..))")
	public void method4() {
		System.out.println("method4 executed");
	}

	@Before("execution(* dealBussiness(..))")
	public void method5() {
		System.out.println("method5 executed");
	}

}
