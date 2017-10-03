package com.xgj.cache.springCacheAnno.cachePut;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class ArtisanCachePutServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanCachePutService service = null;

	@Before
	public void initContext() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanCachePutService",
				ArtisanCachePutService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan artisan = new Artisan();
		// ��һ�� �����ݿ��л�ȡ
		artisan = service.getArtisan("littleArtisan");
		printArtisanInfo(artisan);

		// �������� @CachePut(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// @CachePut ������ִ�з�����Ȼ����»���ֵ

		// ��һ�� �����ݿ��л�ȡ
		artisan = service.getArtisan("masterArtisan");
		printArtisanInfo(artisan);

		// �ڶ��� ��ѯmasterArtisan ��Ҳ��ִ�з�������DBȡ
		artisan = service.getArtisan("masterArtisan");
		printArtisanInfo(artisan);

		// �ڶ��� ��ѯlittleArtisan ��Ҳ��ִ�з�������DBȡ
		artisan = service.getArtisan("littleArtisan");
		printArtisanInfo(artisan);
	}

	private void printArtisanInfo(Artisan artisan) {
		System.out.println("Id:" + artisan.getArtisanId());
		System.out.println("Name:" + artisan.getArtisanName());
		System.out.println("Desc:" + artisan.getArtisanDesc());
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
