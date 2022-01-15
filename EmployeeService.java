package com.apis.employees.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.employees.model.Employees;
import com.apis.employees.repository.EmployeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeRepository employeeRepo;

	public List<Employees> getAllEmployees() {

		List<Employees> emp = null;
		try {
			emp = employeeRepo.getEmployees();
			System.out.println("Employeee fetch Successfully");
		} catch (Exception e) {
			System.out.println("Their was a problem while fetching EmployeeList" + e.getMessage());
		}

		return emp;

	}

	public void createEmployee(Employees employee) {
		LocalDateTime date = LocalDateTime.now();
		try {
			employeeRepo.createEmployee(employee.getEmp_name(), employee.getEmp_department(), date,
					employee.getContact_number());
			System.out.println("Employee CreatedSuccessfully");
		} catch (Exception e) {
			System.out.println("Their was an error while creating Employee" + e.getMessage());
		}
	}

	public void updateEmployee(Employees employee, Integer Id) {
		try {
			employeeRepo.updateEmployee(employee.getEmp_name(), employee.getEmp_department(),
					employee.getContact_number(), Id);
			System.out.println("Employee UpdatedSuccessfully");
		} catch (Exception e) {
			System.out.println("Their was an error while Updating Employee" + "Id" + " " + e.getMessage());
		}

	}

	public void deleteEmployee(Integer id) {
		try {
			employeeRepo.deleteEmployee(id);
			System.out.println("Employee deleted Successfully");
		} catch (Exception e) {
			System.out.println("Their was an error while deleting Employee" + " " + id + " " + e.getMessage());
		}

	}

}
