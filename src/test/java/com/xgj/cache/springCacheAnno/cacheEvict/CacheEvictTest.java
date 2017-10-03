package com.xgj.cache.springCacheAnno.cacheEvict;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class CacheEvictTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanSpringCacheEvictService service = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanSpringCacheEvictService",
				ArtisanSpringCacheEvictService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan littleArtisan = new Artisan();

		// @Cacheable(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// ����condition ����������ֻ�ǻ���#artisanName == 'masterArtisan'�ļ�¼

		// ��һ�� �����ݿ��л�ȡ
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// �ڶ��� ��ѯmasterArtisan �����ݻ������������㣬Ӧ�ôӻ����л�ȡ
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// ��littleArtisan�ӻ������Ƴ����ٴ˲�ѯmasterArtisan
		service.remove("masterArtisan");
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// �ٴ� ��ѯmasterArtisan �����ݻ������������㣬Ӧ�ôӻ����л�ȡ
		littleArtisan = service.getArtisan("masterArtisan");
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
