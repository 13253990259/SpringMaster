package com.xgj.dao.transaction.xmlTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.xmlTrans.dao.StudentDao;
import com.xgj.dao.transaction.xmlTrans.dao.TeacherDao;
import com.xgj.dao.transaction.xmlTrans.domain.Student;
import com.xgj.dao.transaction.xmlTrans.domain.Teacher;

/**
 * 
 * 
 * @ClassName: ManagerService
 * 
 * @Description: @Service��ע��Service��
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��22�� ����10:18:31
 */

@Service
public class ManagerService {

	private TeacherDao teacherDao;
	private StudentDao studentDao;

	/**
	 * 
	 * 
	 * @Title: addTeacherAndStudent
	 * 
	 * @Description: �����ļ���<tx:method name="add*" rollback-for="Exception"/>
	 *               ���ǹ��⾭д��student��ʱ�������쳣������teacher�Ƿ�ع�--OK ��û��д�룬˵����һ��������
	 *               �����ȥ��<tx:method name="add*"
	 *               rollback-for="Exception"/>������֤Teacher�ɳɹ����ӣ�˵������һ��������
	 * 
	 *               rollback-for="Exception"����ɲ��ӣ�Ĭ���ǻع���
	 * @param teacher
	 * @param student
	 * 
	 * @return: void
	 */
	public void addTeacherAndStudent(Teacher teacher, Student student) {
		teacherDao.addTeacher(teacher);
		studentDao.addStudent(student);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	public void getTeacherById(int teacherId) {
		teacherDao.getTeacher(teacherId);
	}

	@Autowired
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}
