package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	/**
	 * Call Get method
	 * @return : Http Status & Contact details of the employee
	 */
	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList = new ArrayList<>();
		addressBookList.add(new AddressBookData(1, new AddressBookDTO("Dhanashree", "Hakke", "Kavalapur", "Sangli", 8421731310l)));
		return addressBookList;
	}

	/**
	 * Call Get method
	 * @param id : contact Id
	 * @return : Contact details of the employee
	 */
	@Override
	public AddressBookData getAddressBookDataById(int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Dhanashree", "Hakke", "Kavalapur", "Sangli", 8421731310l));
		return contactData;
	}

	/**
	 * Call post method to add details
	 * @param addressBookDTO : details id, First name, Last name, Address, City & phoneNum
	 * @return : details
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	/**
	 * Call put method to update details
	 * @param addressBookDTO : details id, First name, Last name, Address, City & phoneNum
	 * @return : details
	 */
	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	/**
	 * Call delete method to remove address book details
	 * @param empId : Address book id
	 * @return : contact id which is deleted
	 */
	@Override
	public void deleteAddressBookData(int id) {
		
	}
}
