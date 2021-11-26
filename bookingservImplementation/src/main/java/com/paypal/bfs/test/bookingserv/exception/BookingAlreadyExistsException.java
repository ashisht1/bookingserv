package com.paypal.bfs.test.bookingserv.exception;

public class BookingAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5802970098406525923L;

	public BookingAlreadyExistsException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public BookingAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
}
