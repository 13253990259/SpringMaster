package com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: BindReturnValueAspect
 * 
 * @Description: @Aspect��ע�����棬
 * 
 *               �ں�����ǿ�У�����ͨ��returning�����ӵ㷽���ķ���ֵ
 * 
 *               (1)����(2)�������ֱ�����ͬ������(2)��retMsg�����ͱ�������ӵ㷽���ķ���ֵ����ƥ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����5:47:23
 */

@Aspect
public class BindReturnValueAspect {
	// (1)
	@AfterReturning(value = "target(com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue.BussinessRet)", returning = "retMsg")
	public void crossCuttingCode(String retMsg) {// (2)
		System.out.println("----bindReturnValue----");
		System.out.println("retMsg:" + retMsg);
		System.out.println("----bindReturnValue----");
	}
}
