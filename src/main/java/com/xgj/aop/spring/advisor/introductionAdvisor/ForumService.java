package com.xgj.aop.spring.advisor.introductionAdvisor;

public class ForumService {
	public void removeTopic(int topicId) {
		System.out.println("ģ��ɾ��Topic��¼:" + topicId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 20));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void removeForum(int forumId) {
		System.out.println("ģ��ɾ��Forum��¼:" + forumId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 20));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
