package com.bank.bankapp.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accno;
	
	@Column(columnDefinition = "varchar(255) default 'checking'",nullable=false)
	private String acctype="checking";
	
	@Column(columnDefinition = "double default 0.0",nullable=false)
	private double balance=0.0;
	
	@OneToOne(mappedBy="account")
	private Customer customer;
	
	  public Account() {
	  
	  }
	  
	  public Account(double balance,int accno,String acctype) 
	  { 
		  super(); 
		  //this.id=id; 
		  this.balance=balance;
		  this.accno=accno;
		  this.acctype=acctype;
		  //this.customer=customer;
	  }
	/*
	 * public Account(double balance,String acctype) { this.balance=balance;
	 * this.acctype=acctype; }
	 */

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */
	
}
