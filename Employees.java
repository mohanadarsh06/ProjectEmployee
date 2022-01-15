package com.apis.employees.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="emp_name")
	private String emp_name;

	@Column(name="emp_department")
	private String emp_department;

	@Column(name="date_of_joining")
	@CreatedDate
	private Date date_of_joining;

	@Column(name="contact_number")
	private String contact_number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_department() {
		return emp_department;
	}

	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", emp_name=" + emp_name + ", emp_department=" + emp_department
				+ ", date_of_joining=" + date_of_joining + ", contact_number=" + contact_number + "]";
	}

	public Employees(Integer id, String emp_name, String emp_department, Date date_of_joining, String contact_number) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.emp_department = emp_department;
		this.date_of_joining = date_of_joining;
		this.contact_number = contact_number;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
