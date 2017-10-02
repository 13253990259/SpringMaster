package com.xgj.cache.selfCacheManagerDemo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.selfCacheManagerDemo.domain.LittleArtisan;

public class LittleArtisanCacheTest {

	ClassPathXmlApplicationContext ctx = null;
	LittleArtisanService littleArtisanService = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/selfCacheManagerDemo/conf.xml");
		littleArtisanService = ctx.getBean("littleArtisanService",
				LittleArtisanService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		LittleArtisan littleArtisan = new LittleArtisan();

		// ��һ�� �����ݿ��л�ȡ
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());

		// �ٴ˵��ã����Cache�л�ȡ
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());

		// ��ջ��棬�ٴ˶�ȡ,���ٴ˴����ݿ��м���
		littleArtisanService.reload();
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
