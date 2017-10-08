package com.xgj.quartz.quartzItself.useQuartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * 
 * @ClassName: QuartzRun
 * 
 * @Description: ��ʹ�� scheduler ����������֮ǰ������Ҫ����ʵ��������ʵ����Ҫ�õ� SchedulerFactory �ࡣ
 * 
 *               �е�Quartzʹ����ϲ������������������ JNDI�д洢������һЩ�û�ϲ���򵥵�ʵ���������ࣨ��������Ӿ�ʹ�����ַ�ʽ����
 * 
 *               һ�� Scheduler ʵ������������Ϳ��Խ����������������رղ�����
 * 
 *               ��ס��һ�� Scheduler �رպ󣬾Ͳ�������������������Ҫ������һ�� Schedulerʵ������� Scheduler
 *               û�����������ߴ�����������ͣ״̬����ô���������ᱻ������Ҳ����ִ���κ����񣩡�
 * 
 *               ������һ�μ򵥵Ĵ��룬���д����� Scheduler ʵ�������Ұ�����һЩִ�е�����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��7�� ����12:37:17
 */
public class QuartzRun {


	public static void main(String[] args) {

		try {
			// Grab the Scheduler instance from the Factory
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();

			// start
			scheduler.start();

			// define the job and tie it to our MyJob class
			JobDetail job = newJob(MyJob.class).withIdentity("myJob",
					"group1").build();
			
			// Trigger the job to run now, and then every 40 seconds
			Trigger trigger = newTrigger()
					.withIdentity("myTrigger", "group1")
					.startNow()
					.withSchedule(
							simpleSchedule().withIntervalInSeconds(40)
									.repeatForever()).build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
