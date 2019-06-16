package com.bank.bankapp.model;

public class Transfer {
	
	private String to;
	private String from;
	
	public Transfer()
	{
		
	}
	
	public Transfer(String to, String from) {
		super();
		this.to = to;
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
