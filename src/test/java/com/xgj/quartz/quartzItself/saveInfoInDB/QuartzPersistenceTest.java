package com.xgj.quartz.quartzItself.saveInfoInDB;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class QuartzPersistenceTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {

			System.out.println("------- ��ʼ�� ----------------------");

			// ͨ��������������ȡ����������ʼ������ʱ��ָ����ʹ�������Լ��������ļ�
			SchedulerFactory sf = new StdSchedulerFactory(
					"quartz/quartz.properties");
			Scheduler sched = sf.getScheduler();

			// clearһ�£���Ϊʹ�����ݿⴢ�淽ʽʱ��shutdown��ʱ��û��������ڶ������лᱨJob is already
			// exist
			sched.clear();

			System.out.println("------- ��ʼ����� -----------");

			// ��һ���ӿ�ʼִ��
			Date runTime = DateBuilder.evenMinuteDate(new Date());

			System.out.println("------- Scheduling Job  -------------------");

			// ��������
			JobDetail job = JobBuilder.newJob(MyPersistenceJob.class)
					.withIdentity("artisanJob", "artisanGroup").build();

			// ������ �ظ�20+1�� ���2��
			SimpleTriggerImpl trigger = (SimpleTriggerImpl) TriggerBuilder
					.newTrigger()
					.withIdentity("artisanTrigger", "artisanGroup")
					.startAt(runTime).build();
			trigger.setRepeatCount(20);
			trigger.setRepeatInterval(2000);

			System.out.println("------- ��ǰʱ�䣺" + sdf.format(new Date())
					+ " -----------------");

			// �����������������������߹���
			sched.scheduleJob(job, trigger);

			System.out.println(job.getKey() + " ��ʼjob����ʱ�䣺"
					+ sdf.format(runTime));

			// ��������
			sched.start();
			System.out.println("------- ��ʼ������ Scheduler -----------------");
			
			/** �ڶ������� ���ö�����
			System.out.println("------- �ȴ�10��-------------");
			try {
				Thread.sleep(1 * 10000L);
			} catch (Exception e) {
			}

			System.out.println("------- �رյ����� ģ���쳣�˳�---------------------");
			sched.shutdown(true);

			System.out.println("------- �쳣�˳� -----------------");
			**/
			SchedulerMetaData metaData = sched.getMetaData();
			System.out.println("Ŀǰִ���� "
					+ metaData.getNumberOfJobsExecuted() + " �� jobs.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
