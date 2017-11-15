package com.xgj.quartz.quartzItself.calendarDemo.AnnualCalendar;

import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;
/**
 * 
 * 
 * @ClassName: AnnualCalendarDemo
 * 
 * @Description: ��ʾ������ʾ���ʹ���������ų���Ӧ�ý��е��ȵ�ʱ��Ρ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����5:14:57
 */
public class AnnualCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  ��ʼ�� ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// ����һ���ڼ��� holidayCalendar������Ҫ�ų�������
		// ������������ÿ��Ϊ���ڵģ�����ʹ��AnnualCalendar������HolidayCalendar
		AnnualCalendar holidays = new AnnualCalendar();

		Calendar fourthOfJuly = new GregorianCalendar(2017, 6, 4); // fourth of
																	// July
																	// (July 4)
																	// ��������
		holidays.setDayExcluded(fourthOfJuly, true);
		System.out.println("��һ���ڼ��գ�" + sdf.format(fourthOfJuly.getTime()));

		Calendar halloween = new GregorianCalendar(2017, 9, 31); // halloween
																	// (Oct 31)
																	// ��ʥ�ڣ�10��31�գ�
		holidays.setDayExcluded(halloween, true);
		System.out.println("�ڶ��ڼ��գ�" + sdf.format(halloween.getTime()));

		Calendar christmas = new GregorianCalendar(2017, 11, 25); // christmas
																	// (Dec 25)
																	// christmas
																	// (Dec 25)
		holidays.setDayExcluded(christmas, true);
		System.out.println("�������ڼ��գ�" + sdf.format(christmas.getTime()));

		sched.addCalendar("holidays", holidays, false, false); // �ڼ��ռ���schedule������

		// ��ʼ����ʥ��ǰҹ����10�㣬��ʼ����
		Date runDate = dateOf(0, 0, 10, 31, 10);
		System.out.println("����ʼʱ�䣺" + sdf.format(runDate));

		JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1")
				.build();

		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(runDate)
				.withSchedule(
						simpleSchedule().withIntervalInHours(1).repeatForever())
				.modifiedByCalendar("holidays").build();

		Date firstRunTime = sched.scheduleJob(job, trigger);

		// ע�⣺��ʥ�ڣ�10��31�գ��Ǽ��ڣ�����ֱ���ڶ���Ż����У� ��11��1�գ�
		System.out.println(job.getKey() + " �������ڣ�" + firstRunTime + " ���ظ���"
				+ trigger.getRepeatCount() + " ��, ��� "
				+ trigger.getRepeatInterval() / 1000 + " ��");

		System.out.println("------- ��ʼ Scheduler ----------------");
		sched.start();

		System.out.println("------- �ȴ� 30 ��... --------------");
		try {
			Thread.sleep(30L * 1000L);
		} catch (Exception e) {
		}

		sched.shutdown(true);
		System.out.println("------- �رյ����� -----------------");

		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("ִ���ˣ� " + metaData.getNumberOfJobsExecuted()
				+ " ��jobs.");
	}

}
