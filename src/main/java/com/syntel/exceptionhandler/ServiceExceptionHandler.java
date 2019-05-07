package com.syntel.exceptionhandler;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;

/**
 * Parent class of BusinessExceptionHandler and TechnicalExceptionHandler. 
 *  
 * @author ASG syntel
 */

public class ServiceExceptionHandler
{
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);
	public MessageSource messageSource;
	
	public ErrorDTO processException(Exception ex) {
		ErrorDTO dto = new ErrorDTO();			
		String localizedErrorMessage = resolveLocalizedErrorMessage(ex);	
		logger.info("localizedErrorMessage = "+localizedErrorMessage);
		dto.setMessage(localizedErrorMessage);		
		return dto;
	}
	
	public ErrorDTO processException(String exceptionCode) {
		ErrorDTO dto = new ErrorDTO();			
		String localizedErrorMessage = resolveLocalizedErrorMessage(exceptionCode);	
		logger.info("localizedErrorMessage = "+localizedErrorMessage);
		dto.setMessage(localizedErrorMessage);		
		return dto;
	}
	
	public String resolveLocalizedErrorMessage(String exceptionCode) {
		logger.info("Called resolveLocalizedErrorMessage, to get localised messages, for exception Code="+exceptionCode);		
		try{ 
			String localizedErrorMessage = messageSource.getMessage(exceptionCode,null,getLocale());		
			return localizedErrorMessage;
		} 
		catch(Exception exc){
			logger.error("Error while getting localised messages for field error."+ exc.getMessage());
		}
		return null;
	}
	
	public String resolveLocalizedErrorMessage(Exception ex) {		
		logger.info("Called resolveLocalizedErrorMessage, to get localised messages, for exception ="+ex.getMessage());
		try{
			String localizedErrorMessage = messageSource.getMessage(ex.getMessage(),null,getLocale());		
			return localizedErrorMessage;
		}
		catch(Exception exc){
			logger.error("Error while getting localised messages for field error."+ exc.getMessage());
		}
		return null;
	}

	private Locale getLocale() {
		Locale currentLocale = LocaleContextHolder.getLocale();
		logger.info("locale........"+currentLocale);
		return currentLocale;
	}
		
	public ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorDTO dto = new ValidationErrorDTO();
		for (FieldError fieldError : fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);				
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}
		return dto;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		logger.info("Called resolveLocalizedErrorMessage, to get localised messages, for fieldError="+fieldError.getField());
		String localizedErrorMessage = null;
		try{
			
			localizedErrorMessage = messageSource.getMessage(fieldError,getLocale());			
			if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
				String[] fieldErrorCodes = fieldError.getCodes();
				localizedErrorMessage = fieldErrorCodes[0];
			}
		}
		catch(Exception ex)
		{
			logger.error("Error while getting localised messages for field error." + ex.getMessage());
		}
		logger.error("localizedErrorMessage for field "+ fieldError.getField() +" is " + localizedErrorMessage);
		return localizedErrorMessage;
	}
	
	
}