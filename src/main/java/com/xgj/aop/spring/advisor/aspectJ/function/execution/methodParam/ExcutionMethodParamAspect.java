package com.xgj.aop.spring.advisor.aspectJ.function.execution.methodParam;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ExcutionMethodParamAspect
 * 
 * @Description: �е���ʽ�еķ�����β��ֱȽϸ��ӣ�����ʹ��*��..ͨ����� ���� *��ʾ����������͵Ĳ�����
 *               ��..��ʾ�������͵Ĳ����Ҳ����������ޡ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��30�� ����11:33:35
 */

@Aspect
public class ExcutionMethodParamAspect {

	@Before("execution(* doSomething(String,int))")
	public void crossCuttingCode() {
		System.out.println("some logic is here ");
	}
}
