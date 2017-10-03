package com.xgj.cache.springCacheManagerDemo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheManagerDemo.domain.LittleArtisan;

public class LittleArtisanSCServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	LittleArtisanSpringCacheService littleArtisanSpringCacheService = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheManagerDemo/conf_spring.xml");
		littleArtisanSpringCacheService = ctx.getBean(
				"littleArtisanSpringCacheService",
				LittleArtisanSpringCacheService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		LittleArtisan artisan = new LittleArtisan();
		// ��һ�β�ѯ�������ݿ��ȡ����
		artisan = littleArtisanSpringCacheService.getArtisan("artisan");
		System.out.println("========load from db===========");
		System.out.println("artisanDesc:" + artisan.getArtisanDesc());

		// �ڶ��β�ѯ��ֱ�ӷ��ػ����ֵ
		artisan = littleArtisanSpringCacheService.getArtisan("artisan");
		System.out.println("========hit cache========");
		System.out.println("artisanDesc:" + artisan.getArtisanDesc());
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
