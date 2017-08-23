package com.xgj.aop.spring.advisor.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: NeedTest
 * 
 * @Description: �Զ���ע��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��23�� ����4:50:11
 */

// ����ע��ı�������
@Retention(RetentionPolicy.RUNTIME)
// ��������ʹ�ø�ע���Ŀ������
@Target(ElementType.METHOD)
// ���Ա�javadoc����Ĺ����ĵ���
@Documented
public @interface NeedTestAnnotation { // ����ע��
	// ����ע���Ա
	boolean value() default false;
}
