package com.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Id")
public class InvalidIdException extends Exception {
	
	public InvalidIdException(String message) {
		super(message);
	}
	
	public InvalidIdException(Throwable throwable) {
		super(throwable);
	}

}
