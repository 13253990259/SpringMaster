package com.xgj.aop.spring.advisor.schema.namePointcut;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: AdviceMethods
 * 
 * @Description: ʹ��ע�ⶨ���������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����5:17:41
 */

@Component
public class AdviceMethods {

	/**
	 * 
	 * 
	 * @Title: crossCutting
	 * 
	 * @Description: �ķ���ͨ�����ñ�������ǿ����
	 * 
	 * 
	 * @return: void
	 */
	public void crossCutting() {
		System.out.println("crossCutting executed");
	}
}
