package com.xgj.cache.selfCacheManagerDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 
 * @ClassName: CacheManager
 * 
 * @Description: ������-�Զ��建��������Ĵ���ʵ��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��2�� ����1:10:13
 */

public class CacheManager<T> {

	/**
	 * ConcurrentHashMap - �̰߳�ȫ�ļ�������
	 */
	Map<Object, T> cacheMap = new ConcurrentHashMap<Object, T>();

	/**
	 * 
	 * 
	 * @Title: getValue
	 * 
	 * @Description: ����Key��ȡ��������
	 * 
	 * @param key
	 * @return
	 * 
	 * @return: T
	 */
	public T getValue(Object key) {
		return cacheMap.get(key);
	}

	/**
	 * 
	 * 
	 * @Title: addOrUpdateCache
	 * 
	 * @Description: ��ӻ��߸��»���
	 * 
	 * @param key
	 * @param value
	 * 
	 * @return: void
	 */
	public void addOrUpdateCache(Object key, T value) {
		cacheMap.put(key, value);
	}

	/**
	 * 
	 * 
	 * @Title: evictCache
	 * 
	 * @Description: ����key�� �ӻ���������ض���key��¼
	 * 
	 * @param key
	 * 
	 * @return: void
	 */
	public void evictCache(Object key) {
		if (cacheMap.containsKey(key)) {
			cacheMap.remove(key);
		}
	}

	/**
	 * 
	 * 
	 * @Title: evictCache
	 * 
	 * @Description: ��ջ����е�����
	 * 
	 * 
	 * @return: void
	 */
	public void evictCache() {
		cacheMap.clear();
	}
}
