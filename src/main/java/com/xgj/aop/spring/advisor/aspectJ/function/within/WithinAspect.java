package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: WithinAspect
 * 
 * @Description: ��ע��@Aspect������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����1:21:17
 */

@Aspect
public class WithinAspect {

	// ƥ���κ�Ŀ����NaiveWaiter�����з���
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.NaiveWaiter)")
	// public void crossCuttingCode() {
	// System.out.println("������ǿ some logic is here\n");
	// }

	// ����ƥ���κ�Ŀ������κη���
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.Waiter)")
	// public void crossCuttingCode() {
	// System.out.println("������ǿ some logic is here\n");
	// }

	// ƥ��com.xgj.aop.spring.advisor.aspectJ.function.within���µ�����������з����������������
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.*)")
	// public void crossCuttingCode() {
	// System.out.println("������ǿ some logic is here\n");
	// }

	// ƥ��com.xgj.aop.spring.advisor.aspectJ.function.within���µ�����������з��������������
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within..*)")
	// public void crossCuttingCode() {
	// System.out.println("������ǿ some logic is here\n");
	// }

	@AfterReturning("within(@com.xgj.aop.spring.advisor.aspectJ.function.within.Mart *)")
	public void crossCuttingCode() {
		System.out.println("������ǿ some logic is here\n");
	}

}
