package com.xgj.dao.transaction.multiTxManager;

import org.springframework.stereotype.Service;

@Service
public class MulitTxServiceWithSelfDefineAnno {

	// ʹ����Ϊforum�����������
	@ForumTransactional
	public void addForum() {

	}

	// ʹ����Ϊtopic�����������
	@TopicTransactional
	public void addTopic() {

	}
}
