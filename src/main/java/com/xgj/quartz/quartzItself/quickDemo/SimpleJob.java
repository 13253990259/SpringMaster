package com.xgj.quartz.quartzItself.quickDemo;

import java.text.SimpleDateFormat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * 
 * @ClassName: SimpleJob
 * 
 * @Description: ʵ��Job�ӿ�,������Ҫִ�е����� JobExecutionContext���ṩ�˵��������ĵĸ�����Ϣ��
 *               Job����ʱ����Ϣ������JobDataMapʵ���С�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��6�� ����11:56:43
 */

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		
		System.out.println(" triggered time is " + dateFormat.format(new java.util.Date()));

	}
}
