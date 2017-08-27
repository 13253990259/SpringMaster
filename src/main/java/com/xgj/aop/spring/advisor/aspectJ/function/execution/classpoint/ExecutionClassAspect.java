package com.xgj.aop.spring.advisor.aspectJ.function.execution.classpoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionClassAspect {
	/**
	 * 
	 * 
	 * @Title: crossCuttingCode
	 * 
	 * @Description: ������ǿ�����߼�����
	 * 
	 * 
	 * @return: void
	 */
	@AfterReturning("execution(* com.xgj.aop.spring.advisor.aspectJ.function.execution.classpoint.Cleaner.*(..))")
	public void crossCuttingCode() {
		System.out.println("some logic is here\n");
	}

}
