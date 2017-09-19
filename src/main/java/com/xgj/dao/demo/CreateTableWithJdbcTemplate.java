package com.xgj.dao.demo;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * 
 * @ClassName: CreateTableWithJdbcTemplate
 * 
 * @Description: 
 *               ʹ��DriverManagerDataSource()����һ������Դ,���ಢû���ṩ�ػ����ӵĻ��ƣ�ÿ�ε���getConnection
 *               ()������ȡ������ʱ ��ֻ�Ǽ򵥵Ĵ���һ���µ����ӣ��Ƚ��ʺ����ڵ�Ԫ���Ի��߼򵥵Ķ���Ӧ�ã���Ϊ������Ҫ����������ࡣ
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��18�� ����11:32:47
 */
public class CreateTableWithJdbcTemplate {

	private static final String createTableSql = "create table artisan_user ("
			+ " user_id    NUMBER not null," + " user_name  VARCHAR2(50),"
			+ " password   VARCHAR2(10)," + " credits    NUMBER,"
			+ " last_visit DATE," + " last_ip    VARCHAR2(20)"
			+ " ) tablespace TAB_CC" + " pctfree 10 initrans 1 maxtrans 255 "
			+ "storage ( initial 64 next 1 minextents 1 maxextents unlimited"
			+ ")";

	@Test
	public void createTableByJdbcTemplate() {
		// ��������Դ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@172.25.246.11:1521:testbed");
		dataSource.setUsername("cc");
		dataSource.setPassword("zsmart2017");
		// ����JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// ������Դ
		jdbcTemplate.setDataSource(dataSource);
		// ִ��SQL
		jdbcTemplate.execute(createTableSql);
	}
}
