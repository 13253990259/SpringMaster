package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: ExecutionPackagepointAspect2
 * 
 * @Description: `execution(*
 *               com..*Dao.find*(..))`ƥ�����ǰ׺Ϊcom���κΰ���������׺ΪDao�ķ�����������������findΪǰ׺
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��30�� ����10:38:59
 */

@Aspect
public class ExecutionPackagepointAspect2 {

	@AfterReturning("execution(* com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint..*Service.remove*(..))")
	public void crossCuttingCode() {
		logic();
	}

	public void logic() {
		System.out
				.println("ƥ��com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint ���������������Service��β����ķ������÷���������remove��ͷ"
						+ " some logic is here \n");
	}
}
