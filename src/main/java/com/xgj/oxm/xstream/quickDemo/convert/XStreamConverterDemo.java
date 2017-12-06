package com.xgj.oxm.xstream.quickDemo.convert;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import com.thoughtworks.xstream.XStream;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class XStreamConverterDemo {

	private static XStream xstream;

	static {
		// ����һ��Xstreamʵ����ʹ��Ĭ�ϵ�XPP������
		xstream = new XStream();

		// (1)������������޸�Ĭ�ϵ�ȫ�޶���������
		xstream.alias("user", User.class);
		xstream.alias("loginLog", LoginLog.class);

		// (2)�������Ա���� <id>1</id> ��Ϊ<userId>1</userId>
		xstream.aliasField("userId", User.class, "id");

		// (3)��LoginLog��userId������Ϊxml���ԣ�Ĭ��Ϊxml��Ԫ��
		xstream.aliasAttribute(LoginLog.class, "userId", "id");
		xstream.useAttributeFor(LoginLog.class, "userId");

		// (4)ȥ��������������XML�ĸ��ڵ㣬������xml�е�<logs></logs>���
		xstream.addImplicitCollection(User.class, "logs");

		// ע��ת����
		xstream.registerConverter(new DateConverter(Locale.CHINESE));
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

		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.1");
		log2.setLoginLogId(22);
		log2.setUserId(2);
		log2.setLoginDate(new Date());

		User user = new User();
		user.setId(1);
		user.setUserName("Artisan");
		user.setPassword("artisan");
		user.setCredits(1000);
		user.setLastVisit(new Date());

		user.addLoginLog(log);
		user.addLoginLog(log2);
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
	}



	public static void main(String[] args) throws Exception {
		objectToXml();
	}
}
