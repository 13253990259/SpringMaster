package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.multiThreadinTrans.domain.Student;

/**
 * 
 * 
 * @ClassName: MulitThreadService
 * 
 * @Description: �̳г������MulitThreadBaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��26�� ����4:44:18
 */

@Service
public class MulitThreadService extends MulitThreadBaseService {

	private AnotherService anotherService;

	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	public void setAnotherService(AnotherService anotherService) {
		this.anotherService = anotherService;
	}

	/**
	 * 
	 * 
	 * @Title: executeLogic
	 * 
	 * @Description: (1)��executeLogic������������һ���������̣߳�
	 *               �ڸö������߳���ִ��AnotherService#doAnotherThing ()����
	 * 
	 * 
	 * @return: void
	 */
	public void executeLogic() {
		System.out.println("logon method...");
		// ���ñ������������
		method1();

		// ����������ķ�������ͬһ���߳��е���anotherService#doAnotherThing(),��������ͬһ��������
		anotherService.doAnotherThing();

		// ��һ���µ��߳��е���anotherService#doAnotherThing(),������һ���µ�����
		// ע�⣺ ������Ҫʹ�� extend Thread�ķ�ʽ ��ͨ��implements Runnable ������֤���Ὺ���µ�����
		new MyThread().start();
		// �������߼��룬����ִ�в��� ���߳��е� ����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// new MyThread1().run(); �����ӵ����ڵ������У�ԭ����ʱδ֪

	}

	public void method1() {
		System.out.println("method1 begins");
		System.out.println("ģ��ִ��jdbc����");
		System.out.println("method1 finish");
	}

	/**
	 * 
	 * 
	 * @ClassName: MyThread
	 * 
	 * @Description: ����ִ��AnotherService#doAnotherThing()���߳�
	 * 
	 * @author: Mr.Yang
	 * 
	 * @date: 2017��9��26�� ����4:50:29
	 */
	class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("before studentService.updateSutdent method..."
					+ anotherService.getClass().getName());

			// anotherService.doAnotherThing();
			Student student = new Student();
			student.setName("1XXX");
			student.setAge(112);
			student.setSex("1B");
			student.setStudentId(1);
			studentService.updateSutdent(student);
			System.out.println("after studentService.updateSutdent method...");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class MyThread1 implements Runnable {
		@Override
		public void run() {
			System.out.println("before studentService.updateSutdent method..."
					+ anotherService.getClass().getName());
			// anotherService.doAnotherThing();
			Student student = new Student();
			student.setName("XXX");
			student.setAge(12);
			student.setSex("B");
			student.setStudentId(1);
			studentService.updateSutdent(student);
			System.out.println("after studentService.updateSutdent method..."
					+ anotherService.getClass().getName());
		}
	}

}
