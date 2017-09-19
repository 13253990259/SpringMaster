package com.xgj.dao.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: DemoDao
 * 
 * @Description: ��Ϊ��ʾʾ������Dao��ʹ��JdbcTemplate,�̳���һ������򵥵Ļ���BaseDao
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��18�� ����12:18:00
 */

// (1)����һ��DAO
@Repository
public class DemoDao extends BaseDao {

	// private JdbcTemplate jdbcTemplate;
	private ApplicationContext ctx;

	// ע��JdbcTemplateʵ��
	// @Autowired
	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	public void initTable() {
		// ע�⣺��ʵ�ʵ���Ŀ�У����SQL���Ƕ�̬��װ�ģ���Ӧ���䶨���һ���༶�ľ�̬final����
		// �˴���Ϊ�����Ķ������Է��ڷ����ڲ�
		String createTableSql = "create table artisan_user ("
				+ " user_id    NUMBER not null,"
				+ " user_name  VARCHAR2(50),"
				+ " password   VARCHAR2(10),"
				+ " credits    NUMBER,"
				+ " last_visit DATE,"
				+ " last_ip    VARCHAR2(20)"
				+ " ) tablespace TAB_CC"
				+ " pctfree 10 initrans 1 maxtrans 255 "
				+ "storage ( initial 64 next 1 minextents 1 maxextents unlimited"
				+ ")";

		jdbcTemplate.execute(createTableSql);
		System.out.println("create table successfully");
	}

	@Test
	public void test() {
		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/demo/demo.xml");
		// ����Ŀ�귽��
		ctx.getBean("demoDao", DemoDao.class).initTable();
	}
}
