package com.xgj.spel;

/**
 * 
 * 
 * @ClassName: Car
 * 
 * @Description: ����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018��4��7�� ����8:30:01
 */
public class Car {

	private String brand;
	private double price;
	// ���þ�̬������̬���ԣ�ͨ�� T() ����һ����ľ�̬��������������һ�� Class Object��Ȼ���ٵ�����Ӧ�ķ���������
	private long weight;

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", weight=" + weight + "]";
	}


}
