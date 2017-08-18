package com.ajay.dao;

import java.util.ArrayList;
import java.util.List;

import com.ajay.entity.Area;
import com.ajay.entity.BookingRequest;
import com.ajay.util.Utils;

/**
 * DAO for performing all CRUD operations for {@link BookingRequest} entity
 */
public class BookingRequestDAO {
	
	private List<BookingRequest> bookingRequestList = new ArrayList<>();

	public List<BookingRequest> getAllBookingRequests() {
		bookingRequestList.add(new BookingRequest("BR001", new Area(100025, 25), new Area(100036,36), Utils.getFutureTime(10), null));
		bookingRequestList.add(new BookingRequest("BR002", new Area(100056, 56), new Area(100042,42), Utils.getFutureTime(11), null));
		bookingRequestList.add(new BookingRequest("BR003", new Area(100044, 44), new Area(100056,56), Utils.getFutureTime(12), null));
		bookingRequestList.add(new BookingRequest("BR004", new Area(100028, 28), new Area(100036,36), Utils.getFutureTime(15), null));
		
		return bookingRequestList;
	}

}
