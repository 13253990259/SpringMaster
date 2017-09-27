package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @ClassName: MulitThreadBaseService
 * 
 * @Description: ����Ļ��� ������ϣ�����̳�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��26�� ����4:41:10
 */

public abstract class MulitThreadBaseService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
