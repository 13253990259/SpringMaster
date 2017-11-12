package com.xgj.quartz.quartzItself.saveInfoInDB;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.quartz.utils.ConnectionProvider;

/**
 * 
 * 
 * @ClassName: MyPoolingconnectionProvider
 * 
 * @Description: MyPoolingconnectionProvider����Դ���Ӻ�quartz.properties�����ļ���
 * 
 *               ����Դ���Լ�������࣬ʵ����quartz�Դ���ConnectionProvider�࣬�������ʹ������
 *               ��Ҳ����ѡ����������Դ��
 *               ����Tomcat��DataSource��Spring��SimpleDriverDataSource��,����ѡ��.
 * 
 *               DBCP����Դ���ӳص����ԣ��������ʹ���˱�������ã���������Ҳ��ʽ���ã�Ҳ��ʹ��Ĭ��ֵ��������Ҫִ�е�����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��10�� ����9:49:07
 */
public class MyPoolingconnectionProvider implements ConnectionProvider {
	/**
	 * ʹ��apache dbcp����Դ���ӳ�
	 */
	private BasicDataSource datasource = new BasicDataSource();
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("getConnection");
		return datasource.getConnection();
	}

	@Override
	public void shutdown() throws SQLException {
		System.out.println("connection pool shutdown");
		datasource.close();

	}

	@Override
	public void initialize() throws SQLException {
		try {
			System.out.println("inti connection");
			datasource.setDriverClassName(driverClassName);
			datasource.setUrl(url);
			datasource.setUsername(username);
			datasource.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDatasource(BasicDataSource datasource) {
		this.datasource = datasource;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
