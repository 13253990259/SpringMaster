package com.xgj.aop.spring.advisor.aspectJAdvance.bindProxyObj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindProxyObjAspect
 * 
 * @Description: �󶨴������
 *               ʹ��this()��target()�ɰ󶨱��������ʵ������ͨ����ʵ�����󶨶���ʱ������Ȼ����ԭ�����ӵ�ƥ��Ĺ��ܣ�
 *               ֻ����������ͨ����ǿ������ͬ����ε����ͼ�Ӿ�������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����12:04:44
 */

@Aspect
public class BindProxyObjAspect {
	// (1)��ͨ���ڴ����ҳ�waiter��Ӧ������ΪBussinessLogicService������е���ʽ
	// Ϊthis(bussinessLogicService)������ǿ����֯��Ŀ�����ӵ�ʱ����ǿ����ͨ��bussinessLogicService
	// ��ο������õ���������ʵ����
	@Before("this(bussinessLogicService)")
	public void bindProxyObj(BussinessLogicService bussinessLogicService) { // (2)
		System.out.println("----bindProxyObj()----");
		System.out.println(bussinessLogicService.getClass().getName());
		System.out.println("----bindProxyObj()----");
	}

}
