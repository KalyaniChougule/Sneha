package com.syntel.exceptionhandler;

/**
 * This class is used to collect field's error with field name and error messege.
 * 
 * @author EAS, Syntel Inc
 *
 */
public class FieldErrorDTO {

	private String field;

	private String message;

	public FieldErrorDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}