package com.frontendace.SBCRUDoperation.services;

import java.util.List;
import java.util.Optional;

import com.frontendace.SBCRUDoperation.entities.StudentItem;

public interface StudentServices {
	List<StudentItem> getAllStudents();

	Optional<StudentItem> getStudentById(String id);

	StudentItem addStudent(StudentItem student);

	boolean deleteStudent(String id);

	StudentItem updateStudent(String id, StudentItem studentItem);
}
