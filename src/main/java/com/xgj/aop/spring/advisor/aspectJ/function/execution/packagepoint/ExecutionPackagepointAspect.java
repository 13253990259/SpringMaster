package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: ExecutionPackagepointAspect
 * 
 * @Description: ����ģʽ����, .*��ʾ���µ��� ..*��ʾ����������µ�������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��29�� ����12:06:55
 */

@Aspect
public class ExecutionPackagepointAspect {

	@AfterReturning("execution(* com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean..*(..))")
	public void crossCuttingCode() {
		logic();
	}

	public void logic() {
		System.out.println("some logic is here \n");
	}
}
