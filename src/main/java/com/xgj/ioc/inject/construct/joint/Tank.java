package com.xgj.ioc.inject.construct.joint;

public class Tank {

	private String brand;
	private double weight;
	private double speed;
	// ��������
	private int manned;
	
	
	/**
	 * 
	 * @param brand
	 * @param weight
	 * @param speed
	 * �ڶ��������͵���������ͬΪdouble����
	 */
	public Tank(String brand, double weight, double speed) {
		this.brand = brand;
		this.weight = weight;
		this.speed = speed;
	}
	
	/**
	 * 
	 * @param brand
	 * @param weight
	 * @param manned
	 */
	public Tank(String brand, double weight,int manned){
		this.brand =brand;
		this.weight = weight;
		this.manned = manned;
	}
	
	public void introduce() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG,speed:" + speed + "km/h");
	}
	
	public void introduce2() {
		System.out.println("Tank information: brand:" + brand + ",weight:"
				+ weight + "KG,manned:" + manned + "/person");
	}

	
}
