package com.xgj.aop.spring.advisor.schema.advices;

/**
 * 
 * 
 * @ClassName: InterfaceOneImpl
 * 
 * @Description: ��ʾ������ǿ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����8:14:33
 */
public class InterfaceOneImpl implements InterfaceOne {

	@Override
	public void dealAnotherWork() {
		System.out.println("InterfaceOneImpl dealAnotherWork executed ");

	}

}
