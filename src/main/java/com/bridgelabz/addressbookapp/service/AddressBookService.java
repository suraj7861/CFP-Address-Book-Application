package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	private List<AddressBookData> addressBookList = new ArrayList<>();

	/**
	 * Call Get method
	 * 
	 * @return : Http Status & Contact details of the employee
	 */
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	/**
	 * Call Get method
	 * 
	 * @param id : contact Id
	 * @return : Contact details of the employee
	 */
	@Override
	public AddressBookData getAddressBookDataById(int contactId) {

		return addressBookList.get(contactId - 1);
	}

	/**
	 * Call post method to add details
	 * 
	 * @param addressBookDTO : details id, Firstname, Lastname, Address, City &
	 *                       phoneNum
	 * @return : details
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookList.size() + 1, addressBookDTO);
		addressBookList.add(contactData);
		return contactData;
	}

	/**
	 * Call put method to update details
	 * 
	 * @param addressBookDTO : details id, First name, Last name, Address, City &
	 *                       phoneNum
	 * @return : details
	 */
	@Override
	public AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookDataById(contactId);
		contactData.setFirstName(addressBookDTO.firstName);
		contactData.setLastName(addressBookDTO.lastName);
		addressBookList.set(contactId - 1, contactData);
		return contactData;
	}

	/**
	 * Call delete method to remove address book details
	 * 
	 * @param empId : Address book id
	 * @return : contact id which is deleted
	 */
	@Override
	public void deleteAddressBookData(int contactId) {
		addressBookList.remove(contactId - 1);

	}
}
