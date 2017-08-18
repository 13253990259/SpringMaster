package com.xgj.ioc.i18n.tools;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class FormatToolTest {

	public static void main(String[] args) {
		// ���ı��ػ���Ϣ
		Locale locale = Locale.CHINA;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

		double amt = 123456.78;
		System.out.println(numberFormat.format(amt));
		// Ӣ�ı��ػ���Ϣ
		Locale locale2 = Locale.US;
		NumberFormat nFormat = NumberFormat.getCurrencyInstance(locale2);

		double amt2 = 123456.78;
		System.out.println(nFormat.format(amt2));

		// Ӣ�ı��ػ���Ϣ
		Locale locale3 = new Locale("en", "US");
		Date date = new Date();
		// ���ձ��ػ��ķ�ʽ�����ڽ��и�ʽ������
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,
				locale3);
		System.out.println(dateFormat.format(date));

		// ���ı��ػ���Ϣ
		Locale locale4 = new Locale("zh", "CN");
		Date date2 = new Date();
		// ���ձ��ػ��ķ�ʽ�����ڽ��и�ʽ������
		DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.MEDIUM,
				locale4);
		System.out.println(dateFormat2.format(date2));

	}
}
