package com.xgj.quartz.quartzItself.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * 
 * @ClassName: BadJob1
 * 
 * @Description: setRefireImmediately
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����1:10:17
 */

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class BadJob1 implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		JobKey jobKey = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		int flag = dataMap.getInt("flag");
		System.out.println("---" + jobKey + "��ִ��ʱ�䣺"
				+ dateFormat.format(new Date()) + ", flag�� " + flag);

		// �����������Դ���ҵ�����ɵ��쳣�����⣨���ڵ�һ�����У�
		try {
			int result = 4815 / flag;

		} catch (Exception e) {
			System.out.println("--- Job1 ����!");

			// �޸���ĸ�������´������ҵ������������ʧ��
			JobExecutionException e2 = new JobExecutionException(e);
			dataMap.put("flag", "1");

			// ���������������������
			e2.setRefireImmediately(true);

			throw e2;
		}

		System.out.println("---" + jobKey + "�����ʱ�䣺"
				+ dateFormat.format(new Date()));
    }


}
