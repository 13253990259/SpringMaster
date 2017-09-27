package com.xgj.dao.transaction.multiThreadinTrans.dao;

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
 * @date: 2017��9��24�� ����5:02:42
 */

public abstract class BaseDao {

	public JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
