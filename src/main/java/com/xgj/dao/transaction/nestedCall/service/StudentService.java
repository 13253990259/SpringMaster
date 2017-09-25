package com.xgj.dao.transaction.nestedCall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.nestedCall.dao.StudentDao;
import com.xgj.dao.transaction.nestedCall.domain.Student;

/**
 * 
 * 
 * @ClassName: StudentService
 * 
 * @Description: @Service��ע��service��
 * 
 *               StudentService�̳�BaseService��������־�п��� Participating in existing
 *               transaction
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��24�� ����7:47:09
 */

@Service
public class StudentService extends BaseService {

	private StudentDao studentDao;

	/**
	 * 
	 * 
	 * @Title: setStudentDao
	 * 
	 * @Description: @Autowiredͨ��set����ע��studentDao
	 * 
	 * @param studentDao
	 * 
	 * @return: void
	 */

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 
	 * 
	 * @Title: addStudent
	 * 
	 * @Description: ����ѧ��
	 * 
	 * @param student
	 * 
	 * @return: void
	 */
	public void updateSutdent(Student student) {
		studentDao.updateStudent(student);
	}

}
