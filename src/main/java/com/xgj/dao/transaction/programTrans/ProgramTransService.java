package com.xgj.dao.transaction.programTrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * 
 * @ClassName: ProgramTransService
 * 
 * @Description: ��ʵ��Ӧ���У�����ͨ����̵ķ�ʽ�������������
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��21�� ����3:48:10
 */

@Service
public class ProgramTransService {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;

	// ��������SQL��һ�������У��ڶ�������д���˱�������ִ��ʧ�ܣ���һ���Ѿ��ɹ���SQLҲ��ع�
	private static final String addArtisanSQL = "insert into artisan_user(user_name,password) values(?,?)";
	private static final String deleteOneArtisanSQL = "delete from artisan_user1 where user_name = 'ArtisanBatch0' ";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: setTransactionTemplate
	 * 
	 * @Description: ͨ��AOP����ע��transactionTemplate
	 * 
	 * @param transactionTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void operArtisanInTrans(final Artisan artisan) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// ��Ҫ��������ִ�е��߼�
				jdbcTemplate.update(addArtisanSQL, artisan.getUserName(),
						artisan.getPassword());
				System.out.println("addArtisanSQL  OK ");
				jdbcTemplate.update(deleteOneArtisanSQL);
				System.out.println("deleteOneArtisanSQL  OK ");
			}
		});

	}
}
