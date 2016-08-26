package org.cybercafe.exception;

public class DuplicateUserEmailException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DuplicateUserEmailException(String message) {
		super(message);
	}
}
