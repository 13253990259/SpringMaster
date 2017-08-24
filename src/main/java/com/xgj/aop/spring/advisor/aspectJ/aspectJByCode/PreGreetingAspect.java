package com.xgj.aop.spring.advisor.aspectJ.aspectJByCode;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: PreGreetingAspect
 * 
 * @Description: ������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��24�� ����3:21:15
 */

// ͨ��@Aspect��PreGreetingAspect��עΪһ������
@Aspect
public class PreGreetingAspect {

	// �����е����ǿ����
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {// ��ǿ�ĺ����߼�
		System.out.println("How are you ?");
	}
}
