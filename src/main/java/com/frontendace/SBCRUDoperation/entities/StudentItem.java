package com.frontendace.SBCRUDoperation.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class StudentItem {
	@Id
	private String id;
	private String name;
	private String gender;
	private String date_of_birth;
	private int age;

	public StudentItem() {
	} // Default constructor needed by Spring Data

	public StudentItem(String id, String name, String gender, String date_of_birth, int age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.age = age;
	}

	// Getters and setters here
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
