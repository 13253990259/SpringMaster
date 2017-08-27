package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: AnnotationTestAspect
 * 
 * @Description: ���� �� ������ǿ ,@annotation��ʾ��ע��ĳ��ע������з���
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��26�� ����11:23:53
 */

@Aspect
public class AnnotationTestAspect {

	@AfterReturning("@annotation(com.xgj.aop.spring.advisor.aspectJ.function.NeedTest)")
	public void needTest() {
		System.out.println("needTest() executed,some logic is here");
	}

}
