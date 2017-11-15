package com.xgj.quartz.quartzItself.jobDataMapOfficalDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {

	public static final String FAVORITE_COLOR = "favorite color";
	public static final String EXECUTION_COUNT = "count";

	// ����Quartz����ÿ��ִ��ʱ����ʵ����һ���࣬��˳�Ա�Ǿ�̬��Ա������������ά��״̬��
	private int _counter = 1;

	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();

		JobDataMap data = context.getJobDetail().getJobDataMap();
		String favoriteColor = data.getString(FAVORITE_COLOR);
		int count = data.getInt(EXECUTION_COUNT);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("����Key: " + jobKey + " ,ִ��ʱ��:  "
				+ sdf.format(new Date()) + "\n" + "  ���ݲ���(favorite color): "
				+ favoriteColor + "\n" + "  ���ݲ���(count):  " + count + "\n"
				+ "  ColorJob�Ǿ�̬����ֵ: " + _counter + "\n");

		count++;
		data.put(EXECUTION_COUNT, count);
		data.put(FAVORITE_COLOR, "��ɫ");

		_counter++;
	}

}
