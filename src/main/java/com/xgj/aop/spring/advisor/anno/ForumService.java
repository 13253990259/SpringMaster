package com.xgj.aop.spring.advisor.anno;

/**
 * 
 * 
 * @ClassName: ForumService
 * 
 * @Description: ��ʾʹ���Զ���ע��@NeedTestAnnotation
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��23�� ����5:15:18
 */
public class ForumService {

	@NeedTestAnnotation
	public void removeTopicId(int topicId) {
		System.out.println("remove topicId" + topicId);
	}

	@NeedTestAnnotation(true)
	public void removeForumId(int forumId) {
		System.out.println("remove forumId" + forumId);
	}
}
