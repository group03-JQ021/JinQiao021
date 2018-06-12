package com.jxdedu.biz.impl;

import java.util.List;

import com.jxdedu.biz.StudentBiz;
import com.jxdedu.dao.impl.StudentDaoImpl;
import com.jxdedu.entity.Student;

public class StudentBizImpl implements StudentBiz {

	@Override
	public boolean addStudent(Student stu) {
		return new StudentDaoImpl().addStudent(stu);
	}

	@Override
	public boolean delStudent(String stuId) {
		return new StudentDaoImpl().delStudent(stuId);
	}

	@Override
	public boolean editStudent(Student stu) {
		return new StudentDaoImpl().editStudent(stu);
	}

	@Override
	public List<Student> getAllStudent() {
		return new StudentDaoImpl().getAllStudent();
	}

	@Override
	public List<Student> getOneStudentByName(String name) {
		return new StudentDaoImpl().getOneStudentByName(name);
	}

	@Override
	public List<Student> getSubStudent(int startIndex, int endIndex) {
		return new StudentDaoImpl().getSubStudent(startIndex, endIndex);
	}

	@Override
	public int getRowNum() {
		return new StudentDaoImpl().getRowNum();
	}

	@Override
	public Student getStudentById(int stuId) {
		return new StudentDaoImpl().getStudentById(stuId);
	}

}
