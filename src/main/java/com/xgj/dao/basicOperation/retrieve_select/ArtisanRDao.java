package com.xgj.dao.basicOperation.retrieve_select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xgj.dao.demo.BaseDao;

/**
 * 
 * 
 * @ClassName: ArtisanRDao
 * 
 * @Description: @Repository ��ע��DAO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��18�� ����6:14:24
 */

@Repository
public class ArtisanRDao extends BaseDao {

	private static final String selectArtisanUserSql = "select user_name ,password from artisan_user where user_id = ? ";
	private static final String selectArtisanUsersSql = "select user_name ,password from artisan_user where user_id between ? and ? ";

	/**
	 * 
	 * 
	 * @Title: selectArtisanById
	 * 
	 * @Description: ȡһ������
	 * 
	 * @param artisanId
	 * @return
	 * 
	 * @return: Artisan
	 */
	public Artisan selectArtisanById(int artisanId) {

		final Artisan artisan = new Artisan();
		// ��1����������е����ݳ�ȡ��artisan������
		jdbcTemplate.query(selectArtisanUserSql, new Object[] { artisanId },
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						artisan.setUserName(rs.getString("user_name"));
						artisan.setPassword(rs.getString("password"));
					}
				});
		return artisan;
	}

	/**
	 * 
	 * 
	 * @Title: selectArtisansByIds
	 * 
	 * @Description: ʹ��RowCallbackHandler��ȡ������¼
	 * 
	 * @param beginId
	 * @param toId
	 * @return
	 * 
	 * @return: List<Artisan>
	 */
	public List<Artisan> selectArtisansByIds(int beginId, int toId) {

		final List<Artisan> artisanList = new ArrayList<Artisan>();

		jdbcTemplate.query(selectArtisanUsersSql,
				new Object[] { beginId, toId }, new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Artisan artisan = new Artisan();
						artisan.setUserName(rs.getString("user_name"));
						artisan.setPassword(rs.getString("password"));
						artisanList.add(artisan);
					}
				});

		return artisanList;
	}

	/**
	 * 
	 * 
	 * @Title: selectArtisansByIdsWithRowMapper
	 * 
	 * @Description: ʹ��RowMapper��ȡ���н����
	 * 
	 * @param beginId
	 * @param toId
	 * @return
	 * 
	 * @return: List<Artisan>
	 */
	public List<Artisan> selectArtisansByIdsWithRowMapper(int beginId, int toId) {

		return jdbcTemplate.query(selectArtisanUsersSql, new Object[] {
				beginId, toId }, new RowMapper<Artisan>() {

			@Override
			public Artisan mapRow(ResultSet rs, int rowNum) throws SQLException {

				Artisan artisan = new Artisan();
				artisan.setUserName(rs.getString("user_name"));
				artisan.setPassword(rs.getString("password"));
				return artisan;
			}
		});

	}
}
