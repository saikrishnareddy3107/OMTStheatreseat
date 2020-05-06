package com.movie.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControlAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex){
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Something went wrong");
		return new ResponseEntity<ErrorMessage>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
/*	@ExceptionHandler(NoInputAvailableException.class)
	public final ResponseEntity<ErrorMessage> handleException(NoInputAvailableException nia){
		ErrorMessage response=new ErrorMessage(nia.getMessage(),"Please Enter a Valid Input");
		return new ResponseEntity<ErrorMessage>(response,HttpStatus.BAD_REQUEST);
	}*/

class ErrorMessage{
	private String message;
	private String details;
	public ErrorMessage(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorMessage() {
		super();
	}
}
}