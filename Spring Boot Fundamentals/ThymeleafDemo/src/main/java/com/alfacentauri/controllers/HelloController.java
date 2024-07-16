package com.alfacentauri.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alfacentauri.model.Student;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; // El nombre del archivo html
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mv = new ModelAndView("data");
		mv.addObject("message", "Take good day");
		return mv;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("Carlos");
		student.setScore(100);
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		
		Student student = new Student();
		student.setName("Carlos");
		student.setScore(100);
		
		Student student1 = new Student();
		student1.setName("John");
		student1.setScore(127);
		
		Student student2 = new Student();
		student2.setName("Bob");
		student2.setScore(10);
		
		List<Student> students = Arrays.asList(student, student1, student2);
		mav.addObject("students", students);
		
		return mav;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName() + " : saved");
		mav.addObject("student", student);
		return mav;
	}
}
