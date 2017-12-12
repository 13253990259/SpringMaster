package com.xgj.oxm.xstream.quickDemo.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

/**
 * 
 * 
 * @ClassName: PersistenceDemo
 * 
 * @Description: TODO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��12��12�� ����10:06:29
 */

public class PersistenceDemo {


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		List<Artisan> artisans = new ArrayList<Artisan>();

		// ��1��ʵ������Ҫ�־û��Ķ���
		Artisan artisan1 = new Artisan("artisan1", "male", 20);
		Artisan artisan2 = new Artisan("artisan2", "female", 40);
		// ����List��
		artisans.add(artisan1);
		artisans.add(artisan2);

		System.out.println(artisans.size());

		// ��2�������־û����� ��������Ŀ¼�����򱨴�--���ɵ�xml�����Ŀ¼��
		File file = new File("D://");
		PersistenceStrategy strategy = new FilePersistenceStrategy(file);

		// ��3���־û����϶���
		List list = new XmlArrayList(strategy);
		list.addAll(artisans);

		// (4) ��֤��
		XStream xstream = new XStream();
		xstream.registerConverter(new PersistenceArrayListConverter(xstream));
		String xml = xstream.toXML(artisans);
		System.out.println(xml);

	}

}
