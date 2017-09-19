package com.xgj.dao.basicOperation.retrieve_select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
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

	private static final String sql = "select user_name ,password from artisan_user where user_id = ? ";

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
		jdbcTemplate.query(sql, new Object[] { artisanId },
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						artisan.setUserName(rs.getString("user_name"));
						artisan.setPassword(rs.getString("password"));
					}
				});
		return artisan;
	}

}
