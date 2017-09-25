package com.xgj.dao.transaction.nestedCall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @ClassName: BaseSerivce
 * 
 * @Description: ����Ļ���
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��24�� ����4:24:20
 */
public abstract class BaseService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
