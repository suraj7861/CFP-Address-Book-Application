package com.bridgelabz.addressbookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookAppController {

	@Autowired
	private IAddressBookService addressBookService;
	/**
	 * Call Get method
	 * @return : Http Status & Contact details of the employee
	 */
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData(){
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call Get method
	 * @param id : contact Id
	 * @return : Contact details of the employee
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int contactId){
		AddressBookData contactData = null;

		contactData = addressBookService.getAddressBookDataById(contactId);

		ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call post method to add details
	 * @param addressBookDTO : details id, Firstname, Lastname, Address, City & phoneNum
	 * @return : details
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> getAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData contactData = null;
		contactData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call put method to update details
	 * @param addressBookDTO : details id, Firstname, Lastname, Address, City & phoneNum
	 * @return : details
	 */
	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId")int contactId, @RequestBody AddressBookDTO addressBookDTO){
		AddressBookData contactData = null;
		contactData = addressBookService.updateAddressBookData(contactId,addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call delete method to remove address book details
	 * @param empId : Address book id
	 * @return : contact id which is deleted
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int contactId){
		addressBookService.deleteAddressBookData(contactId);
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "Deleted id : " +contactId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
