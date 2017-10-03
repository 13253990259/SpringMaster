package com.xgj.cache.springCacheAnno.cachePut;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.xgj.cache.springCacheAnno.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanCachePutService
 * 
 * @Description: @Service��ע�ķ���㣬��Spring����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��3�� ����1:31:50
 */

@Service
public class ArtisanCachePutService {

	// ģ����ѯ �ڲ�����ֵ�����ã�%������ѯsql����ֻ�Ǹ���������
	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc "
			+ "	from little_artisan "
			+ " where artisan_name like  :artisanName  ";

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getArtisan
	 * 
	 * @Description: @CachePut(cacheNames = "littleArtisan")
	 *               ʹ����ΪlittleArtisan�Ļ��棬����#artisanName == 'masterArtisan'�Ż���
	 * 
	 * 
	 * @return
	 * 
	 * @return: Artisan
	 */

	@CachePut(cacheNames = "littleArtisan", condition = "#artisanName == 'masterArtisan'")
	public Artisan getArtisan(String artisanName) {
		// �����ڲ�ʵ�ֲ����ǻ����߼���ֱ��ʵ��ҵ��
		System.out.println("����ArtisanName����Artisan��" + artisanName);
		return getFromDB(artisanName);
	}

	/**
	 * 
	 * 
	 * @Title: getFromDB
	 * 
	 * @Description: ����ֻ��Ϊ����ʾ��
	 *               ʹ��NamedParameterJdbcTemplateģ����ѯ���÷�����ʵ�п��ܷ��ص���һ��List��
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: Artisan
	 */
	private Artisan getFromDB(String artisanName) {
		System.out.println("getFromDB");
		final Artisan artisan = new Artisan();

		// ʹ��MapSqlParameterSource�󶨲��� ��ƴ��ģ����ѯ
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
				.addValue("artisanName", "%" + artisanName + "%");

		jdbcTemplate.query(selectArtisanSQL, mapSqlParameterSource,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						artisan.setArtisanId(rs.getString("artisan_id"));
						artisan.setArtisanName(rs.getString("artisan_name"));
						artisan.setArtisanDesc(rs.getString("artisan_desc"));
					}
				});

		return artisan;
	}

}
