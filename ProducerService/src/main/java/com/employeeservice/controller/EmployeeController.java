package com.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.model.Employee;
import com.employeeservice.service.KafkaEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private KafkaEmployeeService kafkaEmployeeService;

	@PostMapping("/post")
	public void employee(@RequestBody Employee employee) {
		kafkaEmployeeService.send(employee);
	}

}
