package com.xgj.spel;

/**
 * 
 * 
 * @ClassName: Address
 * 
 * @Description: ��ַ��Ϣ
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018��4��7�� ����8:29:12
 */
public class Address {

	private String city;
	private String street;


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
