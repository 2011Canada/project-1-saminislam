package com.revature.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reimbursements {
	
	private int reimb_id;
	@JsonProperty
	private double amount;
	@JsonProperty
	private String date_submitted;
	
	private String date_resolved = "";
	@JsonProperty
	private String reimb_description;
	@JsonProperty
	private byte[] receipt;
	@JsonProperty
	private String reimb_status;
	@JsonProperty
	private String reimb_type;
	@JsonProperty
	private int author;
	
	private int resolver;
	
	

	public Reimbursements() {
		super();
	}
	
	// no reimb_type, no status_type
	public Reimbursements(int reimb_id, double amount,String date_submitted,
							String date_resolved, String reimb_description, 
							byte[] receipt, int author,int resolver) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
	}
	
	// no reimb_type, no status_type, no date_resolved, no resolver
	public Reimbursements(int reimb_id, double amount,String date_submitted,
	String reimb_description, byte[] receipt, int author) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.date_submitted = date_submitted;
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		this.author = author;
		
	}
	
	public Reimbursements(double amount,String date_submitted,
	String reimb_description,byte[] receipt,
	int author, String reimb_status, String reimb_type) {
		super();
		
		this.amount = amount;
		
		
		Date todaysDate = new Date();
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    String DateString = df.format(todaysDate);
	    this.date_submitted = DateString;
		
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		
		this.author = author;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		
	}
	
	
	
	public int get_reimb_id() {
		return reimb_id;
	}

	public void set_reimb_Id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double get_amount() {
		return amount;
	}

	public void set_amount(double amount) {
		this.amount = amount;
	}

	public String get_date_submitted() {
		return date_submitted;
	}

	public void set_date_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}
	
	public String get_date_resolved() {
		return date_resolved;
	}

	public void set_date_resolved(String date_resolved) {
		this.date_resolved = date_resolved;
	}

	public String get_reimb_description() {
		return reimb_description;
	}

	public void set_reimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public byte[] get_receipt() {
		return receipt;
	}

	public void set_receipt(byte[] receipt) {
		this.receipt = receipt;
	}
	
	
	public int get_author() {
		return author;
	}

	public void set_author(int author) {
		this.author = author;
	}
	
	public int get_resolver() {
		return resolver;
	}

	public void set_resolver(int resolver) {
		this.resolver = resolver;
	}
	
	public String get_reimb_status() {
		return reimb_status;
	}

	public void set_reimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	
	public String get_reimb_type() {
		return reimb_type;
	}

	public void set_reimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	
	

}
