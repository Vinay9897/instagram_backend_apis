package com.social.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	
	private List<Integer> follewers = new ArrayList<>();
	
	private List<Integer> follwings = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Integer id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<Integer> getFollewers() {
		return follewers;
	}


	public void setFollewers(List<Integer> follewers) {
		this.follewers = follewers;
	}


	public List<Integer> getFollwings() {
		return follwings;
	}


	public void setFollwings(List<Integer> follwings) {
		this.follwings = follwings;
	}


	public User(Integer id, String firstName, String lastName, String email, String password, String gender,
			List<Integer> follewers, List<Integer> follwings) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.follewers = follewers;
		this.follwings = follwings;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", follewers=" + follewers + ", follwings="
				+ follwings + "]";
	}
	
}
