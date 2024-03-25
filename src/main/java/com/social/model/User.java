package com.social.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	
	
	private Set<Integer> followers = new HashSet<>();
	
	
	private Set<Integer> followings = new HashSet<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Post> savedPost = new ArrayList<>();
	
	@ManyToMany()
	private List<Comment> savedComment = new ArrayList<>();

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

	public Set<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<Integer> followers) {
		this.followers = followers;
	}

	public Set<Integer> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<Integer> followings) {
		this.followings = followings;
	}

	public List<Post> getSavedPost() {
		return savedPost;
	}

	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}

	public List<Comment> getSavedComment() {
		return savedComment;
	}

	public void setSavedComment(List<Comment> savedComment) {
		this.savedComment = savedComment;
	}

	public User(Integer id, String firstName, String lastName, String email, String password, String gender,
			Set<Integer> followers, Set<Integer> followings, List<Post> savedPost, List<Comment> savedComment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.followers = followers;
		this.followings = followings;
		this.savedPost = savedPost;
		this.savedComment = savedComment;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
