package com.cdac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_id")
	private int AddId;
	
	@JsonBackReference
	@OneToOne(mappedBy = "address")
	private User user;
	
	@Column(name = "apartment_no")
	private String apartment_no;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private int pincode;
	
	public Address() {
		
	}

	public Address(int id, String aptNo, String street, String city, int pincode) {
		super();
		this.AddId = id;
		this.apartment_no = aptNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	
	public int getAddId() {
		return AddId;
	}

	public void setAddId(int addId) {
		AddId = addId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getApartment_no() {
		return apartment_no;
	}

	public void setApartment_no(String apartment_no) {
		this.apartment_no = apartment_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [AddId=" + AddId + ", user=" + user + ", apartment_no=" + apartment_no + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
