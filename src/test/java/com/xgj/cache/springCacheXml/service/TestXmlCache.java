package com.xgj.cache.springCacheXml.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheXml.domain.LittleArtisan;

public class TestXmlCache {

	ClassPathXmlApplicationContext context = null;
	LittleArtisanSpringCacheService service = null;
	LittleArtisan littleArtisan;
	@Before
	public void initContext() {
		// ����Spring ����
		context = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheXml/conf_spring.xml");
	}

	@Test
	public void testXmlCache() {
		
		service = context.getBean(
				"littleArtisanSpringCacheService",
				LittleArtisanSpringCacheService.class);
		// ��һ�� �����ݿ����
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisan();
		// �ڶ��� �ӻ������
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisan();
		// ��ջ���
		service.reloadArtisan();
		// �ٴβ�ѯ�������ݿ����
		service.getArtisan("masterArtisan");
		printArtisan();
		// �ֲ�ѯ���ӻ������
		service.getArtisan("masterArtisan");
		printArtisan();
	}

	private void printArtisan() {
		System.out.println(littleArtisan.getArtisanName() + "||"
				+ littleArtisan.getArtisanDesc());
	}

	@After
	public void releaseContext() {

		if (context != null) {
			context.close();
		}
	}
}
