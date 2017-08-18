package com.xgj.aop.base.cglib;

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
		// ģ��ҵ���߼�
		System.out.println("ģ��ɾ��Topic,topicId=" + topicId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeForum(int forumId) {
		// ģ��ҵ���߼�
		System.out.println("ģ��ɾ��forum,forumId=" + forumId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
