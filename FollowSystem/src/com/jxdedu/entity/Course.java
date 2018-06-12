package com.jxdedu.entity;

public class Course {
	private int classId;//课程ID
	private String className;//课程名称
	private String classState;//课程状态
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassState() {
		return classState;
	}
	public void setClassState(String classState) {
		this.classState = classState;
	}
	
	public Course(){
		
	}
	
	public Course(int classId, String className, String classState) {
		super();
		this.classId = classId;
		this.className = className;
		this.classState = classState;
	}
	
}
