package com.xgj.aop.spring.advisor.aspectJ.aspectJByCode;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 
 * 
 * @ClassName: PreGreetingAspectTest
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��24�� ����3:21:29
 */
public class PreGreetingAspectTest {

	@Test
	public void test() {
		// Ŀ����
		Waiter target = new NaiveWaiter();
		// ʵ�������������
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		// ����Ŀ�����
		aspectJProxyFactory.setTarget(target);
		// ���������
		aspectJProxyFactory.addAspect(PreGreetingAspect.class);
		// ����֯������Ĵ������
		Waiter proxy = aspectJProxyFactory.getProxy();
		// ����ҵ�񷽷�
		proxy.greetTo("XiaoGongJiang");
		proxy.serverTo("XiaoGongJiang");
	}
}
