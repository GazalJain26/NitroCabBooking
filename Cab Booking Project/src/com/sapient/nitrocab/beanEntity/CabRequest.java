package com.sapient.nitrocab.beanEntity;

import java.util.Calendar;
import java.util.Date;

public class CabRequest {
	private String bookingId;
	private Long pickUpArea;
	private Long dropArea;
	private Date pickUpTime;
	private Date bookingRequestTime;
	
	public CabRequest(String bookingId,Long pickUpArea,Long dropArea,Date pickUpTime){
		this.bookingId = bookingId;
		this.pickUpArea =pickUpArea;
		this.dropArea =dropArea;
		this.pickUpTime =pickUpTime;
		this.setBookingRequestTime(Calendar.getInstance().getTime());
	}
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Long getPickUpArea() {
		return pickUpArea;
	}
	public void setPickUpArea(Long pickUpArea) {
		this.pickUpArea = pickUpArea;
	}
	public Long getDropArea() {
		return dropArea;
	}
	public void setDropArea(Long dropArea) {
		this.dropArea = dropArea;
	}
	public Date getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public Date getBookingRequestTime() {
		return bookingRequestTime;
	}
	public void setBookingRequestTime(Date date) {
		this.bookingRequestTime = date;
	}
	
	

}
