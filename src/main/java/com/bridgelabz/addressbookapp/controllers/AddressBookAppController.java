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

@RestController
@RequestMapping("/addressbook")
public class AddressBookAppController {
	/**
	 * @return : Http Status & Contact details
	 */
	@RequestMapping(value = {"/get"})
	public ResponseEntity<String> getAddressBookData(){
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	/**
	 * Get contact using id
	 * @param : Id
	 * @return : Contact details
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("id") int id){
		return new ResponseEntity<String>("Get Call Success for Id: "+ id, HttpStatus.OK);
	}
	
	/**
	 * add contact details
	 * @param : addressBookDTO 
	 * @return : return added contact details
	 */
	@PostMapping("/create")
	public ResponseEntity<String> getAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
		return new ResponseEntity<String>("Created Address Book Data for: "+ addressBookDTO, HttpStatus.OK);
	}
	
	/**
	 * update contact details
	 * @param : addressBookDTO 
	 * @return : details
	 */
	@PutMapping("/update")
	public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
		return new ResponseEntity<String>("Updated Address Book Data for: "+ addressBookDTO, HttpStatus.OK);
	}
	
	/**
	 * remove contact details
	 * @param : id
	 * @return : contact id which is deleted
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("id") int id){
		return new ResponseEntity<String>("Delete call success for id: "+ id, HttpStatus.OK);
	}
}
