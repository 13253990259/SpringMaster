package com.xgj.oxm.xstream.quickDemo.aliasDemo.officeDemo;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	// Author
	private Author writer;

	// Entry����
	private List<Entry> entries = new ArrayList<Entry>();

	/**
	 * 
	 * 
	 * @Title:Blog
	 * 
	 * @Description:���캯��
	 * 
	 * @param writer
	 */
	public Blog(Author writer) {
		this.writer = writer;
	}

	/**
	 * 
	 * 
	 * @Title: add
	 * 
	 * @Description: ���Entry
	 * 
	 * @param entry
	 * 
	 * @return: void
	 */
	public void add(Entry entry) {
		entries.add(entry);
	}

	/**
	 * 
	 * 
	 * @Title: getContent
	 * 
	 * @Description: ��ȡEntry List����
	 * 
	 * @return
	 * 
	 * @return: List<Entry>
	 */
	public List<Entry> getContent() {
		return entries;
	}
}
