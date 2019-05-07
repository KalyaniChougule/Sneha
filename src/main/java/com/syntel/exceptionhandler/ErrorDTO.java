package com.syntel.exceptionhandler;
/**
 * This class is used to store error object.
 * 
 * @author ASG, Syntel Inc
 *
 */
public class ErrorDTO {
	
	private String message;
	
	public ErrorDTO() {}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}