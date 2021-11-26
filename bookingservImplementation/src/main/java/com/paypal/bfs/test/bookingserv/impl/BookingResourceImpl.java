package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;

@RestController
public class BookingResourceImpl implements BookingResource {
	
	@Autowired
	private BookingService bookingService;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Booking> create(@Validated @RequestBody Booking booking) {
        return bookingService.create(booking);
    }

	@Override
	public ResponseEntity<List<Booking>> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingService.getAllBookings();
	}
}
