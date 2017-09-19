package com.sapient.nitrocab.dao;

import java.util.List;
import com.sapient.nitrocab.beanEntity.CabAvailable;
import com.sapient.nitrocab.beanEntity.CabRequest;

public interface CabsSerivceDao {
	public List<CabAvailable> getAllAvailableCabs();
	public List<CabRequest> getcabBookingRequest();
	

}
