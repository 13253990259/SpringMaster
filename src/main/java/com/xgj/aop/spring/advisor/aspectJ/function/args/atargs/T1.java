package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.springframework.stereotype.Component;

@Component
public class T1 extends T0 {

	/**
	 * 
	 * 
	 * @Title: fun
	 * 
	 * @Description: Ŀ���෽��,ּ�����������֯����ǿ�߼�. ��ע���ע��T2,���������ΪT2����T2��������ʱ,��֯����ǿ
	 * 
	 * @param t
	 * 
	 * @return: void
	 */
	public void fun(T2 t) {
		System.out.println(t.getClass().getName() + " fun executed");
	}
}
