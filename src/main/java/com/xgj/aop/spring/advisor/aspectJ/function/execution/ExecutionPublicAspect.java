package com.xgj.aop.spring.advisor.aspectJ.function.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ExecutionPublicAspect
 * 
 * @Description: TODO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��27�� ����1:47:55
 */

@Aspect
public class ExecutionPublicAspect {

	@Before("execution(public * *(..))")
	public void crossCuttingLogic() {
		System.out.println("֯��ǰ����ǿ,�����߼�code");
	}

}
