package com.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.model.Student;

public interface StudentRepository extends MongoRepository<Student,String>{

}
