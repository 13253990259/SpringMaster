package com.xgj.aop.spring.advisor.schema.advices;

/**
 * 
 * 
 * @ClassName: IntfBussinessImpl
 * 
 * @Description: ��ʾ������ǿ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����8:14:49
 */
public class IntfBussinessImpl implements IntfBussiness {

	@Override
	public void fixBug() {
		System.out.println("IntfBussinessImpl  fixBug executed");
	}

}
