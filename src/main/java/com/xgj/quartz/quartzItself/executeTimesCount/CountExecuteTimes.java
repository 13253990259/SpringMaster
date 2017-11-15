package com.xgj.quartz.quartzItself.executeTimesCount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 * 
 * 
 * @ClassName: CountExecuteTimes
 * 
 * @Description: ʹ��quartz��Ϊ��̨������ȿ�ܣ�cron���ʽ����ʱ�䣬��Ҫ����cron���ʽ��������n�ε�ִ�о���ʱ��--
 *               ���ͨ���ڿ��Ÿ��û��޸�����ִ��ʱ�������ʾʱ�ǳ�����.
 * 
 *               ������ʹ��quartz��jar�����ṩ��TriggerUtils��������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��11��15�� ����11:24:03
 */
public class CountExecuteTimes {

	public static void main(String[] args) {

		try {

			CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();

			// ÿ������10��15����
			cronTriggerImpl.setCronExpression("0 15 10 * * ?");

			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();
			calendar.add(Calendar.MONTH, 1);// ��ͳ�Ƶ����������Ϊ�����ڵ�1�º�Ľ��죨��Ҫ��Ϊ�˷���ͨ�ÿ���)

			// �����ʱ���Ǹ���corn���ʽ�������ֵ
			List<Date> dates = TriggerUtils.computeFireTimesBetween(
					cronTriggerImpl, null, now,
					calendar.getTime());
			System.out.println(dates.size());

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Date date : dates) {
				System.out.println(dateFormat.format(date));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
