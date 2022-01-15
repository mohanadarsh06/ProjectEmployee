package com.apis.employees.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apis.employees.model.Employees;
@Repository
public interface EmployeRepository extends JpaRepository<Employees, Integer> {

	@Query(value = "select * from employees", nativeQuery = true)
	public List<Employees> getEmployees();

	@Modifying
	@Transactional
	@Query(value = "insert into employees (emp_name,emp_department,date_of_joining,contact_number)values(:empName,:empDepartment,:dateOfJoin,:contactNumber)", nativeQuery = true)
	public void createEmployee(@Param("empName") String name, @Param("empDepartment") String empDepartment,
			@Param("dateOfJoin") LocalDateTime dateOfJoin, @Param("contactNumber") String contactNumber);

	@Modifying
	@Transactional
	@Query(value = "update employees set emp_name=:Name,emp_department=:empDepartment,contact_number=:contactNumber where id=:Id", nativeQuery = true)
	public void updateEmployee(@Param("Name") String name, @Param("empDepartment") String empDepartment,
			@Param("contactNumber") String contactNumber, @Param("Id") Integer Id);

	@Modifying
	@Transactional
	@Query(value = "delete from employees where id = :Id", nativeQuery = true)
	public void deleteEmployee(@Param("Id") Integer Id);
}
