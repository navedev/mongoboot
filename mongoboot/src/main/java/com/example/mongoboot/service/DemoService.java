package com.example.mongoboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoboot.domain.Details;
import com.example.mongoboot.model.Student;
import com.example.mongoboot.repository.DemoRepository;

@Service
public class DemoService {

	@Autowired
	private DemoRepository demoRepository;

	public List<Details> retrieveDetails(String name) {
		return demoRepository.findByName(name);
	}

	public void createStudent(Student student) {
		Details details = new Details(null, student.getName(), student.getEducation());
		demoRepository.insert(details);
	}
}
