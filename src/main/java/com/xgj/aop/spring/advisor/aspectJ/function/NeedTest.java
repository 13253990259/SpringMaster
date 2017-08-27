package com.xgj.aop.spring.advisor.aspectJ.function;

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
 * @Description: �Զ���ע��@NeedTest
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��8��26�� ����11:19:12
 */

// ����ע��ı�������
@Retention(RetentionPolicy.RUNTIME)
// ��������ʹ�ø�ע���Ŀ������
@Target(ElementType.METHOD)
@Documented
public @interface NeedTest {
	// ����ע���Ա
	boolean value() default false;
}
