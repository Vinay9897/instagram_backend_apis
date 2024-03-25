package com.social.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Message {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private String content;
	
	private String image;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JsonBackReference
	private Chat chat;

	private LocalDateTime timestamp;
}
