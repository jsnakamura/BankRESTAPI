package com.challenge.bktransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Juliano Nakamura
 *
 */
@ControllerAdvice
public class BankRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleException(AccountNotFoundException exc) {

		BankErrorResponse error = new BankErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleException(Exception exc) {

		BankErrorResponse error = new BankErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleException(ValueOutOfBoundsException exc) {

		BankErrorResponse error = new BankErrorResponse();

		error.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}
}