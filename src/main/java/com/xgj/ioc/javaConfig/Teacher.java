package com.xgj.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ��һ��POJO��עΪ����Bean��������
@Configuration
public class Teacher {

	/**
	 * 
	 * 
	 * @Title: studentOne
	 * 
	 * @Description: ������һ��Bean,���ṩ��Bean��ʵ�����߼�
	 * 
	 * @return
	 * 
	 * @return: StudentOne
	 */
	@Bean
	public StudentOne studentOne() {
		return new StudentOne();
	}

	/**
	 * 
	 * 
	 * @Title: studentTwo
	 * 
	 * @Description: ������һ��Bean,���ṩ��Bean��ʵ�����߼�
	 * 
	 * @return
	 * 
	 * @return: StudentTwo
	 */
	@Bean
	public StudentTwo studentTwo() {
		return new StudentTwo();
	}

	public void arrangeStudent() {
		studentOne().doCleanWork();
		studentTwo().doHomeWork();
	}

}
