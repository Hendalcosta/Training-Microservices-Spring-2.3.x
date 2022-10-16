package com.phantom.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String Name;
	private Double dailyIncome;
	private Integer days;
	
	public Payment () {		
	}

	public Payment(String name, Double dailyIncome, Integer days) {
		super();
		Name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	
	public double getTotal() {
		return days * dailyIncome;
	}
	
}
