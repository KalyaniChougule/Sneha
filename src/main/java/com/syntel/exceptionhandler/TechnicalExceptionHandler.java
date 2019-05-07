package com.syntel.exceptionhandler;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the new addition with Spring 3.2. It is important to note that I have annotated with two annotations @ControllerAdvice. 
 * ControllerAdvice is new annotation for informing the spring container about the exception handler. 
 * Any class which is annotated with @ControllerAdvice will be registered as the global exception handler.
 * There is no other configuration in the XML files. It just works once you complete writing the controller service class.
 *  
 * This class handles all the technical exceptions. 
 *  
 * @author ASG syntel
 */

@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.LOWEST_PRECEDENCE)
public class TechnicalExceptionHandler extends ServiceExceptionHandler  
{
	
	private static final Logger logger = LoggerFactory.getLogger(TechnicalExceptionHandler.class);
	
	@Autowired
	public TechnicalExceptionHandler(MessageSource techMessageSource) {
		this.messageSource = techMessageSource;
	}
			
	/** This method handle IOException of any rest API call.
	 *  For testing purpose rest/employees/mirror throws Exception.
	 *  In real scenario any other rest API can throw Exception.
	 */
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorDTO handleIOException(IOException ex) {
		logger.error("Handle IOException here");
		return processException(ex);
	}
	
	/** This method handle ConcurrentModificationException of any rest API call.
	 *  For testing purpose rest/employees/merge throws Exception.
	 *  In real scenario any other rest API can throw Exception.
	 */
	
	@ExceptionHandler(ConcurrentModificationException.class)
	@ResponseStatus(HttpStatus.LOCKED)
	@ResponseBody
	public ErrorDTO handleConcurrentModificationException(ConcurrentModificationException ex) {
		logger.error("Handle ConcurrentModificationException here");
		return processException(ex);		
	}
	
	/** This method handle NoSuchElementException of any rest API call.
	 *  For testing purpose rest/employees/copy throws Exception.
	 *  In real scenario any other rest API can throw Exception.
	 */
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public ErrorDTO handleNoSuchElementException(NoSuchElementException ex) {
		logger.error("Handle NoSuchElementException here");
		return processException(ex);	
	}
	
	/** This method handle Type Mismatch Exception  of any rest API call.
	 *  In real scenario any rest API can throws Exception.
	 */
	@ExceptionHandler(TypeMismatchException.class)	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleTypeMismatchException(Exception ex)  throws Exception {
		logger.error("Handle TypeMismatchException here");	
		//ex.printStackTrace();
		return processException("TX007");
	}
	
	/** This method handle Invalid Format Exception of any rest API call.
	 *  In real scenario any rest API can throws Exception.
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleHttpMessageNotReadableException(Exception ex)  throws Exception {
		logger.error("Handle HttpMessageNotReadableException here");	
		//ex.printStackTrace();
		return processException("TX007");
	}
	
	/** This method handle Generic Exception of any rest API call.
	 *  In real scenario any rest API can throws Exception.
	 */
	@ExceptionHandler(Exception.class)	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleException(Exception ex) {
		logger.error("Handle Generic Exception here");	
		//ex.printStackTrace();
		return processException(ex);
	}
	
	
}