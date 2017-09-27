package com.xgj.dao.transaction.dbConnleak;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

@Service
public class JdbcStudentService {
	private Logger logger = Logger.getLogger(JdbcStudentService.class);

	private static final String addStudentSQL = "insert into student(id,name,age,sex) values(student_id_seq.nextval,?,?,?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addStudent(Student student) {
		Connection conn = null;
		try {
			// (0)ֱ�Ӵ�����Դ��ȡ���ӣ���������û����ʽ�ͷŸ�����
			// Connection connection = jdbcTemplate.getDataSource()
			// .getConnection();

			// �����񻷾��£�ͨ��DataSourceUtils��ȡ��������
			conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());

			jdbcTemplate.update(addStudentSQL, student.getName(),
					student.getAge(), student.getSex());
			Thread.sleep(1000);// (0-1)ģ���������ִ��ʱ��
			logger.info("addStudent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ��ʽʹ��DataSourceUtils�ͷ�����
			DataSourceUtils.releaseConnection(conn,
					jdbcTemplate.getDataSource());
		}

	}

	// (1)���첽�̵߳ķ�ʽִ��JdbcStudentService#addStudent()��������ģ����̵߳Ļ���
	public static void asynchrLogon(JdbcStudentService userService,
			Student student) {
		StudentServiceRunner runner = new StudentServiceRunner(userService,
				student);
		runner.start();
	}

	private static class StudentServiceRunner extends Thread {
		private JdbcStudentService studentService;
		private Student student;

		public StudentServiceRunner(JdbcStudentService studentService,
				Student student) {
			this.studentService = studentService;
			this.student = student;
		}

		public void run() {
			studentService.addStudent(student);
		}
	}

	// (2) ����ִ���߳�˯��һ��ָ����ʱ��
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @Title: reportConn
	 * 
	 * @Description: (3)�㱨����Դ������ռ�����
	 * 
	 * @param basicDataSource
	 * 
	 * @return: void
	 */
	public static void reportConn(BasicDataSource basicDataSource) {
		System.out.println("������[active:idle]-["
				+ basicDataSource.getNumActive() + ":"
				+ basicDataSource.getNumIdle() + "]");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/dao/transaction/dbConnleak/conf_conn_leak.xml");
		JdbcStudentService jdbcStudentService = (JdbcStudentService) ctx
				.getBean("jdbcStudentService");

		BasicDataSource basicDataSource = (BasicDataSource) ctx
				.getBean("dataSource");

		// (4)�㱨����Դ��ʼ����ռ�����
		JdbcStudentService.reportConn(basicDataSource);

		Student student = new Student();
		student.setAge(20);
		student.setName("LEAK");
		student.setSex("MALE");

		JdbcStudentService.asynchrLogon(jdbcStudentService, student);
		JdbcStudentService.sleep(500);

		// (5)��ʱ�߳�A����ִ��JdbcStudentService#addStudent()����
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.sleep(2000);
		// (6)��ʱ�߳�A��ִ�е�JdbcStudentService#addStudent()�����Ѿ�ִ�����
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.asynchrLogon(jdbcStudentService, student);
		JdbcStudentService.sleep(500);

		// (7)��ʱ�߳�B����ִ��JdbcStudentService#addStudent()����
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.sleep(2000);

		// (8)��ʱ�߳�A��B�������JdbcStudentService#addStudent()������ִ��
		JdbcStudentService.reportConn(basicDataSource);
	}
}
