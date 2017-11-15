package com.xgj.quartz.quartzItself.exception;

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

/**
 * 
 * 
 * @ClassName: JobExceptionExample
 * 
 * @Description: ��ʾ Quartz ��δ��� ��job���׳��� JobExecutionExceptions
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����1:10:02
 */
public class JobExceptionExample {
	public void run() throws Exception {
		// ����ִ�е�ʱ�� ��ʽ��
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		System.out.println("--------------- ��ʼ�� -------------------");

		// ��һ��15��
		Date startTime = nextGivenSecondDate(null, 15);

		// badJob1 ÿ10sִ��һ�� , �׳��쳣,����������ִ��
		JobDetail job = newJob(BadJob1.class).withIdentity("badJob1", "group1")
				.usingJobData("flag", "0").build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.repeatForever()).build();

		Date ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey().getName() + " ����: "
				+ dateFormat.format(ft) + "  ʱ����.�����ظ�: "
				+ trigger.getRepeatCount() + " ��, ÿ�μ�� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

	        // badJob2 ÿ5��ִ��һ�� , ���� ���׳��쳣,Ȼ�� ����ִ��
		job = newJob(BadJob2.class).withIdentity("badJob2", "group1").build();
		trigger = newTrigger()
				.withIdentity("trigger2", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(5)
								.repeatForever()).build();

		ft = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey().getName() + " ����: "
				+ dateFormat.format(ft) + "  ʱ����.�����ظ�: "
				+ trigger.getRepeatCount() + " ��, ÿ�μ�� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

		sched.start();
		System.out.println("------- ��ʼ���� (����.start()����) ----------------");

		try {
			// ˯�� 30s
			Thread.sleep(60L * 1000L);
		} catch (Exception e) {
		}

		sched.shutdown(false);

		// ��ʾһ�� �Ѿ�ִ�е�������Ϣ
		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("~~~~~~~~~~  ִ���� "
				+ metaData.getNumberOfJobsExecuted() + " �� jobs.");
	}

	public static void main(String[] args) throws Exception {

		JobExceptionExample example = new JobExceptionExample();
		example.run();
	}
}
