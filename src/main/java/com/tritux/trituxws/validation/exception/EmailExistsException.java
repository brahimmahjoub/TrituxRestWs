package com.tritux.trituxws.validation.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

	public EmailExistsException(String message) {
		super(message);
	}

}
