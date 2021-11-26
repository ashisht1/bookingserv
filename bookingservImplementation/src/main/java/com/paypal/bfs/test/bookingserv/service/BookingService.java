package com.paypal.bfs.test.bookingserv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.BookingAlreadyExistsException;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.util.BookingServiceUtils;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingServiceUtils bookingServiceUtils;

	public ResponseEntity<Booking> create(Booking booking) {
		bookingServiceUtils.validateBookingData(booking);
		List<BookingEntity> list = bookingRepository.getExistingBooking(booking.getFirstName(), booking.getLastName(),
				booking.getDateOfBirth(), booking.getCheckinDatetime(), booking.getCheckoutDatetime());
		if (list != null && list.size() > 0) {
			throw new BookingAlreadyExistsException("Booking already exists with given details");
		}
		BookingEntity entity = bookingServiceUtils.convertToEntity(booking);
		entity = bookingRepository.save(entity);
		return ResponseEntity.ok(bookingServiceUtils.convertToDto(entity));
	}

	public ResponseEntity<List<Booking>> getAllBookings() {
		List<BookingEntity> list = bookingRepository.findAll();
		List<Booking> response = new ArrayList<Booking>();
		for (BookingEntity entity : list) {
			response.add(bookingServiceUtils.convertToDto(entity));
		}

		return ResponseEntity.ok(response);
	}

}
