package com.jxdedu.biz.impl;

import java.util.List;

import com.jxdedu.biz.CourseBiz;
import com.jxdedu.dao.impl.CourseDaoImpl;
import com.jxdedu.entity.Course;

public class CourseBizImpl implements CourseBiz {

	@Override
	public boolean addCourse(Course course) {
		return new CourseDaoImpl().addCourse(course);
	}

	@Override
	public boolean editCourse(Course course) {
		return new CourseDaoImpl().editCourse(course);
	}

	@Override
	public boolean delCourse(int classId) {
		return new CourseDaoImpl().delCourse(classId);
	}

	@Override
	public List<Course> getAllCourse() {
		return new CourseDaoImpl().getAllCourse();
	}

	@Override
	public List<Course> getSubCourse(int startIndex, int endIndex) {
		return new CourseDaoImpl().getSubCourse(startIndex, endIndex);
	}

	@Override
	public int getRowNum() {
		return new CourseDaoImpl().getRowNum();
	}

	@Override
	public Course getCourseByClassId(int classId) {
		return new CourseDaoImpl().getCourseByClassId(classId);
	}

}
