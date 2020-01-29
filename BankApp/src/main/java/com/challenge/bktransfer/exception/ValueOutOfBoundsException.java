package com.challenge.bktransfer.exception;

public class ValueOutOfBoundsException extends RuntimeException{

	private static final long serialVersionUID = 3839716185136019660L;

	public ValueOutOfBoundsException() {
	}

	public ValueOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValueOutOfBoundsException(String message) {
		super(message);
	}

	public ValueOutOfBoundsException(Throwable cause) {
		super(cause);
	}
}
