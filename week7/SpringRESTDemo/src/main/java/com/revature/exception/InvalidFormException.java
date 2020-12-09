package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="INVALID_DATA")
public class InvalidFormException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidFormException(String message) {
		super(message);
	}
}
