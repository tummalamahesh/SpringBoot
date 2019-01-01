package com.sabre.interest.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

@Entity
public class InterestBean {

	@Id
	Integer id;
	String name;
	String address;
	Double amount;
	String datetime;
	boolean status;
	Double rate;
	
	public InterestBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterestBean(Integer id, String name, String address, Double amount, String datetime, boolean status, Double rate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.amount = amount;
		this.datetime = datetime;
		this.status = status;
		this.rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
	
	
}
