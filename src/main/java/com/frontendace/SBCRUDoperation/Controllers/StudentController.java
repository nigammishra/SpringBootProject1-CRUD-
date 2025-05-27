package com.frontendace.SBCRUDoperation.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frontendace.SBCRUDoperation.entities.StudentItem;
import com.frontendace.SBCRUDoperation.services.StudentServices;

@Controller
@RequestMapping("/studentsManagementSystem")
public class StudentController {

	private final StudentServices studentServices;

	@Autowired
	public StudentController(StudentServices studentServices) {
		this.studentServices = studentServices;
	}

	// Add new student
	@PostMapping("/students")
	@ResponseBody
	public StudentItem addStudent(@RequestBody StudentItem studentItem) {
		return studentServices.addStudent(studentItem); // FIXED: use instance, not class method
	}

	// Get all students
	@GetMapping("/students")
	@ResponseBody
	public List<StudentItem> getAllStudents() {
		return studentServices.getAllStudents();
	}

	// Get student by ID
	@GetMapping("/students/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable String id) {
		Optional<StudentItem> student = studentServices.getStudentById(id);
		if (student.isPresent()) {
			return ResponseEntity.ok(student.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}
	}

	// Show index page (for HTML view)
	@GetMapping("/index")
	public String showIndex() {
		return "index"; // Ensure you have index.html in src/main/resources/templates/ with Thymeleaf
						// configured
	}

	// Delete student by ID
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable String id) {
		if (studentServices.deleteStudent(id)) {
			return ResponseEntity.ok("Student deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
		}
	}

	// Update student by ID
	@PutMapping("/students/{id}")
	@ResponseBody
	public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody StudentItem studentItem) {
		try {
			StudentItem updatedStudent = studentServices.updateStudent(id, studentItem);
			return ResponseEntity.ok(updatedStudent);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
