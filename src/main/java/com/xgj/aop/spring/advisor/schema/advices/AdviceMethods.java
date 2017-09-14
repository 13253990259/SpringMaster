package com.xgj.aop.spring.advisor.schema.advices;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods {
	/**
	 * 
	 * 
	 * @Title: before
	 * 
	 * @Description: ǰ����ǿ��Ӧ�ķ���
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void beforeMethod() {
		System.out.println("--Before CrossCuttingCode--");
	}

	/**
	 * 
	 * 
	 * @Title: afterReturning
	 * 
	 * @Description: ������ǿ��Ӧ���� ,�����ļ��е�returing���Ա������ǿ�������������һ��
	 * 
	 * @param retVal
	 * 
	 * @return: void
	 */
	public void afterReturningMethod(int retVal) {
		System.out.println("----afterReturning() begin----");
		System.out.println("returnValue:" + retVal);
		System.out.println("----afterReturning() end----");
	}

	/**
	 * 
	 * 
	 * @Title: aroundMethod
	 * 
	 * @Description: ������ǿ��Ӧ����
	 * 
	 * @param pjp
	 * 
	 * @return: void
	 * @throws Throwable
	 */
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----aroundMethod() begin----");
		System.out.println("args[0]:" + pjp.getArgs()[0]);
		// ִ��Ŀ�����Ŀ�귽��
		pjp.proceed();
		System.out.println("----aroundMethod() end----");
	}

	/**
	 * 
	 * 
	 * @Title: afterThrowingMethod
	 * 
	 * @Description: �׳��쳣��ǿ
	 * 
	 * @param iae
	 * 
	 * @return: void
	 */
	public void afterThrowingMethod(IllegalArgumentException iae) {
		System.out.println("----afterThrowingMethod()----");
		System.out.println("exception msg:" + iae.getMessage());
		System.out.println("----afterThrowingMethod()----");
	}

	/**
	 * 
	 * 
	 * @Title: afterMethod
	 * 
	 * @Description: final��ǿ
	 * 
	 * 
	 * @return: void
	 */
	public void afterMethod() {
		System.out.println("----afterMethod()----");
	}
}
