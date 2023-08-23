package com.example.day4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="_Employer data")
public class UserModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String studentName;
	private String departmentName;
	private String mailid;
	
	
	public UserModel() {
		super();
	}


	public UserModel(Long id, String studentName, String departmentName, String mailid) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.departmentName = departmentName;
		this.mailid = mailid;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	
	
}
