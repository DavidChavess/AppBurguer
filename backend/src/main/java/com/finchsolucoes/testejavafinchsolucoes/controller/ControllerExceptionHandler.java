package com.finchsolucoes.testejavafinchsolucoes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.finchsolucoes.testejavafinchsolucoes.exception.DataIntegrityException;
import com.finchsolucoes.testejavafinchsolucoes.exception.ObjectNotFoundException;
import com.finchsolucoes.testejavafinchsolucoes.exception.StandardError;
import com.finchsolucoes.testejavafinchsolucoes.exception.ValidationError;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(
				HttpStatus.NOT_FOUND.value(),
				e.getMessage(), 
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegraty(DataIntegrityException e, HttpServletRequest request){
		StandardError err = new StandardError(
				HttpStatus.BAD_REQUEST.value(),
				e.getMessage(), 
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> argumentInvalid(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(
				HttpStatus.BAD_REQUEST.value(),
				"Erro de Validação!", 
				System.currentTimeMillis()
		);
		
		for(FieldError er : e.getBindingResult().getFieldErrors()) {
			err.addError(er.getField(), er.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
	}
}
