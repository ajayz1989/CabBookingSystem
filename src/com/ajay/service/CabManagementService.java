package com.ajay.service;

import java.util.Calendar;
import java.util.List;

import com.ajay.constants.Constants;
import com.ajay.dao.BookingRequestDAO;
import com.ajay.dao.CabDAO;
import com.ajay.entity.Area;
import com.ajay.entity.BookingRequest;
import com.ajay.entity.Cab;
import com.ajay.util.Utils;

public class CabManagementService {

	private BookingRequestDAO bookingRequestDAO;
	
	private CabDAO cabDAO;
	
	private List<BookingRequest> bookingRequestList ;
	
	private List<Cab> cabDetailList;
	
	public CabManagementService() {
		bookingRequestDAO = new BookingRequestDAO();
		cabDAO = new CabDAO();
		loadData();//initially for loading request data
	}
	
	/**
	 * Load the initial request data, on whose basis processing will be done .
	 */
	public void loadData() {
		bookingRequestList = bookingRequestDAO.getAllBookingRequests();
		cabDetailList = cabDAO.getAllCabs();
	}
	
	/**
	 * Main Task execution method for performing the operation ,should be executed after performing the loadData() operation.
	 * 
	 * @throws CloneNotSupportedException
	 */
	public void executeRequest() throws CloneNotSupportedException {
		
		for (BookingRequest bookingRequest : bookingRequestList) {
			Cab assignedCab = null;
			double bestProfitMargin = 0;
			for (Cab cabDetail : cabDetailList) {
				//check the business logic for booking cabs
				boolean checkCabReachability = checkCabReachability(bookingRequest, cabDetail);
				double cabProfitMargin = checkCabProfitMargin(bookingRequest, cabDetail);
				
				if (checkCabReachability && (cabProfitMargin > bestProfitMargin)) {
					 assignedCab = cabDetail;
					 bestProfitMargin = cabProfitMargin;
				}
			}
			if (assignedCab != null) {
				bookingRequest.setAssignedCab(assignedCab.clone());
				//adding o calculate profit
				bookingRequest.setProfit(bestProfitMargin);
				Calendar newCabTime = bookingRequest.getPickUpTime();
				Integer tripDistance = Utils.calculateDistance(bookingRequest.getPickUpArea(), bookingRequest.getDropArea());
				newCabTime.add(Calendar.MINUTE, tripDistance * Constants.DISTANCE_BETWEEN_AREA);
				assignedCab.setCurrentLocationTime(newCabTime);
				assignedCab.setInitialLocation((Area)bookingRequest.getDropArea().clone());
			}
		}
		//finally displaying the response from the application
		displayMappingOfCabs(bookingRequestList);
	}

	/**
	 * Method to display the response of the request submitted .
	 * 
	 * @param bookingRequestList
	 */
	private void displayMappingOfCabs(List<BookingRequest> bookingRequestList) {
		
		bookingRequestList.forEach(bookingRequest -> {
			Cab assignedCab = bookingRequest.getAssignedCab();
			String cabNo = "Not Assigned";
			if (assignedCab != null) {
				cabNo = assignedCab.getCabNo();
			}
			System.out.println("Booking Id-"+ bookingRequest.getBookingId() +",Cab No-"+ cabNo +",Profit-" +bookingRequest.getProfit());
		});
	}

	/**
	 * Method to calculate the profit margin for a request .
	 *  
	 * @param bookingRequest
	 * @param cabDetail
	 * @return
	 */
	private double checkCabProfitMargin(BookingRequest bookingRequest, Cab cabDetail) {
		Integer distanceFromCabToPickUpPoint = Utils.calculateDistance(cabDetail.getInitialLocation(), bookingRequest.getPickUpArea());
		Integer distanceFromPickUpToDropPoint = Utils.calculateDistance(bookingRequest.getPickUpArea(), bookingRequest.getDropArea());
		int totalCostIncurredByCompany = (distanceFromCabToPickUpPoint + distanceFromPickUpToDropPoint)  * Constants.COMPANY_COST_PER_KM;
		int tripCostCharged = distanceFromPickUpToDropPoint  * Constants.CHARGED_COST_PER_KM;
		double profitMargin = (tripCostCharged - totalCostIncurredByCompany)*100 / tripCostCharged ;
		if (profitMargin >= 20) {
			return profitMargin;
		}
		return -1;
	}

	/**
	 * Method to validate the cab reachability requirement set for 15 minutes early .
	 * 
	 * @param bookingRequest
	 * @param cabDetail
	 * @return
	 */
	private boolean checkCabReachability(BookingRequest bookingRequest, Cab cabDetail) {
		boolean cabReachable = false ;
		Integer distanceFromCabToPickUpPoint = Utils.calculateDistance(cabDetail.getInitialLocation(), bookingRequest.getPickUpArea());
		Integer timeToReachPickUpPoint = distanceFromCabToPickUpPoint * Constants.MINUTES_PER_KM; // In minutes
		Calendar calendar = cabDetail.getCurrentLocationTime();
		calendar = (Calendar) calendar.clone();
		calendar.add(Calendar.MINUTE, timeToReachPickUpPoint + Constants.REACH_EARLY_BY);
		
		if (bookingRequest.getPickUpTime().compareTo(calendar) > 0) {
			cabReachable = true;
		}
		return cabReachable;
	}
}
