package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.entity.Employee;

public interface SampleService {
	
	void storeData(Employee emp);
	
	Employee getEmployeeById(String id);
	
	void storeAllEmployees(List<Employee> emps);
	
	List<Employee> getDataByPage(Integer pageNo, Integer pageSize);
}
