package com.jxdedu.biz.impl;

import java.util.List;

import com.jxdedu.biz.DeptBiz;
import com.jxdedu.dao.impl.DeptDaoImpl;
import com.jxdedu.entity.Dept;

public class DeptBizImpl implements DeptBiz {

	@Override
	public boolean editDept(Dept dept) {
		return new DeptDaoImpl().editDept(dept);
	}

	@Override
	public boolean addDept(Dept dept) {
		return new DeptDaoImpl().addDept(dept);
	}

	@Override
	public List<Dept> getAllDept() {
		return new DeptDaoImpl().getAllDept();
	}

	@Override
	public Dept getOneDeptById(int deptId) {
		return new DeptDaoImpl().getOneDeptById(deptId);
	}

	@Override
	public boolean delDept(String deptId) {
		return new DeptDaoImpl().delDept(deptId);
	}

	@Override
	public List<Dept> getSubDept(int startIndex, int endIndex) {
		return new DeptDaoImpl().getSubDept(startIndex, endIndex);
	}

	@Override
	public int getRowNum() {
		return new DeptDaoImpl().getRowNum();
	}

}
