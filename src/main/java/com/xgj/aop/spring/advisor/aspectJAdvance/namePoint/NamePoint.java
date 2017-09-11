package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * 
 * @ClassName: NamePoint
 * 
 * @Description: ���ϣ���������ط�����һ���е㣬���ǿ���ͨ��@Pointcutע���Լ������෽�����е��������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��10�� ����11:13:45
 */

public class NamePoint {

	/**
	 * 
	 * 
	 * @Title: inPackage
	 * 
	 * @Description: ͨ��ע�ⷽ��inPackage()�Ը��е��������������������
	 *               ���η�Ϊprivate,�����������е�ֻ���ڱ���������ʹ�á�
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("within(com.xgj.aop.spring.advisor.aspectJAdvance.namePoint.*)")
	private void inPackage() {
	};

	/**
	 * 
	 * 
	 * @Title: greetTo
	 * 
	 * @Description: ͨ��ע�ⷽ��greetTo()�Ը��е��������������������
	 *               ���η�Ϊprotected,�����������е�����ڵ�ǰ���е����� �ࡢ������������ʹ�á�
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("execution(* greetTo(..))")
	protected void greetTo() {
	}

	/**
	 * 
	 * 
	 * @Title: inPkgGreetTo
	 * 
	 * @Description: ���������е㶨����е㣬���е�Ҳ�������е㣬 ����Ӧ�Ŀ�����Ϊpublic
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("inPackage() and greetTo()")
	public void inPkgGreetTo() {
	}

}
