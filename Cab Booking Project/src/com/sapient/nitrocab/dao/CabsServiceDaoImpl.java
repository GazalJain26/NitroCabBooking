package com.sapient.nitrocab.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sapient.nitrocab.beanEntity.CabAvailable;
import com.sapient.nitrocab.beanEntity.CabRequest;

public class CabsServiceDaoImpl implements CabsSerivceDao{

	@Override
	public List<CabAvailable> getAllAvailableCabs() {
		
		List<CabAvailable> allcabsList = new ArrayList<CabAvailable>();
		allcabsList.add(new CabAvailable("DL01HB001", new Long(100020)));
		allcabsList.add(new CabAvailable("DL01HB002", new Long(100040)));
		allcabsList.add(new CabAvailable("DL01HB003", new Long(100060)));
		allcabsList.add(new CabAvailable("DL01HB004", new Long(100080)));
		return allcabsList;
	}

	@Override
	public List<CabRequest> getcabBookingRequest() {
		List<CabRequest> cabReqList = new ArrayList<CabRequest>();
		cabReqList.add(new CabRequest("BR001", new Long(100025), new Long(100036), bookingTime(10)));
		cabReqList.add(new CabRequest("BR002", new Long(100056), new Long(100042), bookingTime(11)));
		cabReqList.add(new CabRequest("BR003", new Long(100044), new Long(100056), bookingTime(12)));
		cabReqList.add(new CabRequest("BR004", new Long(100028), new Long(100036), bookingTime(15)));
		return cabReqList;
	}
	
	private Date bookingTime(int time){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, time);
		cal.set(Calendar.MINUTE, 0);
		return cal.getTime();
	}

}
