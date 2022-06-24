package com.ddlab.rnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Employee;

@Repository
public interface SampleDataRepository extends MongoRepository<Employee, String> {
	

}
