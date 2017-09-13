package com.xgj.aop.spring.advisor.schema.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigBySchemaTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/schema/demo/conf-bySchema.xml");

		BussinessOne bussinessOne = ctx.getBean("bussinessOne",
				BussinessOne.class);
		BussinessTwo bussinessTwo = ctx.getBean("bussinessTwo",
				BussinessTwo.class);

		// ���������ļ��е��е���ʽ
		// target(com.xgj.aop.spring.advisor.schema.demo.BussinessOne)and
		// execution(* program(..)) ��ֻ��
		// bussinessOne.program()��������
		bussinessOne.program();
		bussinessOne.fixBug();

		bussinessTwo.program();
		bussinessTwo.fixBug();

	}

}
