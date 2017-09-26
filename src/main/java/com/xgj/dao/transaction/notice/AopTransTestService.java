package com.xgj.dao.transaction.notice;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @ClassName: AopTransTestService
 * 
 * @Description: �������ļ��п���proxy-target-class="true" ʹ��CGlib��̬�ֽ��뼼��֯��AOP������ǿ
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��26�� ����2:01:33
 */

@Service
public class AopTransTestService {

	/**
	 * 
	 * 
	 * @Title: method1
	 * 
	 * @Description: private������Ϊ���η�����Ȩ�޵Ŀ��ƣ��޷������า��
	 * 
	 * 
	 * @return: void
	 */
	private void method1() {
		System.out.println("method1 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method2
	 * 
	 * @Description: final�����޷������า��
	 * 
	 * 
	 * @return: void
	 */
	private final void method2() {
		System.out.println("method2 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method3
	 * 
	 * @Description: static�������༶��ķ������޷������า��
	 * 
	 * 
	 * @return: void
	 */
	private static void method3() {
		System.out.println("method3 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method4
	 * 
	 * @Description: public�������Ա����า�ǣ���˿��Ա���̬�ֽ�����ǿ
	 * 
	 * 
	 * @return: void
	 */
	public void method4() {
		System.out.println("method4 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method5
	 * 
	 * @Description: final�����޷������า��
	 * 
	 * 
	 * @return: void
	 */
	public final void method5() {
		System.out.println("method5 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method6
	 * 
	 * @Description: protected�������Ա����า�ǣ���˿��Ա���̬�ֽ�����ǿ
	 * 
	 * 
	 * @return: void
	 */
	protected void method6() {
		System.out.println("method6 executed");
	}

	/**
	 * 
	 * 
	 * @Title: main
	 * 
	 * @Description: ����
	 * 
	 * @param args
	 * 
	 * @return: void
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = null;
		AopTransTestService aopTransTestService = null;

		// ����Spring ����
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/notice/conf_tx_notice.xml");
		aopTransTestService = ctx.getBean("aopTransTestService",
				AopTransTestService.class);
		System.out.println("initContext successfully");

		System.out.println("before method1");
		aopTransTestService.method1();
		System.out.println("after1 method1");

		System.out.println("before method2");
		aopTransTestService.method2();
		System.out.println("after1 method2");

		System.out.println("before method3");
		aopTransTestService.method3();
		System.out.println("after1 method3");

		System.out.println("before method4");
		aopTransTestService.method4();
		System.out.println("after1 method4");

		System.out.println("before method5");
		aopTransTestService.method5();
		System.out.println("after1 method5");

		System.out.println("before method6");
		aopTransTestService.method6();
		System.out.println("after1 method6");

		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
