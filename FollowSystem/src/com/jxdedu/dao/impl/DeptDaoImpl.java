package com.jxdedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jxdedu.dao.DeptDao;
import com.jxdedu.entity.Dept;
import com.jxdedu.util.C3P0DBUtil;

public class DeptDaoImpl implements DeptDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public Dept creatDept(ResultSet rs){
		Dept dept = new Dept();
		try{
			dept.setDeptId(rs.getInt("deptId"));
			dept.setDeptName(rs.getString("deptName"));
			dept.setDeptAddress(rs.getString("deptAddress"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dept;
	}
	@Override
	public boolean editDept(Dept dept) {
		boolean isEdit = false;
		String sql = "updata dept set deptNmae=?,deptAddress=? where deptId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptName());
			ps.setString(2, dept.getDeptAddress());
			ps.setInt(3, dept.getDeptId());
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
	public boolean addDept(Dept dept) {
		boolean isAdd = false;
		String sql = "insert into dept(deptId,deptName,deptAddress) values(seq_dept.nextval,?,?)";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptName());
			ps.setString(2, dept.getDeptAddress());
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
	public List<Dept> getAllDept() {
		List<Dept> list = null;
		String sql = "select deptId,deptName,deptAddress from dept";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<Dept>();
			while(rs.next()){
				list.add(creatDept(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Dept getOneDeptById(int deptId) {
		Dept dept = null;
		String sql = "select deptId,deptName,deptAddress from dept where deptId=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptId);
			rs = ps.executeQuery();
			if(rs.next()){
				dept = creatDept(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeAll(conn, ps, rs);
		}
		return dept;
	}

	@Override
	public boolean delDept(String deptId) {
		boolean isDel = false;
		String sql = "delete from dept where deptId in ("+deptId+")";
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
	public List<Dept> getSubDept(int startIndex, int endIndex) {
		List<Dept> list = null;
		String sql = "select * from (select rownum as r,t.* from "+
				"(select deptId,deptName,deptAddress from dept order by deptId desc)t "+
				"where rownum<=?) where r>=?";
		try{
			conn = C3P0DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endIndex);
			ps.setInt(2, startIndex);
			rs = ps.executeQuery();
			list = new ArrayList<Dept>();
			while(rs.next()){
				list.add(creatDept(rs));
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
		String sql = "select count(*) from dept";
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

}
