package com.xgj.quartz.quartzItself.calendarDemo.HolidayCalendar;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SortedSet;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;

public class HolidayCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  ��ʼ�� ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

	
		HolidayCalendar holidayCalendar = new HolidayCalendar();
		Calendar calendar = new GregorianCalendar(2017, 10, 1); // 2017��11��1��
		holidayCalendar.addExcludedDate(calendar.getTime());

		calendar = new GregorianCalendar(2018, 10, 2); // 2018��11��2��
		holidayCalendar.addExcludedDate(calendar.getTime());

		SortedSet<Date> dates = holidayCalendar.getExcludedDates();

		for (Date date : dates) {
			System.out.println("�����գ�" + sdf.format(date));
		}

		sched.addCalendar("holidays", holidayCalendar, false, false);      // �ڼ��ռ���schedule������
		

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
				.modifiedByCalendar("holidays").build();

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
