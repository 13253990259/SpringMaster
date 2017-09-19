package com.xgj.dao.basicOperation.retrieve_select;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArtisanRDaoTest {

	public static void main(String[] args) {
		// ����Spring ����
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");
		// �������л�ȡBean
		ArtisanRDao artisanRDao = ctx.getBean("artisanRDao", ArtisanRDao.class);
		// ����Ŀ�귽��
		// artisanRDao.selectArtisanById(1).toString();

		// ��ȡ���artisan
		List<Artisan> artisanList = artisanRDao.selectArtisansByIds(1, 5);
		System.out.println("artisanList size:" + artisanList.size());
		for (Artisan artisan : artisanList) {
			System.out.println("username:" + artisan.getUserName()
					+ ",password:" + artisan.getPassword());
		}

		System.out.println("==================RowMapper======================");

		List<Artisan> artisanList2 = artisanRDao
				.selectArtisansByIdsWithRowMapper(1, 5);
		System.out.println("artisanList size:" + artisanList2.size());
		for (Artisan artisan : artisanList2) {
			System.out.println("username:" + artisan.getUserName()
					+ ",password:" + artisan.getPassword());
		}

	}
}
