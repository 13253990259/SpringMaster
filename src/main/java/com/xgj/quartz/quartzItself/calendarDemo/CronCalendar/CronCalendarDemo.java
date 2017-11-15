package com.xgj.quartz.quartzItself.calendarDemo.CronCalendar;

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
import org.quartz.impl.calendar.CronCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;

public class CronCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  ��ʼ�� ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		// ����ִ�е�ʱ��, ���ڲ�����"7" = "SAT",2 = MON
		// ���롿 �����ӡ� ��Сʱ�� �������졿 ���¡� ��������(1-7)�� [����(��ʡ��)��]
		String excludeExpression;

		// �������ý���ʱ���Ϊ��ÿ0-20֮�䣬40-59֮�䲻ִ��
		excludeExpression = "0-20,40-59 * * * * ?";
		CronCalendar cronCalendar = new CronCalendar(excludeExpression);

		// ����Ҫ�ų������� ÿ���17��10��
		sched.addCalendar("cronCalendar", cronCalendar, false, false); // �ڼ��ռ���schedule������

		Date runDate = new Date();
		System.out.println("����ʼʱ�䣺" + sdf.format(runDate));

		// ����ÿ10��ִ��һ��
		JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1")
				.build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(runDate)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.repeatForever())
				.modifiedByCalendar("cronCalendar").build();

		// ���������������
		Date firstRunTime = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey() + " �������ڣ�" + sdf.format(firstRunTime)
				+ " ���ظ���" + trigger.getRepeatCount() + " ��, ��� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

		System.out.println("------- ��ʼ Scheduler ----------------");
		sched.start();

		try {
			System.out.println("------- �ȴ� 120 �루2���ӣ�... --------------");
			Thread.sleep(120L * 1000L);
			// do something
		} catch (Exception e) {
		}

		sched.shutdown(true);
		System.out.println("------- �رյ����� -----------------");

		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("~~~~~~~~~~  ִ���� "
				+ metaData.getNumberOfJobsExecuted() + " �� jobs.");

	}
}
