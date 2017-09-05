package com.priyanka.jaxrs;

import java.util.Date;

public class MyDate {
	
	private String country;
	private String language;
	private Date plainDate;
	private String formattedDate;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getPlainDate() {
		return plainDate;
	}
	public void setPlainDate(Date plainDate) {
		this.plainDate = plainDate;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String string) {
		this.formattedDate = string;
	}
	
	
	
	public String toString(){
		if (formattedDate == null){
			return "Todays date is "+plainDate;
		}
		
		return "Todays date is "+plainDate +"\nCountry : "+country + " Language : "+language+" Date :  "+formattedDate;
	}
	

}
