package com.xgj.quartz.jdkTimer.jdkTimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 
 * 
 * @ClassName: MyTask
 * 
 * @Description: ����ִ��10�κ��˳�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��17�� ����5:01:32
 */
public class MyTask extends TimerTask {

	int count = 0;

	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Task begins to execute,execute times:" + count);
		
		Date date = new Date(scheduledExecutionTime());
		
		System.out.println("��������ִ��ʱ���Ϊ:" + sdf.format(date));
		
		// ִ��10�κ��˳�
		if (++count > 10) {
			cancel();
			System.out.println("Task exits");
		}
		

	}

}
