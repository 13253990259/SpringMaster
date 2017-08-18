package com.xgj.ioc.inject.construct.refParentBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefParentBeanTest {

	public static void main(String[] args) {

		// ������
		ApplicationContext pFather = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/refParentBean/beans_father.xml");
		// ָ��pFactoryΪ�������ĸ�����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "com/xgj/ioc/inject/construct/refParentBean/beans_son.xml" },
				pFather);

		Police police = ctx.getBean("police", Police.class);
		// �۲��Ƿ����Ϊ���������õ�����
		police.introduceGun();
	}

}
