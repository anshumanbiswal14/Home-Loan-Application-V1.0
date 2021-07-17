package com.cg.homeloan.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AdminApprovalException.class)
	public ResponseEntity<ErrorDetails> handleException(AdminApprovalException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(CustomerNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(FinanceVerificationException.class)
	public ResponseEntity<ErrorDetails> handleException(FinanceVerificationException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(LandVerificationException.class)
	public ResponseEntity<ErrorDetails> handleException(LandVerificationException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(LoanAgreementNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(LoanAgreementNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(LoanApplicationNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(LoanApplicationNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}

}
