package com.ddlab.rnd.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Employee;

@Repository
public interface SampleDataPagingViewRepository extends PagingAndSortingRepository<Employee, Long> {

}
