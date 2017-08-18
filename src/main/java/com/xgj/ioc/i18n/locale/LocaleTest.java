package com.xgj.ioc.i18n.locale;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		// (1)�������Ժ͹���/������Ϣ�ı��ػ�����
		Locale locale1 = new Locale("zh", "CN");
		System.out.println("Locale(\"zh\", \"CN\"):" + locale1);

		// (2)ֻ����������Ϣ�ı��ػ�����
		Locale locale2 = new Locale("zh");
		System.out.println("Locale(\"zh\"):" + locale2);

		// (3)��ͬ��Locale("zh", "CN")
		Locale locale3 = Locale.CHINA;
		System.out.println("Locale.CHINA:" + locale3);

		// (4)��ͬ��Locale("zh")
		Locale locale4 = Locale.CHINESE;
		System.out.println("Locale.CHINESE:" + locale4);

		// (5)��ȡ����ϵͳĬ�ϵı��ػ�����
		Locale locale5 = Locale.getDefault();
		System.out.println("Locale.getDefault():" + locale5);
	}
}
