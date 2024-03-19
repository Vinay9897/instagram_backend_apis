package com.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
