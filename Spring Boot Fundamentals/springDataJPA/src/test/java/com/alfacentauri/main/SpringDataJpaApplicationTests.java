package com.alfacentauri.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alfacentauri.main.entities.Student;
import com.alfacentauri.main.repositories.StudentRepository;

@SpringBootTest
class SpringDataJpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;
	
	@Test
	void contextLoads() {
		Student student = new Student();
		student.setId(1);
		student.setName("Carlos");
		student.setTestScore(100);
		repository.save(student);
		
		Student saveStudent = repository.findById(1l).get();
		
		assertNotNull(saveStudent);
	}

}
