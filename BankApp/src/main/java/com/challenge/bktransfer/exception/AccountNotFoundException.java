package com.challenge.bktransfer.exception;

/**
 * @author Juliano Nakamura
 *
 */
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6058268581292796874L;

	public AccountNotFoundException() {
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountNotFoundException(String message) {
		super(message);
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
	}
}