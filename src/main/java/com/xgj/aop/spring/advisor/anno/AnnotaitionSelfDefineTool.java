package com.xgj.aop.spring.advisor.anno;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: AnnotaitionSelfDefineTool
 * 
 * @Description: ����ע��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��23�� ����5:18:26
 */
public class AnnotaitionSelfDefineTool {

	@Test
	public void test() {
		// �õ���Ӧ��Class
		Class<ForumService> clazz = ForumService.class;

		// ��Ϊ��ע�ڷ�����,�����ȵõ���Ӧ�ķ���
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(clazz.getName() + " �� " + methods.length + " ������");
		// ��������
		for (Method method : methods) {
			// ��ȡ�����ϵ�ע��
			NeedTestAnnotation needTestAnnotation = method
					.getAnnotation(NeedTestAnnotation.class);
			// �ж��Ƿ��б�ע��ע��
			if (needTestAnnotation != null) {
				// ��ȡע���ж����ֵ��������
				if (needTestAnnotation.value()) {
					System.out.println(method.getName() + "��Ҫ����");
				} else {
					System.out.println(method.getName() + "����Ҫ����");
				}
			}
		}
	}
}
