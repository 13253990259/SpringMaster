package com.xgj.dao.transaction.multiTxManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulitTxServiceWitSpecificName {

	// ʹ����Ϊforum�����������
	@Transactional("forum")
	public void addForum() {

	}

	// ʹ����Ϊtopic�����������
	@Transactional("topic")
	public void addTopic() {

	}
}
