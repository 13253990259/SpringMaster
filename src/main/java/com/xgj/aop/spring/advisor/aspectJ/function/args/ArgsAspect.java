package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ArgsAspectJ
 * 
 * @Description: �ú�������һ����������ʾĿ���෽����ζ�����ָ���ࣨ�������ࣩʱ���е�ƥ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��1�� ����11:36:23
 */

@Aspect
public class ArgsAspect {

	@Before("args(com.xgj.aop.spring.advisor.aspectJ.function.args.User)")
	public void crossCuttingCode() {
		System.out.println("some logic is here ");
	}
}
