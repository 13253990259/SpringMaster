package com.xgj.ioc.configuration.method;

import org.springframework.stereotype.Component;

@Component
// ͨ��ע���עΪһ��Bean���Ա�Springɨ�貢ʵ����
public class Plane {

	public void fly() {
		System.out.println("Plane begins to  fly");
	}

}
