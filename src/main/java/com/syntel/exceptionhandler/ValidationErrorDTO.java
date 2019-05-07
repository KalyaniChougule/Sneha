package com.syntel.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to collect all the field's validation error.
 * 
 * @author ASG, Syntel Inc
 *
 */
public class ValidationErrorDTO {

	private List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();

	public ValidationErrorDTO() {}

	public void addFieldError(String path, String message) {
		FieldErrorDTO error = new FieldErrorDTO(path, message);
		fieldErrors.add(error);
	}

	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}
}