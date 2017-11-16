package com.xgj.quartz.quartzItself.listener.triggerListener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {
	@Override
	public String getName() {
		return "MyTriggerListener";
	}

	/**
	 * (1) Trigger������ ��������job����������
	 *
	 * @param trigger
	 * @param context
	 */
	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println("MyTrigger��������" + trigger.getJobKey()
				+ "�����뷽�� triggerFired()");
	}

	/**
	 * (2) Trigger������ ��������job����������,��ִ��(1)����ִ��(2) �������TRUE ��ô����job�ᱻ��ֹ
	 *
	 * @param trigger
	 * @param context
	 * @return
	 */
	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		System.out.println("MyTrigger��������" + trigger.getJobKey()
				+ "��vetoJobExecution()");
		return false;
	}

	/**
	 * (3) ��Trigger���������ʱִ��,���統ǰʱ���кܶഥ��������Ҫִ�У������̳߳��е���Ч�̶߳��ڹ�������ô�еĴ��������п��ܳ�ʱ��
	 * �����һ�ֵĴ�����
	 *
	 * @param trigger
	 */
	@Override
	public void triggerMisfired(Trigger trigger) {
		System.out.println("MyTrigger��������" + trigger.getJobKey()
				+ "��triggerMisfired()");
	}

	/**
	 * (4) �������ʱ����
	 *
	 * @param trigger
	 * @param jobExecutionContext
	 * @param completedExecutionInstruction
	 */
	@Override
	public void triggerComplete(Trigger trigger,
			JobExecutionContext jobExecutionContext,
			Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
		System.out.println("MyTrigger��������" + trigger.getJobKey()
				+ "��triggerComplete()");
	}
}
