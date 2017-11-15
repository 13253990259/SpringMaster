package com.xgj.quartz.quartzItself.interruptableJob;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.UnableToInterruptJobException;

/**
 * 
 * 
 * @ClassName: DumbInterruptableJob
 * 
 * @Description: ����ִ�е��жϿ�ִ�г������ڵ�Ԫ���ԡ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����9:26:36
 */

public class DumbInterruptableJob implements InterruptableJob {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private boolean _interrupted = false; // job �Ƿ��ж�
	private JobKey _jobKey = null; // job name

	private static int counts = 0; // �ж�ִ�д���

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		_jobKey = context.getJobDetail().getKey();

		System.out.println("����ʼִ�С�����Key��" + _jobKey + "��ִ��ʱ�䣺 "
				+ sdf.format(new Date()));

		try {

			for (int i = 0; i < 4; i++) {
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// �鿴�Ƿ��ж�
				if (_interrupted) {
					counts++;
					System.out.println("���������ֹͣ���������key��" + _jobKey
							+ ",�ж��ۼƴ���: " + counts + "\n");
					return; // Ҳ����ѡ���׳�һ��JobExecutionException������ҵ����Ҫָ����Ϊ
				}
			}

		} finally {
			System.out.println("���������key��" + _jobKey + " ���ʱ�䣺"
					+ sdf.format(new Date()));
		}

	}

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		System.out.println("\n������������ ���жϡ�������ڵ��õ�����ֹͣ�������key��" + _jobKey
				+ " ����������������");
		_interrupted = true;

	}

}
