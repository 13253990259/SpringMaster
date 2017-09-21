package com.xgj.dao.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @ClassName: SimpleThreadLocaByOurSelf
 * 
 * @Description: ThreadLocal��α����,����ʵ�֣���Ҫ����ԭ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��19�� ����4:58:23
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SimpleThreadLocalByOurSelf {

	private Map valueMap = Collections.synchronizedMap(new HashMap());

	/**
	 * 
	 * 
	 * @Title: set
	 * 
	 * @Description: ��Ϊ�̶߳���,ֵΪ���̵߳ı�������
	 * 
	 * @param newValue
	 * 
	 * @return: void
	 */
	public void set(Object newValue) {
		valueMap.put(Thread.currentThread(), newValue);
	}

	/**
	 * 
	 * 
	 * @Title: get
	 * 
	 * @Description: ���Map��û��key ,������Ϊ��ʼֵnull����������Map��,�����map�л�ȡ
	 * 
	 * 
	 * @return: void
	 */
	public void get() {
		Thread currentThread = Thread.currentThread();
		Object object = valueMap.get("currentThread");
		if (object == null && !valueMap.containsKey(currentThread)) {
			object = initValue();
			valueMap.put(currentThread, object);
		} else {
			object = valueMap.get(currentThread);
		}
	}

	/**
	 * 
	 * 
	 * @Title: remove
	 * 
	 * @Description: �Ƴ�
	 * 
	 * 
	 * @return: void
	 */
	public void remove() {
		Thread currentThread = Thread.currentThread();
		valueMap.remove(currentThread);
	}

	/**
	 * 
	 * 
	 * @Title: initValue
	 * 
	 * @Description: ��ʼֵ
	 * 
	 * @return
	 * 
	 * @return: Object
	 */
	private Object initValue() {
		return null;
	}
}
