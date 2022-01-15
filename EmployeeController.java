package com.apis.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.employees.model.Employees;
import com.apis.employees.response.JsonResponse;
import com.apis.employees.service.EmployeeService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path = { "/apis/v1" })
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Employees>> getEmployees() {
		JsonResponse response;
		List<Employees> emp = new ArrayList<>();
		try {
			emp = empservice.getAllEmployees();
			response = new JsonResponse("Succssfully fetched", HttpStatus.OK);
		} catch (Exception e) {
			response = new JsonResponse("Error while fetching Employee", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Employees>>(emp, HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity createmployee(@RequestBody Employees emp) {
		JsonResponse response;
		try {
			empservice.createEmployee(emp);
			response = new JsonResponse("Succssfully created", HttpStatus.CREATED);
		} catch (Exception e) {
			response = new JsonResponse("Error while creating employee", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(response, HttpStatus.CREATED);

	}

	@PutMapping("/employee/{empid}")
	public ResponseEntity updateEmployee(@RequestBody Employees emp, @PathVariable("empid") Integer id) {
		JsonResponse response;
		try {
			empservice.updateEmployee(emp, id);
			response = new JsonResponse("Succssfully updated", HttpStatus.OK);

		} catch (Exception e) {
			response = new JsonResponse("Error while updating employee", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);

	}

	@DeleteMapping("/employee/{empid}")
	public ResponseEntity deleteEmployee(@PathVariable("empid") Integer id) {
		JsonResponse response;
		try {
			empservice.deleteEmployee(id);
			response = new JsonResponse("Succssfully Deleted", HttpStatus.OK);
		} catch (Exception e) {
			response = new JsonResponse("Error while deleting employee", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
}
