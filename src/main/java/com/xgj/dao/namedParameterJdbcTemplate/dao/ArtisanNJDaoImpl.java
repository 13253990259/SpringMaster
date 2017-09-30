package com.xgj.dao.namedParameterJdbcTemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.xgj.dao.namedParameterJdbcTemplate.domain.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanNJDaoImpl
 * 
 * @Description: @Repository��ע��DAO�㣬��Spring����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��30�� ����12:42:26
 */

@Repository
public class ArtisanNJDaoImpl implements ArtisanNJDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final static String insertArtisanSql = "insert into artisan(artisan_name) values(:artisanName)";

	private final static String selectArtisanByIds = "select artisan_name from artisan where artisan_id in (:artisanId)";

	/**
	 * 
	 * 
	 * @Title: setNamedParameterJdbcTemplate
	 * 
	 * @Description: �Զ�ע��namedParameterJdbcTemplate
	 * 
	 * @param namedParameterJdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void addArtisan(Artisan artisan) {

		// ������������
		SqlParameterSource sps = new BeanPropertySqlParameterSource(artisan);
		// ʹ��ģ���෽��
		namedParameterJdbcTemplate.update(insertArtisanSql, sps);
	}

	public void addArtisanWithMapSqlParameterSource(Artisan artisan) {

		// ʹ��MapSqlParameterSource�󶨲���
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
				.addValue("artisanName", artisan.getArtisanName());

		// ʹ��ģ���෽��
		namedParameterJdbcTemplate.update(insertArtisanSql,
				mapSqlParameterSource);
	}

	public List<Artisan> getArtisanByIds(List<String> artisanIds) {

		final List<Artisan> artisanList = new ArrayList<Artisan>();

		// ʹ��MapSqlParameterSource�󶨲���
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

		mapSqlParameterSource.addValue("artisanId", artisanIds);

		namedParameterJdbcTemplate.query(selectArtisanByIds,
				mapSqlParameterSource, new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Artisan artisan = new Artisan();
						artisan.setArtisanName(rs.getString("artisan_name"));
						// ���뼯��
						artisanList.add(artisan);
					}
				});

		return artisanList;
	}
}
