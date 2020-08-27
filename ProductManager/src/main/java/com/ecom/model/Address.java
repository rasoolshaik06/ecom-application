package com.ecom.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String contactNo;
	private String address;
	private String landmark;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private String pincode;
	
	private int userId;
	/*@ManyToOne
	@JoinColumn(name = "Customer_ID")
	private Customer customer;
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
	public Address() {
		super();
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", contactNo=" + contactNo + ", address=" + address + ", landmark="
				+ landmark + ", countryId=" + countryId + ", stateId=" + stateId + ", cityId=" + cityId + ", pincode="
				+ pincode + ", userId=" + userId + "]";
	}

	public Address(Integer addressId, String contactNo, String address, String landmark, Integer countryId,
			Integer stateId, Integer cityId, String pincode, int userId) {
		super();
		this.addressId = addressId;
		this.contactNo = contactNo;
		this.address = address;
		this.landmark = landmark;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.pincode = pincode;
		this.userId = userId;
	}
	
	
	
	

	
}