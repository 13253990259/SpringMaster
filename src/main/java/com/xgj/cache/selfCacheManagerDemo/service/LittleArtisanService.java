package com.xgj.cache.selfCacheManagerDemo.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.xgj.cache.selfCacheManagerDemo.CacheManager;
import com.xgj.cache.selfCacheManagerDemo.domain.LittleArtisan;

/**
 * 
 * 
 * @ClassName: LittleArtisanService
 * 
 * @Description: @Service��ע��Service�㣬��Spring����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��2�� ����1:55:56
 */

@Service("littleArtisanService")
public class LittleArtisanService {

	private Logger logger = Logger.getLogger(LittleArtisanService.class);

	// ���������
	private CacheManager<LittleArtisan> cacheManager;

	// JdbcTemplate
	private JdbcTemplate jdbcTemplate;

	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc from little_artisan where artisan_name = ?";

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: ͨ��@Autowiredע��JdbcTemplate
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
	 * @Title:LittleArtisanService
	 * 
	 * @Description:���캯��
	 */
	public LittleArtisanService() {
		// ��ʼ��LittleArtisanService��ʱ��ʵ����CacheManager
		cacheManager = new CacheManager<LittleArtisan>();
	}

	public LittleArtisan getLittleArtisan(String artisanName) {
		// ���ȴӻ����в���LittleArtisan
		LittleArtisan littleArtisan = cacheManager.getValue(artisanName);
		// �����в�����������ݿ��л�ȡ
		if (littleArtisan != null) {
			logger.info("get littleArtisan from Cache...");
			return littleArtisan;
		}
		// �����ݿ��л�ȡ
		littleArtisan = getFromDB(artisanName);
		logger.info("get littleArtisan from DB...");
		// ������ݿ��д��ڼ�¼���򽫻�ȡ�������ݷ��ڻ�����
		if (littleArtisan != null) {
			cacheManager.addOrUpdateCache(artisanName, littleArtisan);
			logger.info("put cache successfully");
		}
		return littleArtisan;
	}

	/**
	 * 
	 * 
	 * @Title: reload
	 * 
	 * @Description: �����������,���¼���
	 * 
	 * 
	 * @return: void
	 */
	public void reload() {
		cacheManager.evictCache();
	}

	/**
	 * 
	 * 
	 * @Title: getFromDB
	 * 
	 * @Description: �����ݿ��л�ȡLittleArtisan
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: LittleArtisan
	 */
	private LittleArtisan getFromDB(String artisanName) {

		final LittleArtisan littleArtisan = new LittleArtisan();

		jdbcTemplate.query(selectArtisanSQL, new Object[] { artisanName },
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						littleArtisan.setArtisanId(rs.getString("artisan_id"));
						littleArtisan.setArtisanName(rs
								.getString("artisan_name"));
						littleArtisan.setArtisanDesc(rs
								.getString("artisan_desc"));
					}
				});
		return littleArtisan;
	}
}
