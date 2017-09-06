package com.xgj.aop.spring.advisor.aspectJ.function.target;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: TargetAspect
 * 
 * @Description: @Aspect��ע������
 *               target(com.xgj.aop.spring.advisor.aspectJ.function.
 *               target.Class1)��ͬ��
 *               target(com.xgj.aop.spring.advisor.aspectJ.function
 *               .target.Class1+)
 * 
 *               target(com.xgj.IBussiness)
 *               ��IBussinessΪ�ӿڣ�ƥ��ӿ�ʵ���������з���������δ�ڽӿ��������ķ���
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����7:53:52
 */

@Aspect
public class TargetAspect {

	@AfterReturning("target(com.xgj.aop.spring.advisor.aspectJ.function.target.IBussinessService)")
	public void crossCuttingCode() {
		System.out.println("some logic is here");
	}
}
