package com.frontendace.SBCRUDoperation.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frontendace.SBCRUDoperation.entities.StudentItem;
import com.frontendace.SBCRUDoperation.repo.StudentRepo;
import com.frontendace.SBCRUDoperation.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {

	private final StudentRepo repository;

	public StudentServicesImpl(StudentRepo repository) {
		this.repository = repository;
	}

	@Override
	public List<StudentItem> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public Optional<StudentItem> getStudentById(String id) {
		return repository.findById(id);
	}

	@Override
	public StudentItem addStudent(StudentItem student) {
		return repository.save(student);
	}

	@Override
	public boolean deleteStudent(String id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public StudentItem updateStudent(String id, StudentItem studentItem) {
		Optional<StudentItem> existingStudentOpt = repository.findById(id);

		if (existingStudentOpt.isPresent()) {
			StudentItem existingStudent = existingStudentOpt.get();
			existingStudent.setName(studentItem.getName());
			existingStudent.setGender(studentItem.getGender());
			existingStudent.setDate_of_birth(studentItem.getDate_of_birth());
			existingStudent.setAge(studentItem.getAge());
			return repository.save(existingStudent);
		} else {
			throw new RuntimeException("Student not found with ID: " + id);
		}
	}
}
