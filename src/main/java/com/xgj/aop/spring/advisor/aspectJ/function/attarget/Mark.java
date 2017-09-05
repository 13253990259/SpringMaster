package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: Mark
 * 
 * @Description: �Զ���ע��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����12:02:46
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Mark {

	public String value() default "";

}
