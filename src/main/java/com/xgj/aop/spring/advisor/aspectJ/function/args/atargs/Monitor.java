package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: Monitor
 * 
 * @Description: �Զ���ע�� @Monitor
 *               ������Ϣ���Ķ�http://blog.csdn.net/yangshangwei/article/
 *               details/77477840
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��1�� ����4:00:12
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface Monitor {

	public boolean value() default true;
}
