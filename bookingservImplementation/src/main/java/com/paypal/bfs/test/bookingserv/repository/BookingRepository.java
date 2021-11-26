package com.paypal.bfs.test.bookingserv.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	
	@Query(value = "SELECT * FROM booking_data u WHERE u.first_name = ?1 and u.last_name = ?2 and u.date_of_birth = ?3 and u.checkin_date = ?4 and u.checkout_date = ?5", nativeQuery = true)
	List<BookingEntity> getExistingBooking(String firstName, String lastName, String DOB, Date checkinTime, Date checkOutTime);

}
