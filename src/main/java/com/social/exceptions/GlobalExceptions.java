package com.social.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> errorHandler(Exception ex , WebRequest req)
	{
		ErrorDetails error = new ErrorDetails(ex.getMessage(),req.getDescription(false) ,LocalDateTime.now());
	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> errorHandler(UserException ex , WebRequest req)
	{
		ErrorDetails error = new ErrorDetails(ex.getMessage(),req.getDescription(false) ,LocalDateTime.now());
	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
