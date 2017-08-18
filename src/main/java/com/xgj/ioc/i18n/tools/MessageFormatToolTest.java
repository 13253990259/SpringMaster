package com.xgj.ioc.i18n.tools;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageFormatToolTest {

	public static void main(String[] args) {
		// (1)��ʽ����Ϣ��
		String pattern1 = "{0},��ã�����{1}֧���˻���{2}Ԫ";
		String pattern2 = "At {1,time,short} on {1,date,long},{0} paid {2,number,currency}";
		// (2)���ڶ�̬�滻ռλ���Ĳ���
		Object[] params = { "XiaoGongJiang", new GregorianCalendar().getTime(),
				200 };
		// (3)ʹ��Ĭ�ϵı��ػ������ʽ����Ϣ
		String msg1 = MessageFormat.format(pattern1, params);
		// (4)ʹ��ָ���ı��ػ������ʽ����Ϣ
		MessageFormat messageFormat = new MessageFormat(pattern2, Locale.US);
		String msg2 = messageFormat.format(params);

		System.out.println(msg1);
		System.out.println(msg2);

	}
}
