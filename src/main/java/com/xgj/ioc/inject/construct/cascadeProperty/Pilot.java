package com.xgj.ioc.inject.construct.cascadeProperty;

public class Pilot {
	// ������ʼ������
	private Plane plane = new Plane();

	// ��ȡʵ��
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void introduce() {
		plane.info();
	}

}
