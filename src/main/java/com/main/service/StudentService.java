package com.main.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.model.Student;
import com.main.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student std) {
        std.setId(UUID.randomUUID().toString().split("-")[0]);
        return repo.save(std);
    }
    public List<Student> findAllStudents(){
    	return repo.findAll();
    }
    public Student getStudentByID(String id) {
    	return repo.findById(id).get();
    }
    public Student UpdateStudent(Student std) {
    	Student existingStd=repo.findById(std.getId()).get();
    	existingStd.setAge(std.getAge());
    	existingStd.setEmail(std.getEmail());
    	existingStd.setName(std.getName());
    	return repo.save(existingStd);
    }
    public String deleteStudent(String id) {
    	repo.deleteById(id);
    	return id+" Deleted";
    }
}
