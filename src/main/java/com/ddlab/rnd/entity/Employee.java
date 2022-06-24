package com.ddlab.rnd.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("employee")
public class Employee {

	@Id
    private String id;
	
	private String firstName;
	private String lastName;
	private String desgn;
	private long salary;
	private String city;
}
