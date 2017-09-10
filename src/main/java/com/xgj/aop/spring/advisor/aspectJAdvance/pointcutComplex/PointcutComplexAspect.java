package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: PointcutComplexAspect
 * 
 * @Description: ��ע��@Aspect������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��9�� ����1:50:45
 */

@Aspect
public class PointcutComplexAspect {

	/**
	 * 
	 * 
	 * @Title: matchGreetTo
	 * 
	 * @Description: ��Ԥ��,ƥ��com.xgj.aop.spring.advisor.aspectJAdvance.
	 *               pointcutComplex��������greetTo()�������е�
	 * 
	 * 
	 * @return: void
	 */
	@Before("within(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.*)"
			+ " && execution(* greetTo(..))")
	public void matchGreetTo() {
		System.out.println("matchGreetTo executed,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: something
	 * 
	 * @Description: ����Ԥ�㣬ƥ�����е�serverTo����,�Ҳ�λ��WaiterOneĿ�����е�
	 * 
	 * 
	 * @return: void
	 */

	@After("!target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.WaiterOne)"
			+ " && execution(* serverTo(..))")
	public void something() {
		System.out.println("something executed,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: method
	 * 
	 * @Description: �����㣬ƥ��IWaiter��ISeller�ӿ�ʵ�����������ӵ���е�
	 * 
	 * 
	 * @return: void
	 */

	@AfterReturning("target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.IWaiter)"
			+ " || target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.ISeller)")
	public void method() {
		System.out.println("method executed,some logic is here ");
	}

}
