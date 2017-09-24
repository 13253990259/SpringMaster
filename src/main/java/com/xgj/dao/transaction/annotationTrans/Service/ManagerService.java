package com.xgj.dao.transaction.annotationTrans.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xgj.dao.transaction.annotationTrans.dao.StudentDao;
import com.xgj.dao.transaction.annotationTrans.dao.TeacherDao;
import com.xgj.dao.transaction.annotationTrans.domain.Student;
import com.xgj.dao.transaction.annotationTrans.domain.Teacher;

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
@Transactional
public class ManagerService {

	private TeacherDao teacherDao;
	private StudentDao studentDao;

	/**
	 * 
	 * 
	 * @Title: addTeacherAndStudent
	 * 
	 * @Description: @Transactional��ע��һ��������
	 * 
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
