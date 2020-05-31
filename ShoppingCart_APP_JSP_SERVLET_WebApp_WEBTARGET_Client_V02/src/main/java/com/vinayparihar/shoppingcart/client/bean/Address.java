package com.vinayparihar.shoppingcart.client.bean;

/**
 * @author VinayParihar
 * @date May 31, 2020 @time 5:40:39 PM
 */

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"lineOne",
"lineTwo",
"city",
"state",
"zipcode",
"country"
})
public class Address {

@JsonProperty("lineOne")
private String lineOne;
@JsonProperty("lineTwo")
private String lineTwo;
@JsonProperty("city")
private String city;
@JsonProperty("state")
private String state;
@JsonProperty("zipcode")
private String zipcode;
@JsonProperty("country")
private String country;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Address() {
}

/**
*
* @param zipcode
* @param country
* @param lineTwo
* @param city
* @param lineOne
* @param state
*/
public Address(String lineOne, String lineTwo, String city, String state, String zipcode, String country) {
super();
this.lineOne = lineOne;
this.lineTwo = lineTwo;
this.city = city;
this.state = state;
this.zipcode = zipcode;
this.country = country;
}

@JsonProperty("lineOne")
public String getLineOne() {
return lineOne;
}

@JsonProperty("lineOne")
public void setLineOne(String lineOne) {
this.lineOne = lineOne;
}

@JsonProperty("lineTwo")
public String getLineTwo() {
return lineTwo;
}

@JsonProperty("lineTwo")
public void setLineTwo(String lineTwo) {
this.lineTwo = lineTwo;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("zipcode")
public String getZipcode() {
return zipcode;
}

@JsonProperty("zipcode")
public void setZipcode(String zipcode) {
this.zipcode = zipcode;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}