package com.jxdedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jxdedu.dao.CourseDao;
import com.jxdedu.entity.Course;
import com.jxdedu.util.C3P0DBUtil;

public class CourseDaoImpl implements CourseDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public Course creatCourse(ResultSet rs){
		Course course = new Course();
		try{
			course.setClassId(rs.getInt("classId"));
			course.setClassName(rs.getString("className"));
			course.setClassState(rs.getString("classState"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return course;
	}
	@Override
	public boolean addCourse(Course course) {
		boolean isAdd = false;
		String sql = "insert into course(classId,className,classState) values(seq_course.nextval,?,?)";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getClassName());
			ps.setString(2, course.getClassState());
			int row = ps.executeUpdate();
			if(row == 1){
				isAdd = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return isAdd;
	}

	@Override
	public boolean editCourse(Course course) {
		boolean isEdit = false;
		String sql = "updata course set classNmae=?,classState=? where classId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getClassName());
			ps.setString(2, course.getClassState());
			ps.setInt(3, course.getClassId());
			int row = ps.executeUpdate();
			if(row == 1){
				isEdit = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
				
		return isEdit;
	}

	@Override
	public boolean delCourse(int classId) {
		boolean isDel = false;
		String sql = "delete from course where classId in ("+classId+")";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			int row = ps.executeUpdate();
			if(row >= 1){
				isDel = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return isDel;
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> list = null;
		String sql = "select classId,className,classState from dept";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				list.add(creatCourse(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Course> getSubCourse(int startIndex, int endIndex) {
		List<Course> list = null;
		String sql = "select * from (select rownum as r,t.* from "+
				"(select classId,className,classState from course order by classId desc)t "+
				"where rownum<=?) where r>=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endIndex);
			ps.setInt(2, startIndex);
			rs = ps.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				list.add(creatCourse(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int getRowNum() {
		int totalNum = 0;
		String sql = "select count(*) from course";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				totalNum = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return totalNum;
	}

	@Override
	public Course getCourseByClassId(int classId) {
		Course course = null;
		String sql = "select classId,className,classState from course where classId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classId);
			rs = ps.executeQuery();
			if(rs.next()){
				course = creatCourse(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return course;
	}

}
