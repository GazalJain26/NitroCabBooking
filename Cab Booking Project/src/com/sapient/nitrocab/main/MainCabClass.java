package com.sapient.nitrocab.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sapient.nitrocab.beanEntity.CabRequest;
import com.sapient.nitrocab.beanEntity.CabRequestImpl;
import com.sapient.nitrocab.exception.NoAvailableCabsException;
import com.sapient.nitrocab.impl.CabBookingServiceImpl;

public class MainCabClass {

	public List<CabRequest> getcabBookingRequest() {
		List<CabRequest> cabReqList = new ArrayList<CabRequest>();
		cabReqList.add(new CabRequest("BR003", new Long(100044), new Long(100056), bookingTime(22)));
		return cabReqList;
	}
	
	private Date bookingTime(int time){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, time);
		cal.set(Calendar.MINUTE, 0);
		return cal.getTime();
	}
	
	public static void main(String[] args){
		CabRequestImpl  cabReq = new CabRequestImpl();
		
		try{
			
			MainCabClass mainClass = new MainCabClass();
			List<CabRequest> cabReqList = mainClass.getcabBookingRequest();
			CabBookingServiceImpl cabBookingSerImpl = new CabBookingServiceImpl();
			cabReq = cabBookingSerImpl.cabBookingprocess(cabReqList);
		}
		catch (NoAvailableCabsException e) {
			System.out.println("Sorry,No cabs are available at this moment");
		}
		System.out.println(cabReq);
	}
}

