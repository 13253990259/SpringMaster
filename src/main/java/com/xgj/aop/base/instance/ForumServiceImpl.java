package com.xgj.aop.base.instance;

/**
 * 
 * 
 * @ClassName: ForumServiceImpl
 * 
 * @Description: ForumServiceʵ����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��12�� ����4:14:30
 */
public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		// 1-��1����ʼ��removeTopic�����ļ��
		PerformanceMonitor
				.begin("com.xgj.aop.base.instance.ForumServiceImpl.removeTopic");

		// ģ��ҵ���߼�
		System.out.println("ģ��ɾ��Topic");
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1-��2��������removeTopic�����ļ��
		PerformanceMonitor
				.end("com.xgj.aop.base.instance.ForumServiceImpl.removeTopic");
	}

	@Override
	public void removeForum(int forumId) {
		// 2-��1����ʼ��removeForum���ļ��
		PerformanceMonitor
				.begin("com.xgj.aop.base.instance.ForumServiceImpl.removeForum");
		// ģ��ҵ���߼�
		System.out.println("ģ��ɾ��forum");
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 2-��2��������removeForum���ļ��
		PerformanceMonitor
				.end("com.xgj.aop.base.instance.ForumServiceImpl.removeForum");
	}

}
