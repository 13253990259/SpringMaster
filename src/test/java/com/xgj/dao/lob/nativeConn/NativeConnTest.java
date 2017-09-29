package com.xgj.dao.lob.nativeConn;

import oracle.jdbc.driver.OracleConnection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NativeConnTest {

	ClassPathXmlApplicationContext ctx = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/lob/lobOperation.xml");
		System.out.println("initContext successfully");
	}

	@Test
	public void testCallProcWithCallableStatementCreator() {

		ArtisanDaoImpl artisanDaoImpl = ctx.getBean("artisanDaoImpl",
				ArtisanDaoImpl.class);

		OracleConnection oracleConnection = artisanDaoImpl
				.getOracleNativeConn();

		// ������Ϊ��
		Assert.assertNotNull(oracleConnection);
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
