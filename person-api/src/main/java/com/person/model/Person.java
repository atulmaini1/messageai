package com.person.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Person {
	@Id
	private String id;
	private String name;
	private String remarks;
	
	public Person() {
	
	}
	
	public Person(String id, String name, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.remarks = remarks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
