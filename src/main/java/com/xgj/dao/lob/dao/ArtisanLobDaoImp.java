package com.xgj.dao.lob.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import com.xgj.dao.lob.domain.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanLobDaoImp
 * 
 * @Description: @Repository��ע��DAO��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��28�� ����8:15:23
 */

@Repository
public class ArtisanLobDaoImp implements ArtisanLobDao {
	// ����jdbcTemplate����
	private JdbcTemplate jdbcTemplate;
	// ����LobHander����
	private LobHandler lobHandler;

	private static final String addArtisanLobSql = "insert into artisan_lob(artisan_id ,artisan_detail ,artisan_attach) values (?,?,?)";
	private static final String selectArtisanByIdSql = "select artisan_detail , artisan_attach from artisan_lob where artisan_id = ?";
	private static final String selectAttachByIdSql = "select  artisan_attach from artisan_lob where artisan_id = ?";

	// ע��jdbcTemplate
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// ע��lobHandler
	@Autowired
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	@Override
	public void addArtisanLob(final Artisan artisan) {

		jdbcTemplate.execute(addArtisanLobSql,
				new AbstractLobCreatingPreparedStatementCallback(
						this.lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException,
							DataAccessException {
						// ����ID
						ps.setString(1, artisan.getArtisanId());
						// ���� CLOB �ֶ�
						lobCreator.setClobAsString(ps, 2,
								artisan.getArtisanDetail());
						// ���� BLOB �ֶ�
						lobCreator.setBlobAsBytes(ps, 3,
								artisan.getArtisanAttach());
					}
				});

	}

	@Override
	public List<Artisan> selectArtisanById(String artisanId) {

		List<Artisan> artisanList = jdbcTemplate.query(selectArtisanByIdSql,
				new Object[] { artisanId }, new RowMapper<Artisan>() {

					@Override
					public Artisan mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// �Զ��������鷽ʽ��ȡ BLOB ���ݡ�
						byte[] attach = lobHandler.getBlobAsBytes(rs,
								"artisan_attach");
						String artisanDetaiul = lobHandler.getClobAsString(rs,
								"artisan_detail");
						Artisan artisan = new Artisan();
						artisan.setArtisanAttach(attach);
						artisan.setArtisanDetail(artisanDetaiul);
						return artisan;
					}
				});

		return artisanList;
	}

	/**
	 * 
	 * 
	 * @Title: getAttach
	 * 
	 * @Description: �������ݷ�ʽ��ȡ LOB ����
	 * 
	 * 
	 * @return: void
	 */
	public void getAttach(final String artisanId, final OutputStream os) {

		jdbcTemplate.query(selectAttachByIdSql, new Object[] { artisanId },
				new AbstractLobStreamingResultSetExtractor<Artisan>() { // �����ڲ���
					// ����δ�ҵ������е����
					protected void handleNoRowFound()
							throws LobRetrievalFailureException {
						System.out.println("Not Found result!");
					}

					// �����ķ�ʽ���� LOB �ֶ�
					public void streamData(ResultSet rs) throws SQLException,
							IOException {
						InputStream is = lobHandler
								.getBlobAsBinaryStream(rs, 1);
						if (is != null) {
							FileCopyUtils.copy(is, os);
						}
					}
				});

	}

}

/**
 * 
 * 
 * JdbcTemplate ��execute��update������
 * 
 * execute�����ܲ������޷���ֵ��������create��drop table��
 * 
 * update���Խ��ܲ���������ֵΪ�˴β���Ӱ��ļ�¼�����ʺ���insert, update, ��delete�Ȳ�����
 * 
 */
