package com.challenge.bktransfer.entity;

public class Entry {
	
	private int bailorAccountNumber;
	
	private int depositaryAccountNumber;
	
	private double value;

	public int getBailorAccountNumber() {
		return bailorAccountNumber;
	}

	public void setBailorAccountNumber(int bailorAccountNumber) {
		this.bailorAccountNumber = bailorAccountNumber;
	}

	public int getDepositaryAccountNumber() {
		return depositaryAccountNumber;
	}

	public void setDepositaryAccountNumber(int depositaryAccountNumber) {
		this.depositaryAccountNumber = depositaryAccountNumber;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}