package com.myproject_task1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject_task1.entity.Student;
import com.myproject_task1.service.StudentService;

import jakarta.validation.Valid;

/**
 * REST controller to handle HTTP requests for student operations.
 * The controller exposes endpoints for CRUD operations like creating, fetching, updating, and deleting students.
 */

@RestController
@RequestMapping("/api/students") // Base URL for all student-related operations
public class StudentController
{
	// Injecting the StudentService to handle business logic
	
    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) 
    {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) 
    {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) 
    {
        Student updatedStudent = studentService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}