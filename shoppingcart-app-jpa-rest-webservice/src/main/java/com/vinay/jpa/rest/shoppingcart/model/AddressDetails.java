package com.vinay.jpa.rest.shoppingcart.model;

/**
 * @author VinayParihar
 * @date May 1, 2020 @time 12:22:12 AM 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS_DETAILS")
public class AddressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private int addressId;
	@Column(name = "ADD_LINE_ONE")
	private String addressLineOne;
	@Column(name = "ADD_LINE_TWO")
	private String addressLineTwo;
	@Column(name = "ADD_CITY")
	private String addressCity;
	@Column(name = "ADD_STATE")
	private String addressState;
	@Column(name = "ADD_ZIPCODE")
	private String addressZipcode;
	@Column(name = "ADD_COUNTRY")
	private String addressCountry;
	

	public AddressDetails() {

	}

	public AddressDetails(int addressId, String addressLineOne, String addressLineTwo, String addressCity,
			String addressState, String addressZipcode, String addressCountry) {
		super();
		this.addressId = addressId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZipcode = addressZipcode;
		this.addressCountry = addressCountry;
		
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZipcode() {
		return addressZipcode;
	}

	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	/*
	 * public UserDetails getUserDetails() { return userDetails; }
	 * 
	 * public void setUserDetails(UserDetails userDetails) { this.userDetails =
	 * userDetails; }
	 */


}
