package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.springframework.stereotype.Component;

@Component
public class UserServiceExt {
	public void addUser(User user) {
		System.out.println("���Ϊuser����  addUser " + user);
	}

	public void modifyUser(User user) {
		System.out.println("���Ϊuser����   modifyUser " + user);
	}

	public void delUser(User user) {
		System.out.println("���Ϊuser����  delUser " + user);
	}

	/**
	 * 
	 * 
	 * @Title: addArtisanTT
	 * 
	 * @Description: ���ΪArtisanTT
	 * 
	 * @param artisan
	 * 
	 * @return: void
	 */
	public void addArtisanTT(ArtisanTT artisan) {
		System.out.println("addArtisanTT " + artisan);
	}

	public void modifyArtisanTT(ArtisanTT artisan) {
		System.out.println("modifyArtisanTT " + artisan);
	}

	public void delArtisanTT(ArtisanTT artisan) {
		System.out.println("delArtisanTT " + artisan);
	}
}
