package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @ClassName: AnotherService
 * 
 * @Description: @Service��ע��Bean�� �̳г������MulitThreadBaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��26�� ����4:42:05
 */

@Service
public class AnotherService extends MulitThreadBaseService {

	public void doAnotherThing() {
		System.out.println("AnotherService#doAnotherThing executed");
	}

}
