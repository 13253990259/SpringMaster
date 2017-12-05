package com.xgj.oxm.xstream.quickDemo.aliasDemo;

/**
 * 
 * 
 * @ClassName: PhoneNumber
 * 
 * @Description: Create classes to be serialized , ���캯����set/get����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��12��5�� ����8:51:08
 */

public class PhoneNumber {
	private int code;
	private String number;

	public PhoneNumber(int code, String number) {
		super();
		this.code = code;
		this.number = number;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
