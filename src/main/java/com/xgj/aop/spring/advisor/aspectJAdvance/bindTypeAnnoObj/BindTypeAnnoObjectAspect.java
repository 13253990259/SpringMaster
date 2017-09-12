package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindTypeAnnoObjectAspect
 * 
 * @Description: @Aspect��ע������
 * 
 *               (1)ͨ��(2)�����ҳ�m��ӦMonitor���͵�ע�⣬ �����ʵ���е���ʽΪ@within
 *               (Monitor)������ǿ����֯��Ŀ�� ���ӵ�ʱ����ǿ����ͨ��m��ο������õ����ӵ㴦��ע�����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����4:27:55
 */

@Aspect
public class BindTypeAnnoObjectAspect {
	// (1)
	@Before("@within(m)")
	public void bindTypeAnno(Monitor m) { // (2)
		System.out.println("----bindTypeAnnoObject()----");
		System.out.println(m.getClass().getName());
		System.out.println("----bindTypeAnnoObject()----");
	}
}
