package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//����ע��ı�������
@Retention(RetentionPolicy.RUNTIME)
// ��������ʹ�ø�ע���Ŀ������
@Target(ElementType.TYPE)
// ���Ա�javadoc����Ĺ����ĵ���
@Documented
public @interface Monitor { // ����ע��
	// ����ע���Ա
	boolean value() default false;
}
