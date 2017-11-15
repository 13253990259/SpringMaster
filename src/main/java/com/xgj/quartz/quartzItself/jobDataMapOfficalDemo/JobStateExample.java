package com.xgj.quartz.quartzItself.jobDataMapOfficalDemo;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobStateExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(JobStateExample.class);
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// �ڵ�ǰʱ��10�������
		Date startTime = nextGivenSecondDate(null, 10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		// ͨ����JobDetail��װColorJob��ͬʱָ��Job��Scheduler�������鼰���ƣ��������Ϊgroup1��������Ϊjob1��
		JobDetail job1 = newJob(ColorJob.class).withIdentity("job1", "group1")
				.build();

		// ����һ��SimpleTriggerʵ����ָ����Trigger��Scheduler�������鼰���ơ�
		// �������õ��ȵ�ʱ�����.��ǰʱ��10������У�ÿ10������һ�Σ�������4��
		SimpleTrigger trigger1 = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.withRepeatCount(4)).build();

		// ���������������������Map��
		job1.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "��ɫ");
		job1.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

		// ע�Ტ���е���
		Date scheduleTime1 = sched.scheduleJob(job1, trigger1);

		log.error("����key: " + job1.getKey() + ",ִ������ʱ��: "
				+ sdf.format(scheduleTime1) + ",�������ظ�ִ�д���: "
				+ trigger1.getRepeatCount() + ",������ִ��ʱ��: "
				+ trigger1.getRepeatInterval() / 1000 + "��");

		// �ڶ�������
		JobDetail job2 = newJob(ColorJob.class).withIdentity("job2", "group1")
				.build();

		SimpleTrigger trigger2 = newTrigger()
				.withIdentity("trigger2", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.withRepeatCount(4)).build();

		// ��������
		job2.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "��ɫ");
		job2.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

		Date scheduleTime2 = sched.scheduleJob(job2, trigger2);

		log.error("�ڶ�������key: " + job2.getKey().toString() + ",ִ������ʱ��: "
				+ sdf.format(scheduleTime2) + ",�������ظ�ִ�д���: "
				+ trigger2.getRepeatCount() + ",������ִ��ʱ��: "
				+ trigger2.getRepeatInterval() / 1000 + "��");

		// ����������
		sched.start();

		try {
			Thread.sleep(60L * 1000L);
		} catch (Exception e) {
		}

		// ������ֹͣ
		sched.shutdown(true);

		SchedulerMetaData metaData = sched.getMetaData();
		log.error("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

	}

	public static void main(String[] args) throws Exception {

		JobStateExample example = new JobStateExample();
		example.run();
	}

}