package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArgsAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/conf-args.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserServiceExt userServiceExt = ctx.getBean("userServiceExt",
				UserServiceExt.class);

		User user = new User();
		// ֯������߼�
		userService.addUser(user);
		// ֯������߼�
		userService.modifyUser(user);
		// ֯������߼�
		userService.delUser(user);
		// ���Ϊuser�����Ҳ�ᱻ֯������߼�
		userServiceExt.addUser(user);
		// ���Ϊuser�����Ҳ�ᱻ֯������߼�
		userServiceExt.modifyUser(user);
		// ���Ϊuser�����Ҳ�ᱻ֯������߼�
	}
}
