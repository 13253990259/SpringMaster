package com.xgj.dao.transaction.annotationTrans.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @ClassName: BaseDao
 * 
 * @Description: �����࣬��װһЩͨ�õĹ��ܣ�ϣ�����̳�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��22�� ����10:50:57
 */

public abstract class BaseDao {

	public JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
