package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

/**
 * 
 * 
 * @ClassName: AddTransportForBussinessAspect
 * 
 * @Description: ΪBussiness��� ITransportService�ӿڵ�����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����9:18:50
 */

@Aspect
public class AddTransportForBussinessAspect implements Ordered {
	// (1)value ΪBussinessService��ӽӿ�ʵ��, (2)defaultImplҪ��ӵĽӿڵ�Ĭ�ϵĽӿ�ʵ����
	@DeclareParents(value = "com.xgj.aop.spring.advisor.aspectJ.function.thisFun.BussinessService", defaultImpl = TransportService.class)
	public ITransportService iTransportService; // (3) Ҫʵ�ֵ�Ŀ��ӿ�

	@Override
	public int getOrder() {
		return 2;
	}

}
