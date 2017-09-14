package com.xgj.aop.spring.advisor.schema.bindParameter;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: AdviceMethodsBindParam
 * 
 * @Description: ʹ��ע�ⶨ���Bean��ͬʱҲ��������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��13�� ����8:25:13
 */

@Component
public class AdviceMethodsBindParam {

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
	public void crossCutting(String name, int num) {
		System.out.println("----bindJoinPointParams()----");
		System.out.println("name:" + name);
		System.out.println("number:" + num);
		System.out.println("----bindJoinPointParams()----");
	}
}
