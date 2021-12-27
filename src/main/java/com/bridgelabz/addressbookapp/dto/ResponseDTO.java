package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

/**
 *@Data : Auto-Generate Setters, getters and ToString   
 */
@Data
public class ResponseDTO {

	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

}
