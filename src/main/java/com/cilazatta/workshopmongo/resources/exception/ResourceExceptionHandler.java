package com.cilazatta.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cilazatta.workshopmongo.services.exception.ObjectDateTimeParseException;
import com.cilazatta.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Não Encontrado",
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ObjectDateTimeParseException.class)
	public ResponseEntity<StandardError> dateIncompatible(ObjectDateTimeParseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Data (String) Incompativel",
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
