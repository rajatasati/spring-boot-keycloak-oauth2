package com.security.oauth.app.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.oauth.app.entity.Employee;
import com.security.oauth.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// this method can be access by user whose role is user
	@GetMapping("/{employeeId}")
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		return ResponseEntity.ok(employeeService.getEmployee(employeeId));
	}

	// this method can be access by user whose role is admin
	@GetMapping
	@RolesAllowed("admin")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		List<Employee> allEmps = employeeService.getAllEmployees();
		return ResponseEntity.ok(allEmps);
	}

}
