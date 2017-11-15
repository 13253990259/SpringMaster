package com.xgj.quartz.quartzItself.calendarDemo.DailyCalendar;

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
import org.quartz.impl.calendar.DailyCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;
/**
 * 
 * 
 * @ClassName: DailyCalendarDemo
 * 
 * @Description: ע�⣺dailyCalendar.setInvertTimeRange(true); //
 *               ʱ�䷴ת��Ϊtrue��ʾֻ�����ʱ��βŻᱻִ�У�Ϊfalse��ʾ�ų���ʱ���
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����5:40:00
 */
public class DailyCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  ��ʼ�� ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		DailyCalendar dailyCalendar = new DailyCalendar("12:17:30", "12:18:20");
		dailyCalendar.setInvertTimeRange(true); // ʱ�䷴ת��Ϊtrue��ʾֻ�����ʱ��βŻᱻִ�У�Ϊfalse��ʾ�ų���ʱ���

		// ����Ҫ�ų������� ÿ���17��10��
		sched.addCalendar("dailyCalendar", dailyCalendar, false, false); // �ڼ��ռ���schedule������

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
				.modifiedByCalendar("dailyCalendar").build();

		Date firstRunTime = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey() + " �������ڣ�" + sdf.format(firstRunTime)
				+ " ���ظ���" + trigger.getRepeatCount() + " ��, ��� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

		System.out.println("------- ��ʼ Scheduler ----------------");
		sched.start();

		System.out.println("------- �ȴ� 360 �루3���ӣ�... --------------");
		try {
			Thread.sleep(360L * 1000L);
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
