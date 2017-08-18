package com.xgj.aop.base.cglib;

/**
 * 
 * 
 * @ClassName: ForumService
 * 
 * @Description: ForumService�ӿ�
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��12�� ����4:13:31
 */
public interface ForumService {
	/**
	 * 
	 * 
	 * @Title: removeTopic
	 * 
	 * @Description: ����topicIdɾ��Topic
	 * 
	 * @param topicId
	 * 
	 * @return: void
	 */
	void removeTopic(int topicId);

	/**
	 * 
	 * 
	 * @Title: removeForum
	 * 
	 * @Description: ����forumIdɾ��Forum
	 * 
	 * @param forumId
	 * 
	 * @return: void
	 */
	void removeForum(int forumId);
}
