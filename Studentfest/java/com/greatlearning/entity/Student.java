package com.greatlearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCourse() {
		return course;
	}

	public String getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "course")
	private String course;
	@Column(name = "country")
	private String country;

	public Student() {

	}

	public Student(String firstName, String lastName, String course, String country) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;

	}

}
