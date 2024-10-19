package com.myproject_task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject_task1.entity.Student;

/**
 * StudentRepository interface extends JpaRepository to provide CRUD methods for Student entities.
 */

public interface StudentRepository extends JpaRepository<Student, Long> 
{
	
}
