package com.xgj.spel.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: MyDataSource
 * 
 * @Description: ����Դ @Component��ע
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018��4��7�� ����9:26:32
 */

@Component
public class MyDataSource {

	private String driverClass;
	private String url;
	private String username;
	private String password;

	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * 
	 * 
	 * @Title: setDriverClass
	 * 
	 * @Description: @Valueע���Զ�ע�����������ļ��ж�Ӧ���Ե�ֵ
	 * 
	 * @param driverClass
	 * 
	 * @return: void
	 */
	@Value("${jdbc.driverClassName}")
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	// @Value("$(jdbc.username)")
	@Value("${jdbc.username}")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@Value("${jdbc.password}")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MyDataSource [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password=" + password + "]";
	}

}
