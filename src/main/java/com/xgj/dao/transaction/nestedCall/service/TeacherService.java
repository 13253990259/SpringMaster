package com.xgj.dao.transaction.nestedCall.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.nestedCall.dao.TeacherDao;
import com.xgj.dao.transaction.nestedCall.domain.Student;
import com.xgj.dao.transaction.nestedCall.domain.Teacher;

/**
 * 
 * 
 * @ClassName: TeacherService
 * 
 * @Description: @Service��ע��service�� �̳�BaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��24�� ����4:56:35
 */

@Service
public class TeacherService extends BaseService {

	Logger logger = Logger.getLogger(TeacherService.class);

	private TeacherDao teacherDao;
	private StudentService studentService;

	@Autowired
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * 
	 * 
	 * @Title: init
	 * 
	 * @Description: �ķ���Ƕ�׵����˱�������������Լ�������ķ���
	 * 
	 * 
	 * @return: void
	 */
	public void doSomething() {
		logger.info("before TeacherService#udpateTeacherInfo");
		// ���ñ������������
		udpateTeacherInfo(simulateTeacher());
		logger.info("after TeacherService#udpateTeacherInfo");

		// ����������ķ���
		logger.info("before StudentService#updateSutdent");
		studentService.updateSutdent(simulateStudent());
		logger.info("after StudentService#updateSutdent");

	}

	public void udpateTeacherInfo(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	/**
	 * 
	 * 
	 * @Title: simulateTeacher
	 * 
	 * @Description: ģ���ȡһ��teacherʵ��
	 * 
	 * @return
	 * 
	 * @return: Teacher
	 */
	private Teacher simulateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("FTT");
		teacher.setAge(88);
		teacher.setSex("FF");
		teacher.setTeacherId(2);
		return teacher;
	}

	private Student simulateStudent() {
		Student student = new Student();
		student.setName("FSS");
		student.setAge(22);
		student.setSex("MM");
		student.setStudentId(2);
		return student;
	}

}
