package com.security.oauth.app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.oauth.app.entity.Employee;
import com.security.oauth.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void intializeEmployeeTable() {
		employeeRepository.saveAll(
				Stream.of(
						new Employee("jeff", 40000),
						new Employee("elon", 50000),
						new Employee("zack", 30000)
				).collect(Collectors.toList()));
	}

	public Employee getEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
