package com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindJointPointParameterAspect
 * 
 * @Description: @Aspect��ע������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����1:10:40
 */

@Aspect
public class BindJointPointParameterAspect {
	// �ٰ����ӵ����������args(name,number,..)���ݢڴ�����ǿ��������ҵ�name��number��Ӧ�����ͣ��Եõ���ʵ���е���ʽ��
	// target(com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter.LogicBindService)
	// && args(String,int,..)
	// �ڸ���ǿ����֯�뵽Ŀ�����ӵ�ʱ����ǿ��������ͨ��num��name���ʵ����ӵ㷽������Ρ�
	@Before("target(com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter.LogicBindService) && args(name,number,..)")
	public void crossCodeCutting(int number, String name) throws Throwable { // ����ǿ�����������ӵ�Ĳ���
		System.out.println("----bindJoinPointParams()----");
		System.out.println("name:" + name);
		System.out.println("number:" + number);
		System.out.println("----bindJoinPointParams()----");
	}
}
