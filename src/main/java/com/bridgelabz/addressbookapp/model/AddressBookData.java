package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;
/**
 *@Data : Auto-Generate Setters, getters and ToString   
 */
@Data
public class AddressBookData {

	private int contactId;
	private String firstName;
	private String lastName;
	private long phoneNum;

	public AddressBookData() {
	}

	public AddressBookData(int id, AddressBookDTO addressBookDTO) {
		super();
		this.contactId = id;
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
		this.phoneNum = addressBookDTO.phoneNum;
	}

	@Override
	public String toString() {
		return "AddressBookData [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNum=" + phoneNum + "]";
	}
}
