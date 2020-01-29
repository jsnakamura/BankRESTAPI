package com.challenge.bktransfer.rest;

public class AccountErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;

	public AccountErrorResponse() {
	}

	public AccountErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timeStamp;
	}

	public void setTimestamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}