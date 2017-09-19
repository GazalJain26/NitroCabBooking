package com.sapient.nitrocab.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sapient.nitrocab.beanEntity.CabAvailable;
import com.sapient.nitrocab.beanEntity.CabRequest;
import com.sapient.nitrocab.beanEntity.CabRequestImpl;
import com.sapient.nitrocab.dao.CabsSerivceDao;
import com.sapient.nitrocab.dao.CabsServiceDaoImpl;
import com.sapient.nitrocab.exception.NoAvailableCabsException;
import com.sapient.nitrocab.utils.CabprofitCheck;
import com.sapient.nitrocab.utils.Constant;

public class CabBookingServiceImpl implements CabBookingService{

	@Override
	public CabRequestImpl cabBookingprocess(List<CabRequest> cabReq){
		
		Map<CabRequest,List<CabAvailable>> cabAvailabilityMap = getAvailabilty(cabReq);
		List<CabAvailable> cabAvailable = null;
		CabRequestImpl cabObj =null;
		for(CabRequest cab :cabReq)
			cabAvailable = cabAvailabilityMap.get(cab);
			if(cabAvailable.size()>0){
				Collections.sort(cabAvailable,new CabprofitCheck());
				UUID serviceID = UUID.randomUUID();
				cabObj = new CabRequestImpl();
				cabObj.setServiceId(serviceID.toString());
				cabObj.setCab(cabAvailable.get(0));
			}
			else{
				throw new NoAvailableCabsException();
			}
		
		return cabObj;
	}
	
	private Map<CabRequest, List<CabAvailable>> getAvailabilty(List<CabRequest> cabReq) throws NoAvailableCabsException{
		
		CabsSerivceDao cabSer = new CabsServiceDaoImpl();
		Map<CabRequest,List<CabAvailable>> cabAvailabilityMap = new HashMap<CabRequest, List<CabAvailable>>();
		List<CabAvailable> cabs = cabSer.getAllAvailableCabs();
		List<CabAvailable> availableCabs = new ArrayList<CabAvailable>();
		
		double timeDiff;
		double totalDistance;
		double timetoTravel;
		double cost;
		double profit;
		
		for(CabRequest cabCommingReq: cabReq){
			
			for(CabAvailable cabsAvailable : cabs)
			{
				
				totalDistance = calculateDistance(cabsAvailable.getCabLocation(),cabCommingReq.getPickUpArea(),cabCommingReq.getDropArea());
				timetoTravel =(totalDistance*2)+15;
				timeDiff= calculateTimeDiff(cabCommingReq.getPickUpTime(),cabCommingReq.getBookingRequestTime());
				cost = 5.0*totalDistance;
				profit = getprofit(totalDistance,cost);
				
				if((timeDiff-timetoTravel) > 0 && profit >= 20){
					cabsAvailable.setProfit(profit);
					availableCabs.add(cabsAvailable);
				
				}
			}
			if(availableCabs.size()==0){
				throw new NoAvailableCabsException();
			}
			
			cabAvailabilityMap.put(cabCommingReq, availableCabs);
			
		}
		return cabAvailabilityMap;
	}





	public double getprofit(double totalDistance, double cost) {
		return ((Constant.FARE*totalDistance-cost)/cost)*100;
	}





	private long calculateTimeDiff(Date pickUpTime, Date bookingRequestTime) {
		
		return ((pickUpTime.getTime()-bookingRequestTime.getTime())/(1000*60));
	}





	private double calculateDistance(Long cabLocation, Long pickUpArea,Long dropArea) {
		
		return Math.abs((cabLocation-pickUpArea)+(pickUpArea-dropArea));
	}
	

}
