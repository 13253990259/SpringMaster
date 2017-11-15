package com.xgj.quartz.quartzItself.misfire;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * 
 * @ClassName: StatefulDumbJob
 * 
 * @Description: ͨ�����ô�ʧ������ĵ��Ȳ��ԣ���������������.
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��14�� ����9:36:52
 */

// ��Job��ִ�н����󣬽������JobDataMap�������´�Jobִ�к�ͻ�ʹ���µ�ֵ�����ǳ�ʼֵ
@PersistJobDataAfterExecution
// ͬһʱ�佫ֻ��һ��Jobʵ����ִ��, Ϊ�˱��Ⲣ�����⵼����������,����������ע��һ��ʹ��
@DisallowConcurrentExecution
public class StatefulDumbJob implements Job {

	// ��̬��������Ϊ�����ڵ��ü䣬�������ݵļ�(key)

	public static final String NUM_EXECUTIONS = "NumExecutions"; // ����ļ���ÿ�ε���1
	public static final String EXECUTION_DELAY = "ExecutionDelay"; // ������ִ��ʱ���м�˯�ߵ�ʱ�䡣������˯��ʱ����������˴�ʧ����

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String jobRunTime = dateFormat.format(new Date());

		System.err.println("---" + context.getJobDetail().getKey().getName()
				+ " ��  : [" + jobRunTime + "] ִ����!!");

		// ����ִ�м��� �ۼ�
		JobDataMap map = context.getJobDetail().getJobDataMap();
		int executeCount = 0;
		if (map.containsKey(NUM_EXECUTIONS)) {
			executeCount = map.getInt(NUM_EXECUTIONS);
		}
		executeCount++;
		map.put(NUM_EXECUTIONS, executeCount);

		// ˯��ʱ��: �ɵ�������������ֵ ,����Ϊ ˯��10s
		long delay = 5000l;
		if (map.containsKey(EXECUTION_DELAY)) {
			delay = map.getLong(EXECUTION_DELAY);
		}

		try {
			Thread.sleep(delay);
		} catch (Exception ignore) {
		}

		// ˯�������󣬴�ӡ����ִ�н�������Ϣ
		System.err.println("  -" + context.getJobDetail().getKey().getName()
				+ " ��ɴ���  : " + executeCount);

	}

}
