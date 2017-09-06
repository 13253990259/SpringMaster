package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

/**
 * 
 * 
 * @ClassName: ThisAspect
 * 
 * @Description: @Aspectn��ע������
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����8:50:26
 */

@Aspect
public class ThisAspect implements Ordered {
	// ֯���κ������ڶ���ΪITransportService��Bean��
	@AfterReturning("this(com.xgj.aop.spring.advisor.aspectJ.function.thisFun.ITransportService)")
	public void corssCuttingCode() {
		System.out.println("some logic is here \n ");
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
