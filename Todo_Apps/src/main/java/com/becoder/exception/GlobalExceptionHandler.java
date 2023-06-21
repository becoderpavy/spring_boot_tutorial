package com.becoder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resoureNotFoundExceptionHandler(Exception ex) {

		ResponseMsg msg = ResponseMsg.builder().msg(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(false)
				.build();

		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);

	}

}
