package com.xgj.aop.spring.advice.throwsAdvice;

public class ForumService {
	public void removeForum() {
		// ������Ӧ�����ݿ������������ֻΪ��ʾ�׳��쳣
		throw new RuntimeException("removeForum:Exception...");
	}

	public void updateForum() {
		// ������Ӧ�����ݿ������������ֻΪ��ʾ�׳��쳣
		throw new RuntimeException("updateForum:Exception...");
	}
}
