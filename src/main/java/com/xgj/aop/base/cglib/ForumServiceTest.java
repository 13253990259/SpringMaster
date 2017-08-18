package com.xgj.aop.base.cglib;

public class ForumServiceTest {

	public static void main(String[] args) {

		CglibProxy cglibProxy = new CglibProxy();
		// ͨ����̬��������ķ�ʽ����������
		ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy
				.getProxy(ForumServiceImpl.class);
		// ���ô������ҵ�񷽷�
		forumService.removeTopic(1);
		forumService.removeForum(2);
	}
}
