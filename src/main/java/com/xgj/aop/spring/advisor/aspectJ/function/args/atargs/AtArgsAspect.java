package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: AtArgsAspect
 * 
 * @Description: ��ע��@Aspect������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��1�� ����4:21:14
 */

@Aspect
public class AtArgsAspect {

	@Before("@args(com.xgj.aop.spring.advisor.aspectJ.function.args.atargs.Monitor)")
	public void crossCuttingCode() {
		System.out.println("ǰ����ǿ �����߼�֯�� some logic is here ");
	}
}
