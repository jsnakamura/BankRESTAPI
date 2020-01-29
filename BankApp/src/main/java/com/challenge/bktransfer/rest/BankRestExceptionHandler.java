package com.challenge.bktransfer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException(AccountNotFoundException exc) {

		AccountErrorResponse error = new AccountErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException(Exception exc) {

		AccountErrorResponse error = new AccountErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException(ValueOutOfBoundsException exc) {

		AccountErrorResponse error = new AccountErrorResponse();

		error.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}
}