package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: NamePointTest
 * 
 * @Description: ʹ��@Aspectע���ע�����棬��ʾ�����е��ʹ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��10�� ����11:42:39
 */

@Aspect
public class NamePointAspect {
	/**
	 * 
	 * 
	 * @Title: pkgGreetTo
	 * 
	 * @Description: ������NamePoint.inPkgGreetTo()�е�
	 * 
	 * 
	 * @return: void
	 */
	@AfterReturning("NamePoint.inPkgGreetTo()")
	public void pkgGreetTo() {
		System.out.println("pkgGreetTo exectued ,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: pkgGreetToNotNaiveWaiter
	 * 
	 * @Description: �ڸ���������ʹ���������е�
	 * 
	 * 
	 * @return: void
	 */
	@AfterReturning("!target(com.xgj.aop.spring.advisor.aspectJAdvance.namePoint.NaiveWaiter) && NamePoint.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter() {
		System.out
				.println("pkgGreetToNotNaiveWaiter() executed,some logic is here");
	}
}
