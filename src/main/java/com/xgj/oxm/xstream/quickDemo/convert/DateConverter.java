package com.xgj.oxm.xstream.quickDemo.convert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {

	private Locale locale;

	public DateConverter(Locale locale) {
		super();
		this.locale = locale;
	}

	/**
	 * ��д�÷������ж���Ҫת��������
	 */
	@Override
	public boolean canConvert(Class type) {
		return Date.class.isAssignableFrom(type);
	}

	/**
	 * ��д�÷�������дJava �� XML ��ת���߼�
	 */
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		
		// DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD,
		// this.locale);
		
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", this.locale);

		writer.setValue(format.format(source));

	}

	/**
	 * ��д�÷�������дXML �� Java ��ת���߼�
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

		GregorianCalendar calendar = new GregorianCalendar();

		// DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD,
		// this.locale);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				this.locale);

		try {
			calendar.setTime(format.parse(reader.getValue()));
		} catch (Exception e) {
			throw new ConversionException(e.getMessage(), e);
		}

		return calendar.getGregorianChange();
	}

}
