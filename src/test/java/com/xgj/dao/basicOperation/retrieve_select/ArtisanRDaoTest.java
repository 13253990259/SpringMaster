package com.xgj.dao.basicOperation.retrieve_select;

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
		artisanRDao.selectArtisanById(1).toString();

	}

}
