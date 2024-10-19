package com.myproject_task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* This Student Management REST API allows users to perform CRUD operations on a student database with fields for ID, name, email, course, and age. */

@SpringBootApplication
public class StudentCrudOperationApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(StudentCrudOperationApplication.class, args);
	}

}
