package com.application.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {
	
	@Id
	private String id;
	private String name;
	private String type;
	private String country;
	private String city;
	private String phone;
	
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", type=" + type + ", country=" + country + ", City=" + city
				+ ", phone=" + phone + "]";
	}
	
	
	
	
	

}
