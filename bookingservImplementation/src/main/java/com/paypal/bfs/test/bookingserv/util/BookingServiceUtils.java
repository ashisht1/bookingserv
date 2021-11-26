package com.paypal.bfs.test.bookingserv.util;

import org.springframework.stereotype.Component;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.ValidationException;

@Component
public class BookingServiceUtils {
	
	public Booking convertToDto(BookingEntity booking) {
		Booking data = new Booking();
		data.setId(Integer.valueOf(booking.getId() + ""));
		data.setFirstName(booking.getFirstName());
		data.setLastName(booking.getLastName());
		data.setDateOfBirth(booking.getDateOfBirth());
		data.setCheckinDatetime(booking.getCheckinDatetime());
		data.setCheckoutDatetime(booking.getCheckoutDatetime());
		data.setTotalPrice(booking.getTotalPrice());
		data.setDeposit(booking.getDeposit());

		Address address = new Address();
		address.setLine1(booking.getLine1());
		address.setLine2(booking.getLine2());
		address.setCity(booking.getCity());
		address.setState(booking.getState());
		address.setZipcode(booking.getZipcode());
		data.setAddress(address);
		return data;
	}
	
	public BookingEntity convertToEntity(Booking booking) {
		BookingEntity data = new BookingEntity();
		data.setFirstName(booking.getFirstName());
		data.setLastName(booking.getLastName());
		data.setDateOfBirth(booking.getDateOfBirth());
		data.setCheckinDatetime(booking.getCheckinDatetime());
		data.setCheckoutDatetime(booking.getCheckoutDatetime());
		data.setTotalPrice(booking.getTotalPrice());
		data.setDeposit(booking.getDeposit());

		Address address = booking.getAddress();
		data.setLine1(address.getLine1());
		data.setLine2(address.getLine2());
		data.setCity(address.getCity());
		data.setState(address.getState());
		data.setZipcode(address.getZipcode());

		return data;
	}
	
	public void validateBookingData(Booking booking) {
		if (booking.getDeposit() > booking.getTotalPrice()) {
			throw new ValidationException("Deposit should be less then Total Price");
		}
		if (booking.getCheckoutDatetime().before(booking.getCheckinDatetime())) {
			throw new ValidationException("Check-out date should be after Check-in Date ");
		}
	}

}
