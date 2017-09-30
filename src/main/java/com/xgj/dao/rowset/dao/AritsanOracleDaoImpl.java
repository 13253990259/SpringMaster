package com.xgj.dao.rowset.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: AritsanOracleDaoImpl
 * 
 * @Description: @Repository��עDAO�㣬����Spring����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��29�� ����10:41:10
 */

@Repository
public class AritsanOracleDaoImpl implements AritsanOracleDao {

	private JdbcTemplate jdbcTemplate;

	private static final String selectArtisanByIdSql = "select artisan_name from artisan where artisan_id = ?";

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: �Զ�ע��JdbcTemplate
	 * 
	 * @param jdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public SqlRowSet selectArtisanById(int artisanId) {

		return jdbcTemplate.queryForRowSet(selectArtisanByIdSql, artisanId);
	}

}
