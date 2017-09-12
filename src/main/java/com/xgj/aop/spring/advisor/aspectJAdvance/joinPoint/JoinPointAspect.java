package com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: JoinPointAspect
 * 
 * @Description: @Aspect��ע������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����1:10:40
 */

@Aspect
public class JoinPointAspect {
	// ������ǿ
	@Around("execution(* dealLogic(..)) && target(com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint.LogicService)")
	public void crossCodeCutting(ProceedingJoinPoint pjp) throws Throwable { // �������ӵ����
		System.out.println("-------ProceedingJoinPoint begin----------");
		// �������ӵ���Ϣ
		System.out.println("arg[0]:" + pjp.getArgs()[0]);
		System.out.println("signature:" + pjp.getTarget().getClass());
		// ͨ�����ӵ�ִ��Ŀ�����ķ���
		pjp.proceed();
		System.out.println("-------ProceedingJoinPoint end----------");

	}
}
