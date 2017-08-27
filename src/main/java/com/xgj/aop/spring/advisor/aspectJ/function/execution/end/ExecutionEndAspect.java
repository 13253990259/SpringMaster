package com.xgj.aop.spring.advisor.aspectJ.function.execution.end;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionEndAspect {

	@AfterReturning("execution(* *To(..))")
	public void crossCuttingCode() {
		System.out.println("������ǿ���д���,some logic is here \n ");
	}
}
