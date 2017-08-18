package com.xgj.aop.introduce;

public class ForumService {
	private TransactionManager transManager;
	private PerformanceMonitor pmonitor;
	private TopicDao topicDao;
	private ForumDao forumDao;

	public void removeTopic(int topicId) {
		// ���ܼ��ӿ�ʼ
		pmonitor.start();
		// ����ʼ
		transManager.beginTransaction();
		// ��1��ҵ�����
		topicDao.removeTopic(topicId);

		// �������
		transManager.endTransaction();
		// ���ܼ��ӽ���
		pmonitor.end();
	}

	public void CreateForum(Forum forum) {
		pmonitor.start();
		transManager.beginTransaction();
		// ��2��ҵ�����
		forumDao.create(forum);

		transManager.endTransaction();
		pmonitor.end();
	}
}
