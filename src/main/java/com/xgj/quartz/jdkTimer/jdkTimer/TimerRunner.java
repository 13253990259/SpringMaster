package com.xgj.quartz.jdkTimer.jdkTimer;

import java.util.Timer;

public class TimerRunner {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
		// �ӳ�1�룬ÿ5Sִ��һ������
		timer.schedule(myTask, 1000L, 5000L);

	}
}
