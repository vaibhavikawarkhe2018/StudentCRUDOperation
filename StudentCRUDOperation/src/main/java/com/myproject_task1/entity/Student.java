package com.myproject_task1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The Student entity class representing the 'Student' table in the database.
 * This class will map the student fields (id, name, email, course, and age) to corresponding database columns.
 */

@Entity  // Marks this class as a JPA entity
public class Student 
{
	
	// Primary key with auto-increment for the 'id' field
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// Other fields in the Student table
    
	@NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
	
	@NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
	
	@NotBlank(message = "Course is mandatory")
    private String course;
	
	
    @Max(value = 60, message = "Age should not be more than 60")
    private int age;
    
    // Default constructor (required by JPA)
	public Student() 
	{
		
	}

	// Getters and setters for all fields
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCourse() 
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

}
