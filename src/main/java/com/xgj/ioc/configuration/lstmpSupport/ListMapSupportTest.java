package com.xgj.ioc.configuration.lstmpSupport;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListMapSupportTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/lstmpSupport/beans.xml");
		// �������л�ȡbean
		MyComponent myComponent = ctx.getBean("myComponent", MyComponent.class);
		// ��ȡMap����
		Map<String, Plugin> map = myComponent.getPluginMap();
		// Map����key��value
		for (Entry<String, Plugin> entry : map.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println("value:" + entry.getValue());
		}
		// ��ȡlist����
		List<Plugin> list = myComponent.getPlugins();
		// ����list
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list�е�Ԫ��" + i + "Ϊ" + list.get(i));
		}
	}
}
