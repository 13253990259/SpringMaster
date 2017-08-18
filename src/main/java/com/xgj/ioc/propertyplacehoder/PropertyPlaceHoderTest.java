package com.xgj.ioc.propertyplacehoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PropertyPlaceHoderTest {

	private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM temp_user  "
			+ " WHERE user_name =? and password=? ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getMatchCount
	 * 
	 * @Description: �����û����������ж��û��Ƿ����
	 * 
	 * @param username
	 * @param password
	 * 
	 * @return: int
	 */
	public int getMatchCount(String username, String password) {
		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] {
				username, password }, Integer.class);
	}

	/**
	 * 
	 * 
	 * @Title: main
	 * 
	 * @Description: ����
	 * 
	 * @param args
	 * 
	 * @return: void
	 */
	public static void main(String[] args) {
		// ����Spring�����ļ�
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/propertyplacehoder/beans.xml");
		// ��ȡͨ��ע���ע��Bean
		PropertyPlaceHoderTest propertyPlaceHoderTest = ctx.getBean(
				"propertyPlaceHoderTest", PropertyPlaceHoderTest.class);
		// ���÷���
		int count = propertyPlaceHoderTest.getMatchCount("xgj", "123456");
		System.out.println("ƥ����û�������" + count);
	}
}
