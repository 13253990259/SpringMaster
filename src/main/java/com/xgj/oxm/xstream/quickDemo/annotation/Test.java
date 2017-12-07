package com.xgj.oxm.xstream.quickDemo.annotation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import com.thoughtworks.xstream.XStream;

public class Test {
	private static XStream xstream;
	static {
		xstream = new XStream();
		// (1) ʵ�ָ÷������ж�Ҫת��������
		xstream.processAnnotations(User.class);
		xstream.processAnnotations(LoginLog.class);
		// (2)�Զ�����ע��Bean
		xstream.autodetectAnnotations(true);
	}

	// ��ʼ��ת������
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());

		log2.setIp("127.0.0.1");
		log2.setLoginDate(new Date());

		User user = new User();
		user.setId(1);
		user.setUserName("xstream");

		user.addLoginLog(log1);
		user.addLoginLog(log2);

		return user;
	}

	/**
	 * JAVA����ת��ΪXML
	 */
	public static void objectToXml() throws Exception {
		User user = getUser();
		FileOutputStream fs = new FileOutputStream(
				"D://XStreamAnnotationSample.xml");
		OutputStreamWriter writer = new OutputStreamWriter(fs,
				Charset.forName("UTF-8"));
		xstream.toXML(user, writer);

		System.out.println("output xml:\n" + xstream.toXML(user));
	}

	/**
	 * XMLת��ΪJAVA����
	 */
	public static User xmlToObject() throws Exception {
		FileInputStream fis = new FileInputStream(
				"D://XStreamAnnotationSample.xml");
		InputStreamReader reader = new InputStreamReader(fis,
				Charset.forName("UTF-8"));
		User user = (User) xstream.fromXML(fis);
		for (LoginLog log : user.getLogs()) {
			if (log != null) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate());
			}
		}
		return user;
	}

	public static void main(String[] args) throws Exception {
		objectToXml();
		xmlToObject();
	}
}
