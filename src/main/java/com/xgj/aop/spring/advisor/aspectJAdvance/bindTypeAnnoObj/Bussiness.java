package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: Bussiness
 * 
 * @Description: beanʹ��@Componentע�⣬
 * 
 *               ͬʱ��ע��@@Monitorע�⣬����Bussiness Beanƥ���е㣬 ��@Monitorע����󽫰󶨵���ǿ������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��12�� ����4:32:23
 */

@Component
@Monitor
public class Bussiness {

	public void dealBussinessOne() {
		System.out.println("dealBussinessOne executed");
	}

	public void dealBussinessTwo() {
		System.out.println("dealBussinessTwo executed");
	}
}
