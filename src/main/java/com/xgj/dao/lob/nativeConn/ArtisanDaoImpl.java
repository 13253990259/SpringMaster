package com.xgj.dao.lob.nativeConn;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: ArtisanDaoImpl
 * 
 * @Description: @Repository��עDAO��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��28�� ����5:35:06
 */

@Repository
public class ArtisanDaoImpl {

	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: ע��JdbcTemplate
	 * 
	 * @param jdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getNativeConn
	 * 
	 * @Description: Ҫ��ʹ�������ȷ���У�JdbcTemplateģ�����ñ�������������conf-getLocalConnObj.xml
	 * 
	 * 
	 * @return: void
	 */
	public OracleConnection getOracleNativeConn() {
		OracleConnection oracleConnection = null;
		try {
			// ʹ��DataSourceUtils ��JdbcTemplate�л�ȡ��������
			Connection connection = DataSourceUtils.getConnection(jdbcTemplate
					.getDataSource());
			// ʹ��ģ����ı���JDBC��ȡ����ȡ��������
			connection = jdbcTemplate.getNativeJdbcExtractor()
					.getNativeConnection(connection);

			// ǿ������ת��
			oracleConnection = (OracleConnection) connection;
			// ʹ�ñ��ض��󣬵���API���ҵ�����(�˴�ʡ��) ����ʹ��OracleConnection���� API����lob

		} catch (CannotGetJdbcConnectionException | SQLException e) {
			e.printStackTrace();
		}
		return oracleConnection;
	}
}
