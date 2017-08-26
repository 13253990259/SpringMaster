package com.xgj.aop.spring.advisor.aspectJ.basic;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 
 * 
 * @ClassName: EnableSellerAspect
 * 
 * @Description: ϣ��WaiterҲ��ͬʱ�䵱Seller�Ľ�ɫ
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��26�� ����1:23:41
 */

@Aspect
public class EnableSellerAspect {
	// (1)value ΪNaiveWaiter��ӽӿ�ʵ��, (2)defaultImplĬ�ϵĽӿ�ʵ����
	@DeclareParents(value = "com.xgj.aop.spring.advisor.aspectJ.basic.NaiveWaiter", defaultImpl = SmartSeller.class)
	public Seller seller; // (3) Ҫʵ�ֵ�Ŀ��ӿ�
}
