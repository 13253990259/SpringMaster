package com.xgj.cache.springCacheAnno.cacheable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class CacheableTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanSpringCacheService service = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanSpringCacheService",
				ArtisanSpringCacheService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan littleArtisan = new Artisan();
		// ��һ�� �����ݿ��л�ȡ
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisanInfo(littleArtisan);

		// @Cacheable(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// ����condition ����������ֻ�ǻ���#artisanName == 'masterArtisan'�ļ�¼

		// ��һ�� �����ݿ��л�ȡ
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// �ڶ��� ��ѯmasterArtisan �����ݻ������������㣬Ӧ�ôӻ����л�ȡ
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// �ڶ��� ��ѯlittleArtisan �����ݻ��������������㣬Ӧ�ô����ݿ��л�ȡ
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisanInfo(littleArtisan);
	}

	private void printArtisanInfo(Artisan littleArtisan) {
		System.out.println("Id:" + littleArtisan.getArtisanId());
		System.out.println("Name:" + littleArtisan.getArtisanName());
		System.out.println("Desc:" + littleArtisan.getArtisanDesc());
		System.out.println();
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
