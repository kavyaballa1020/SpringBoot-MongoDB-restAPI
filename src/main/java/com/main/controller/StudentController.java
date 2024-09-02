package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Student;
import com.main.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student create(@RequestBody Student std) {
		return service.addStudent(std);
	}
	@GetMapping
	public List<Student> getAllStudents(){
    	return service.findAllStudents();
    }
	@GetMapping("/{id}")
	public Student getStudentByID(@PathVariable String id) {
    	return service.getStudentByID(id);
    }
	@PutMapping
	 public Student UpdateStudent(@RequestBody Student std) {
	    	
	    	return service.UpdateStudent(std);
	  }
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable String id) {
    	return service.deleteStudent(id);
    }
}
