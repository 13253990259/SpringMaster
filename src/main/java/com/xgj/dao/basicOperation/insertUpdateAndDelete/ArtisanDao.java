package com.xgj.dao.basicOperation.insertUpdateAndDelete;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.xgj.dao.demo.BaseDao;

/**
 * 
 * 
 * @ClassName: ArtisanDao
 * 
 * @Description: @Repository��ע��DAO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��18�� ����4:19:06
 */

@Repository
public class ArtisanDao extends BaseDao {

	private static final String sql = "insert into artisan_user(user_name,password) values(?,?)";

	/**
	 * 
	 * 
	 * @Title: addSingleArtisan
	 * 
	 * @Description: ����һ��Artisan
	 * 
	 * @param artisan
	 * 
	 * @return: void
	 */
	public void addSingleArtisan(Artisan artisan) {
		jdbcTemplate.update(sql, artisan.getUserName(), artisan.getPassword());
		System.out.println("insert successfully");
	}

	/**
	 * 
	 * 
	 * @Title: addBatchArtisan
	 * 
	 * @Description: ��������
	 * 
	 * @param artisanList
	 * 
	 * @return: void
	 */
	public void addBatchArtisan(final List<Artisan> artisanList) {

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
				Artisan artisan = artisanList.get(index);
				ps.setString(1, artisan.getUserName());
				ps.setString(2, artisan.getPassword());
			}

			// ָ�������ļ�¼��
			@Override
			public int getBatchSize() {
				return artisanList.size();
			}
		});

		System.out.println("batch insert successfully");
	}

}
