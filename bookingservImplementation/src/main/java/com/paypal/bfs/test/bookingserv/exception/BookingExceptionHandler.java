package com.paypal.bfs.test.bookingserv.exception;

import java.time.LocalDateTime;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BookingExceptionHandler {

	@ExceptionHandler({ ValidationException.class })
	public final ResponseEntity<String> handleValidationException(ValidationException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		return handleExceptionInternal(status, ex.getLocalizedMessage());
	}
	
	@ExceptionHandler({ BookingAlreadyExistsException.class })
	public final ResponseEntity<String> handleBookingAlreadyExistsException(ValidationException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		return handleExceptionInternal(status, ex.getLocalizedMessage());
	}

	private ResponseEntity<String> handleExceptionInternal(HttpStatus status, String localizedMessage) {
		return new ResponseEntity<>(LocalDateTime.now()+": "+localizedMessage, status);
	}
}
