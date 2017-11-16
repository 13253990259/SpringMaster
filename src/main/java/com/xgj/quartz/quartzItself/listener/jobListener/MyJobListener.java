package com.xgj.quartz.quartzItself.listener.jobListener;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;


/**
 * 
 * 
 * @ClassName: MyJobListener
 * 
 * @Description: �Զ���Job������
 * 
 *               getName() ������һ���ַ�������˵�� JobListener �����ơ�����ע��Ϊȫ�ֵļ�������getName()
 *               ��Ҫ���ڼ�¼��־���������ض� Job ���õ� JobListener��ע���� JobDetail
 *               �ϵļ��������Ʊ���ƥ��Ӽ������� getName() �����ķ���ֵ.
 * 
 *               jobToBeExecuted() ��Scheduler �� JobDetail ��Ҫ��ִ��ʱ�������������
 * 
 *               jobExecutionVetoed() ��Scheduler �� JobDetail ������ִ�У����ֱ�
 *               TriggerListener �����ʱ�������������
 * 
 *               jobWasExecuted() ��Scheduler �� JobDetail ��ִ��֮��������������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��16�� ����3:57:35
 */
public class MyJobListener implements JobListener {

	@Override
	public String getName() {
		return "MyJobListerner";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println("Job��������MyJobListener.jobToBeExecuted()");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("Job��������MyJobListener.jobExecutionVetoed()");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {

		System.out.println("Job��������MyJobListener.jobWasExecuted()");
		
		 // ��������һ��jobִ��
		JobDetail job2 = JobBuilder.newJob(Job2.class).withIdentity("job2")
				.build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("job2Trigger").startNow().build();

        try {
			context.getScheduler().scheduleJob(job2, trigger);
        } catch (SchedulerException e) {
            System.err.println("�޷�����job2!");
            e.printStackTrace();
        }
		
		
	}

}
