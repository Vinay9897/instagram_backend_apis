package com.social.model;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	
	private String caption;
	
	private String image;
	
	private String video;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	 
	private LocalDateTime  createdAt;
	
	@ManyToOne(targetEntity = User.class)
	private Set<User> liked = new HashSet<>();
	
	@OneToMany
	private List<Comment> comment = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<User> getLiked() {
		return liked;
	}

	public void setLiked(Set<User> liked) {
		this.liked = liked;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Post(Integer id, String caption, String image, String video, User user, LocalDateTime createdAt,
			Set<User> liked, List<Comment> comment) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createdAt = createdAt;
		this.liked = liked;
		this.comment = comment;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
