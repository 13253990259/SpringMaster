package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: AtTargetAspect
 * 
 * @Description: ��ע��@Aspect������ ������ǿ����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����11:59:26
 */

@Aspect
public class AtTargetAspect {

	@Around("@target(com.xgj.aop.spring.advisor.aspectJ.function.attarget.Mark)")
	public void crossCuttingCode(ProceedingJoinPoint joinPoint)
			throws Throwable {
		System.out.println("****AtTargetAspect.crossCuttingCode() : "
				+ joinPoint.getSignature().getName()
				+ ": Before Method Execution");
		try {
			joinPoint.proceed();
		} finally {
			// Do Something useful, If you have
		}
		System.out.println("****AtTargetAspect.crossCuttingCode() : "
				+ joinPoint.getSignature().getName()
				+ ": After Method Execution");
	}
}
