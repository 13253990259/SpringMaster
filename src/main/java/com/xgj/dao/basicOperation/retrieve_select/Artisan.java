package com.xgj.dao.basicOperation.retrieve_select;

/**
 * 
 * 
 * @ClassName: Artisan
 * 
 * @Description: @Component��ע��Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��18�� ����5:03:47
 */

public class Artisan {

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String info = "Artisan Info: userName:" + getUserName() + " ,password:"
				+ getPassword();
		System.out.println(info);
		return info;
	}
}
