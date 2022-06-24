package com.ddlab.rnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.repository.SampleDataPagingViewRepository;
import com.ddlab.rnd.repository.SampleDataRepository;
import com.ddlab.rnd.service.SampleService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Service Implementation class.
 * 
 * @author Debadatta Mishra
 */
@Slf4j
@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleDataRepository dataRepo;

	@Autowired
	private SampleDataPagingViewRepository viewPagingRepo;

	@Override
	public void storeData(Employee emp) {
		dataRepo.save(emp);
	}

	@Override
	public void storeAllEmployees(List<Employee> emps) {
		dataRepo.saveAll(emps);
	}

	@Override
	public Employee getEmployeeById(String id) {
		Optional<Employee> optEmp = dataRepo.findById(id);
		if (optEmp.isPresent())
			return optEmp.get();
		return null;
	}

	@Override
	public List<Employee> getDataByPage(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Employee> pagedResult = viewPagingRepo.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}

}
