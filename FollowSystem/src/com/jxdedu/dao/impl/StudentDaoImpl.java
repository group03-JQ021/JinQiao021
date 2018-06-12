package com.jxdedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jxdedu.dao.StudentDao;
import com.jxdedu.entity.Student;
import com.jxdedu.util.C3P0DBUtil;

public class StudentDaoImpl implements StudentDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Student creatStudent(ResultSet rs){
		Student stu = new Student();
		try{
			stu.setStuId(rs.getInt("stuId"));
			stu.setStuName(rs.getString("stuName"));
			String sex = rs.getString("sex").trim();
			stu.setSex(sex);
			stu.setNation(rs.getString("nation"));
			stu.setBirthday(rs.getDate("birthday"));
			stu.setBirthPlace(rs.getString("birthPlace"));
			stu.setMarry(rs.getString("marry"));
			stu.setTelephone(rs.getString("telephone"));
			stu.setIdCard(rs.getString("idCard"));
			stu.setUniversity(rs.getString("university"));
			stu.setMajor(rs.getString("major"));
			stu.setPhoto(rs.getString("photo"));
			stu.setNote(rs.getString("note"));
			stu.setState(rs.getString("state"));
			stu.setClassId(rs.getInt("classId"));
			stu.setDeptId(rs.getInt("deptId"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stu;
	}
	@Override
	public boolean addStudent(Student stu) {
		boolean isAdd = false;
		String sql = "insert into student(stuId,stuName,sex,nation,birthday,birthPlace,marry,"+
		"telephone,idCard,university,major,photo,note,state,classId,deptId) values(seq_student.nextval,"+
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getStuName());
			ps.setString(2, stu.getSex());
			ps.setString(3, stu.getNation());
			ps.setDate(4, stu.getBirthday());
			ps.setString(5, stu.getBirthPlace());
			ps.setString(6, stu.getMarry());
			ps.setString(7,stu.getTelephone());
			ps.setString(8, stu.getIdCard());
			ps.setString(9, stu.getUniversity());
			ps.setString(10, stu.getMajor());
			ps.setString(11, stu.getPhoto());
			ps.setString(12, stu.getNote());
			ps.setString(13, stu.getState());
			ps.setInt(14, stu.getClassId());
			ps.setInt(15, stu.getDeptId());
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
	public boolean delStudent(String stuId) {
		boolean isDel = false;
		String sql = "delete from student where stuId in ("+stuId+")";
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
	public boolean editStudent(Student stu) {
		boolean isEdit = false;
		String sql = "updata student set stuName=?,sex=?,nation=?,birthday=?,birthPlace=?,marry=?,telePhone=?,"+
					"idCard=?,university=?,major=?,photo=?,note=?,state=?,classId=?,deptId=? where stuId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getStuName());
			ps.setString(2, stu.getSex());
			ps.setString(3, stu.getNation());
			ps.setDate(4, stu.getBirthday());
			ps.setString(5, stu.getBirthPlace());
			ps.setString(6, stu.getMarry());
			ps.setString(7,stu.getTelephone());
			ps.setString(8, stu.getIdCard());
			ps.setString(9, stu.getUniversity());
			ps.setString(10, stu.getMajor());
			ps.setString(11, stu.getPhoto());
			ps.setString(12, stu.getNote());
			ps.setString(13, stu.getState());
			ps.setInt(14, stu.getClassId());
			ps.setInt(15, stu.getDeptId());
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
	public List<Student> getAllStudent() {
		List<Student> list = null;
		String sql = "select stuId,stuName,sex,nation,birthday,birthPlace,marry,"+
		"telephone,idCard,university,major,photo,note,state,classId,deptId from student order by stuId desc";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				list.add(creatStudent(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Student> getOneStudentByName(String name) {
		List<Student> list = null;
		String sql = "select stuId,stuName,sex,nation,birthday,birthPlace,marry,"+
				"telephone,idCard,university,major,photo,note,state,classId,deptId "+
				"from student where stuName like '%"+name+"%' order by stuId desc";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				list.add(creatStudent(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Student> getSubStudent(int startIndex, int endIndex) {
		List<Student> list = null;
		String sql = "select * from (select rownum as r,t.* from(select stuId,stuName,sex,nation,birthday,birthPlace,"+
				"marry,telephone,idCard,university,major,photo,note,state,classId,deptId from student order by stuId desc)t where "+
				"rownum <=?) where r >=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endIndex);
			ps.setInt(2, startIndex);
			rs = ps.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				list.add(creatStudent(rs));
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
		String sql = "select count(*) from student";
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
	public Student getStudentById(int stuId) {
		Student stu = null;
		String sql = "select * from student where stuId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			rs = ps.executeQuery();
			if(rs.next()){
				stu = creatStudent(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return stu;
	}

}
