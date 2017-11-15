package com.xgj.quartz.quartzItself.interruptableJob;

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
 * @ClassName: InterruptExample
 * 
 * @Description: ������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����9:28:21
 */

public class InterruptExample {

	public void run() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("------- ��ʼ�� ----------------------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// ��һ��15��
		Date startTime = nextGivenSecondDate(null, 15);

		// ��ǰʱ��15���,ÿ���5��ִ��һ������
		JobDetail job = newJob(DumbInterruptableJob.class).withIdentity(
				"interruptableJob1", "group1").build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(5)
								.repeatForever()).build();

		Date ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey() + " �������ڣ�" + sdf.format(ft) + " ���ظ���"
				+ trigger.getRepeatCount() + " �Σ���� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

		// ���ȿ�ʼִ��
		sched.start();
		System.out.println("------- ��ʼ���� (����.start()����) ----------------");

		System.out.println("------- ÿ7��������һ���ж�����10���жϣ� ----------");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(7000L);

				// �ֶ��жϵ������е�job
				sched.interrupt(job.getKey());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("------- �رյ��� ---------------------");

		sched.shutdown(true);

		System.out.println("------- �رյ�������� -----------------");
		SchedulerMetaData metaData = sched.getMetaData();

		System.out.println("~~~~~~~~~~  ִ���� "
				+ metaData.getNumberOfJobsExecuted() + " �� jobs.");

	}

	public static void main(String[] args) throws Exception {
		InterruptExample example = new InterruptExample();
		example.run();
	}
}
