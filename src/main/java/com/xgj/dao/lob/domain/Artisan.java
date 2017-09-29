package com.xgj.dao.lob.domain;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: Artisan
 * 
 * @Description: ʵ�����л��ӿڵ�ʵ����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��28�� ����8:14:37
 */
public class Artisan implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ӦARTISAN_LOB��� clob�ֶ� artisan_id
	 */
	private String artisanId;

	/**
	 * ��ӦARTISAN_LOB��� clob�ֶ� artisan_detail
	 */
	private String artisanDetail;

	/**
	 * ��ӦARTISAN_LOB��� clob�ֶ� artisan_attach
	 */
	private byte[] artisanAttach;

	public String getArtisanDetail() {
		return artisanDetail;
	}

	public void setArtisanDetail(String artisanDetail) {
		this.artisanDetail = artisanDetail;
	}

	public byte[] getArtisanAttach() {
		return artisanAttach;
	}

	public void setArtisanAttach(byte[] artisanAttach) {
		this.artisanAttach = artisanAttach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getArtisanId() {
		return artisanId;
	}

	public void setArtisanId(String artisanId) {
		this.artisanId = artisanId;
	}
}
