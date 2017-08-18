package com.xgj.aop.base.instance;

public class PerformanceMonitor {
	// ͨ��һ��ThreadLocal����������߳���ص����ܼ�����Ϣ
	private static ThreadLocal<MethoPerformance> performanceLocal = new ThreadLocal<MethoPerformance>();

	/**
	 * 
	 * 
	 * @Title: begin
	 * 
	 * @Description: ������ĳһĿ�귽�������ܼ���
	 * 
	 * @param method
	 * 
	 * @return: void
	 */
	public static void begin(String method) {
		System.out.println("begin to monitor:" + method);
		MethoPerformance methoPerformance = new MethoPerformance(method);
		performanceLocal.set(methoPerformance);
	}

	/**
	 * 
	 * 
	 * @Title: end
	 * 
	 * @Description: ������ܼ��ӽ��
	 * 
	 * @param method
	 * 
	 * @return: void
	 */
	public static void end(String method) {
		System.out.println("finish monitor:" + method);

		MethoPerformance methoPerformance = performanceLocal.get();
		// ��ӡ���������ܼ��ӵĽ����Ϣ
		methoPerformance.printPerformance();
	}
}
