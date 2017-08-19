package com.xgj.aop.spring.advisor.RegexpMethodPointcutAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @ClassName: RegexpMethodPointcutAdvisorTest
 * 
 * @Description: ��Ԫ������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��18�� ����11:30:01
 */
public class RegexpMethodPointcutAdvisorTest {
	@Test
	public void test() {
		// ���������ļ�,��������
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/RegexpMethodPointcutAdvisor/conf-advisor.xml");
		// �������л�ȡBean
		Waiter waiter = ctx.getBean("waiter", Waiter.class);
		Seller seller = ctx.getBean("seller", Seller.class);
		// ����ҵ�񷽷�
		waiter.greetTo("XiaoGongJiang");
		waiter.serverTo("XiaoGongJiang");
		seller.greetTo("XiaoGongJiang");
	}
}
