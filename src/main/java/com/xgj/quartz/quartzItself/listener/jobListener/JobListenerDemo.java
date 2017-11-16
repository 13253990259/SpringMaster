package com.xgj.quartz.quartzItself.listener.jobListener;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Matcher;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;


public class JobListenerDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("------- ��ʼ�� ----------------------");

		// Scheduler
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		// Job
		JobDetail job = newJob(Job1.class).withIdentity("job1", "group1")
				.build();
		
		// Tirgger 
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.build();
		
		// ���ü�����
		JobListener jobListener = new MyJobListener();
		Matcher<JobKey> matcher = KeyMatcher.keyEquals(job.getKey());
		scheduler.getListenerManager().addJobListener(jobListener, matcher);

		// ��job������뵽������
		scheduler.scheduleJob(job, trigger);

		// ��ʼ����
		System.out.println("------- ��ʼִ�е����� Scheduler ----------------");
		scheduler.start();

		try {
			System.out.println("------- �ȴ� 30 ��... --------------");
			Thread.sleep(30L * 1000L);
		} catch (Exception e) {
			e.printStackTrace();
		}

		scheduler.shutdown(true);
		System.out.println("------- �رյ����� -----------------");

		SchedulerMetaData metaData = scheduler.getMetaData();
		System.out.println("~~~~~~~~~~  ִ���� "
				+ metaData.getNumberOfJobsExecuted() + " �� jobs.");

	}

}
