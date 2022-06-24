package com.ddlab.rnd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.service.SampleService;


/**
 * The Class SampleDataController.
 * 
 * @author Debadatta Mishra
 */
@RestController
@RequestMapping(value = "/admin")
public class SampleDataController {

	@Autowired
	private SampleService sampleService;

	@PostMapping(path = "/store/emp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmpInfo(@RequestBody Employee emp) {
		System.out.println(emp);
		sampleService.storeData(emp);
		return new ResponseEntity<>("Employee Information Saved successfully", HttpStatus.OK);
	}

	@PostMapping(path = "/store/emps")
	public ResponseEntity<String> saveEmpInfo() {
		List<Employee> emps = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee();
			emp.setFirstName("FirstName-" + i);
			emp.setLastName("LastName->" + i);
			emp.setCity("City-" + i);
			emp.setDesgn("Desgn-" + i);
			emp.setSalary(10000 + i);
			emps.add(emp);
		}
		sampleService.storeAllEmployees(emps);
		return new ResponseEntity<>("All Employee Information Saved successfully", HttpStatus.OK);
	}

	@GetMapping(path = "/view/emp/{id}")
	public ResponseEntity<Employee> getEmpInfo(@PathVariable String id) {
		Employee emp = sampleService.getEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping(path = "/view/emps/page")
	public ResponseEntity<List<Employee>> getAllEmployeesByPage(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		List<Employee> list = sampleService.getDataByPage(pageNo, pageSize);

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

}
