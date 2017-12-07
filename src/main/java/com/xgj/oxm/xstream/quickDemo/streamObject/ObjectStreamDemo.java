package com.xgj.oxm.xstream.quickDemo.streamObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class ObjectStreamDemo {

	private static XStream xstream;

	static {
		xstream = new XStream();
	}

	/**
	 * 
	 * 
	 * @Title: objectToXml
	 * 
	 * @Description: JAVA����ת��ΪXML
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public void objectToXml() throws Exception {
		// ��1��ʵ�������л�����
		User user = getUser();
		// ��2������һ��PrintWriter�������������
		PrintWriter pw = new PrintWriter("D:\\ObjectStreamSample.xml");
		// ��3������һ��HierarchicalStreamWriter��ʵ�������������
		PrettyPrintWriter ppw = new PrettyPrintWriter(pw);
		// ��4���������������
		ObjectOutputStream out = xstream.createObjectOutputStream(ppw);
		out.writeObject(user);
		out.close();
	}

	/**
	 * 
	 * 
	 * @Title: xmlToObject
	 * 
	 * @Description: XMLת��ΪJAVA����
	 * 
	 * @return
	 * @throws Exception
	 * 
	 * @return: User
	 */
	public User xmlToObject() throws Exception {
		// ��1��������Ҫͨ�����������������������ҪFileReader��BufferedReader
		FileReader fr = new FileReader("D:\\ObjectStreamSample.xml");
		BufferedReader br = new BufferedReader(fr);
		// ��2����������������
		ObjectInputStream input = xstream.createObjectInputStream(br);
		// ��3����������ͨ��ObjectInputStream�е�readObject()�����������XML�ļ��ж�ȡ������
		User user = (User) input.readObject();
		return user;

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
	 */
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}

	public static void main(String[] args) throws Exception {
		ObjectStreamDemo converter = new ObjectStreamDemo();
		converter.objectToXml();
		User u = converter.xmlToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate());
			}
		}

	}

}