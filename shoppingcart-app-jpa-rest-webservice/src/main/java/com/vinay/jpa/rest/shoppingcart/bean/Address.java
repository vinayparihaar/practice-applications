package com.vinay.jpa.rest.shoppingcart.bean;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

public class Address {

	private int addressid;
	private String lineOne;
	private String lineTwo;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	public Address() {

	}

	public Address(int addressid, String lineOne, String lineTwo, String city, String state, String zipcode,
			String country) {
		super();
		this.addressid = addressid;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
