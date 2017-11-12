package com.xgj.quartz.quartzWithSpring.anno;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyAnnoJob {

	@Scheduled(cron = "*/5 * * * * ?")
	// ÿ��5��ִ��һ��
	public void test() throws Exception {
		System.out.println("Spring����Quartz ʹ�� Annotation�ķ�ʽ......");
	}
}
