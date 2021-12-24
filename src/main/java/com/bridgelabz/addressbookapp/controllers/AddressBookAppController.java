package com.bridgelabz.addressbookapp.controllers;

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

@RestController
@RequestMapping("/addressbook")
public class AddressBookAppController {
	/**
	 * @return : Http Status & Contact details
	 */
	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Suraj", "Khomane", "Baramati", "pune", 888888777));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Get contact using id
	 * 
	 * @param : Id
	 * @return : Contact details
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Suraj", "Khomane", "Baramati", "pune", 888888777));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * add contact details
	 * 
	 * @param : addressBookDTO
	 * @return : return added contact details
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> getAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * update contact details
	 * 
	 * @param : addressBookDTO
	 * @return : details
	 */
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * remove contact details
	 * 
	 * @param : id
	 * @return : contact id which is deleted
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "Deleted id : " + id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
