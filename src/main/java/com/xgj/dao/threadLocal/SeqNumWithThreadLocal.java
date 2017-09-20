package com.xgj.dao.threadLocal;

public class SeqNumWithThreadLocal {

	private ThreadLocal<Integer> seqNumLocal = new ThreadLocal<Integer>() {
		// ͨ�������ڲ��า��initialValue������ָ����ʼֵ
		protected Integer initialValue() {
			return 0;
		}
	};

	// ��ȡ��һ������ֵ
	public int getNextNum() {
		seqNumLocal.set(seqNumLocal.get() + 1);
		return seqNumLocal.get();
	}

	public static void main(String[] args) {
		SeqNumWithThreadLocal seqNum = new SeqNumWithThreadLocal();
		TestThread t1 = new TestThread(seqNum);
		TestThread t2 = new TestThread(seqNum);
		TestThread t3 = new TestThread(seqNum);

		t1.start();
		t2.start();
		t3.start();

	}

	@SuppressWarnings("unused")
	static class TestThread extends Thread {

		SeqNumWithThreadLocal sn = new SeqNumWithThreadLocal();

		public TestThread(SeqNumWithThreadLocal sn) {
			this.sn = sn;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) { // ÿ���̴߳�ӡ 5��ֵ
				System.out.println("Thread:" + Thread.currentThread().getName()
						+ ",sn:" + sn.getNextNum());
			}
		}

	}

}
