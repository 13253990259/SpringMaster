package com.xgj.quartz.quartzWithSpring.xml2;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * 
 * @ClassName: MyJob2
 * 
 * @Description: �����ļ���ʹ��JobDetailBean,����ҵ��Job��Ҫ�̳�QuartzJobBean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��12�� ����7:54:28
 */
public class MyJob2 extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		System.out.println("Spring ���� Quartz �ĵڶ��ַ�ʽ");
	}

}
