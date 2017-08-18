package com.xgj.ioc.configuration.lazyLoad;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
// @Lazy Ŀ��Bean �ӳ�ע��
@Component
// ͨ��ע���עΪһ��Bean���Ա�Springɨ�貢ʵ����
public class Plane {

	/**
	 * 
	 * 
	 * @Title:Plane
	 * 
	 * @Description:�޲ι��캯��
	 */
	public Plane() {
		super();
		System.out.println("Plan init ");
	}

	public void fly() {
		System.out.println("Plane begins to  fly");
	}

}
