package com.xgj.quartz.quartzItself.listener.triggerListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SimpleJob1 implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		JobKey jobKey = context.getJobDetail().getKey();

		System.out.println("\nJob1 - ����key "
				+ jobKey
				+ "ִ��ʱ�䣺"
				+ sdf.format(new Date()));
	}
}
