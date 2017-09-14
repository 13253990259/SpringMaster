package com.xgj.aop.spring.advisor.schema.advices;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DifferentAdviceTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/schema/advices/conf-advices.xml");

		BussinessSvc bussinessSvc = ctx.getBean("bussinessSvc",
				BussinessSvc.class);
		// ����ִ��ǰ֯��ǰ����ǿ
		bussinessSvc.dealBussinessBefore();

		// ����ִ�к�֯�������ǿ
		bussinessSvc.dealWorkNumberForAfterReturring();

		// ����ִ��ʱ֯�뻷����ǿ
		bussinessSvc.dealWorkForAround("fixBug");

		// ����ִ��ʱ�����ض��쳣ʱ֯���쳣�׳���ǿ
		bussinessSvc.dealWorkForAfter();

		// ����ִ�к󣬲����쳣���ִ�е���ǿ
		bussinessSvc.dealWorkForAfter();

		// ���� --ǿ������ת���ɹ���˵��Ҳʵ��������Ľӿ�
		IntfBussinessImpl intfBussinessImpl = ctx.getBean("intfBussinessImpl",
				IntfBussinessImpl.class);
		((InterfaceOne) intfBussinessImpl).dealAnotherWork();
	}
}
