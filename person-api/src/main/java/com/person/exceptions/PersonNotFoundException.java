package com.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Person")  // 404
public class PersonNotFoundException extends Exception{

	public PersonNotFoundException(String message) {
		super(message);
	}
	
	public PersonNotFoundException(Throwable throwable) {
		super(throwable);
	}
}
