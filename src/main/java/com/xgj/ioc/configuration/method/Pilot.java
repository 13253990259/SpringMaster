package com.xgj.ioc.configuration.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pilot {

	private Plane plane;

	// �Զ���Plane���ʹ����������
	@Autowired
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void drivePlane() {
		plane.fly();
	}

	// �Զ�����Ϊplane��Bean�����������
	// @Autowired
	// @Qualifier("plane")
	// public void setPlane(Plane plane) {
	// this.plane = plane;
	// }
}
