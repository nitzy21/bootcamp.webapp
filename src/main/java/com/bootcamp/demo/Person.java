package com.bootcamp.demo;

public class Person {

	private String firstName;
	private String email;

	public Person(String firstName, String email) {
		super();
		this.firstName = firstName;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName() {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail() {
		this.email = email;
	}
	
}
