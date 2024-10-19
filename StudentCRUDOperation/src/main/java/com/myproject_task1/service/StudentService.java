package com.myproject_task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject_task1.entity.Student;
import com.myproject_task1.repository.StudentRepository;

/**
 * Service class to handle the business logic for student operations.
 * This class communicates with the StudentRepository to perform CRUD operations on Student entities.
 */

@Service
public class StudentService 
{
	// Injecting the StudentRepository to access database methods
    @Autowired
    private StudentRepository studentRepository;

    // Create student
    public Student saveStudent(Student student) 
    {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() 
    {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    // Update student
    public Student updateStudent(Long id, Student student) 
    {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        
        if (existingStudent != null)
        {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setAge(student.getAge());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    // Delete student
    public void deleteStudent(Long id)
    {
        studentRepository.deleteById(id);
    }
}
