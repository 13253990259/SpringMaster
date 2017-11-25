package com.xgj.oxm.xstream.quickDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class XStreamDemo {

	private static XStream xstream;

	static {
		// ����һ��Xstreamʵ������ָ��һ��XML������
		xstream = new XStream(new DomDriver());
	}

	/**
	 * 
	 * 
	 * @Title: getUser
	 * 
	 * @Description: ��ʼ��ת������
	 * 
	 * @return
	 * 
	 * @return: User
	 * @throws ParseException
	 */
	public static User getUser() throws ParseException {
		LoginLog log = new LoginLog();
		log.setIp("127.0.0.1");
		log.setLoginLogId(99);
		log.setUserId(1);
		log.setLoginDate(new Date());

		User user = new User();
		user.setUserId(1);
		user.setUserName("Artisan");
		user.setPassword("artisan");
		user.setCredits(1000);
		user.setLastVisit(new Date());
		user.addLoginLog(log);

		return user;
	}

	/**
	 * 
	 * 
	 * @Title: objectToXml
	 * 
	 * @Description: Java����ת����XML
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void objectToXml() throws Exception {

		// ��ȡת����User����ʵ��
		User user = getUser();
		// ������ݵ�����̨,�鿴һ��
		System.out.println(xstream.toXML(user));

		// ʵ����һ���ļ������
		FileOutputStream os = new FileOutputStream("D://XstreamDemo.xml");

		// ��User����ת��ΪXML�������浽ָ�����ļ�
		xstream.toXML(user, os);

		System.out.println("objectToXml successfully");
	}

	/**
	 * 
	 * 
	 * @Title: XmlToObject
	 * 
	 * @Description: XmlתJava����
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void XmlToObject() throws Exception {
		// ʵ�����ļ�������
		FileInputStream in = new FileInputStream("D://XstreamDemo.xml");
		
		// ��xml�ļ�������ת��Ϊ����
		User user = (User) xstream.fromXML(in);
		
		// ����
		for (LoginLog log : user.getLogs()) {
			System.out.println("����ʱ��:" + log.getLoginDate());
			System.out.println("����IP:" + log.getIp());
		}

	}

	public static void main(String[] args) throws Exception {
		objectToXml();
		System.out.println("=====================================");
		XmlToObject();
	}
}
