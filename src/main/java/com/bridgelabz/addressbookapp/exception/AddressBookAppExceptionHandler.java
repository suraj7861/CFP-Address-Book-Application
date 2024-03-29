package com.bridgelabz.addressbookapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookAppExceptionHandler {

	/**
	 * handle any Exception thrown
	 * 
	 * @param : exception
	 * @return : ResponseEntity of Exception and HttpStatus
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(objerr -> objerr.getDefaultMessage())
				.collect(Collectors.toList());

		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST request", errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/**
	 * handle when address book Id not found
	 * @param exception
	 * @return : ResponseEntity of Exception and HttpStatus
	 */
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handlerEmployeePayrollException(AddressBookException exception) {
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request ", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
