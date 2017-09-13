package com.xgj.aop.spring.advisor.aspectJAdvance.bindException;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: BindReturnValueAspect
 * 
 * @Description: @Aspect��ע�����棬
 *               ��ͨ���е㺯�������ӵ���Ϣ��ͬ�����ӵ��׳����쳣����ʹ��AfterThrowingע���throwing��Ա���а�
 * 
 *               (1)��throwingָ�����쳣����(2)����ε��쳣����ͬ������쳣��ǿֻ�����ӵ��׳����쳣instanceof
 *               IllegalArgumentException��ƥ�䣬��ǿ����ͨ��iae�������Է����׳����쳣����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����5:47:23
 */

@Aspect
public class BindExceptionAspect {
	// (1)
	@AfterThrowing(value = "target(com.xgj.aop.spring.advisor.aspectJAdvance.bindException.BussinessException)", throwing = "iae")
	public void crossCuttingCode(IllegalArgumentException iae) {// (2)
		System.out.println("----bindException()----");
		System.out.println("exception:" + iae.getMessage());
		System.out.println("----bindException()----");
	}
}
