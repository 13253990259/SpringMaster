package com.xgj.cache.selfCacheManagerDemo.domain;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: LittleArtisan
 * 
 * @Description: Java�еĻ�������л���ϢϢ��ص�,ע��ʵ��Serializable�ӿ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��2�� ����1:40:53
 */

public class LittleArtisan implements Serializable {

	private static final long serialVersionUID = 1L;

	private String artisanId;
	private String artisanName;
	private String artisanDesc;

	public String getArtisanId() {
		return artisanId;
	}

	public void setArtisanId(String artisanId) {
		this.artisanId = artisanId;
	}

	public String getArtisanName() {
		return artisanName;
	}

	public void setArtisanName(String artisanName) {
		this.artisanName = artisanName;
	}

	public String getArtisanDesc() {
		return artisanDesc;
	}

	public void setArtisanDesc(String artisanDesc) {
		this.artisanDesc = artisanDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
