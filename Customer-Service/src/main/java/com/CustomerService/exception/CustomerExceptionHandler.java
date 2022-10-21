package com.CustomerService.exception;

import javax.activity.InvalidActivityException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	public  String invalidInputExceptionHandler(InvalidActivityException exception) {
		return exception.getMessage();
		
		
	}

}
