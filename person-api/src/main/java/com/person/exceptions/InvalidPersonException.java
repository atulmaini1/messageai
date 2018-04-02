package com.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid person details")
public class InvalidPersonException extends Exception {
	
	public InvalidPersonException(String message) {
		super(message);
	}
	
	public InvalidPersonException(Throwable throwable) {
		super(throwable);
	}

}
