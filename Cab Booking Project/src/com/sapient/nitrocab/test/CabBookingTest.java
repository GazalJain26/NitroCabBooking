package com.sapient.nitrocab.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.sapient.nitrocab.beanEntity.CabAvailable;
import com.sapient.nitrocab.beanEntity.CabRequest;
import com.sapient.nitrocab.dao.CabsSerivceDao;
import com.sapient.nitrocab.dao.CabsServiceDaoImpl;
import com.sapient.nitrocab.exception.NoAvailableCabsException;
import com.sapient.nitrocab.impl.CabBookingServiceImpl;

public class CabBookingTest {
	
	
	@Test(expected=NoAvailableCabsException.class)
	public void availablecabs(){
		List<CabAvailable> availableCabs =null;
		List<CabRequest> cabReq =null;
		CabsSerivceDao cabser = new CabsServiceDaoImpl();
		CabBookingServiceImpl serviceImpl = new CabBookingServiceImpl();
		cabReq = cabser.getcabBookingRequest();
		serviceImpl.cabBookingprocess(cabReq);
	}
	
@Test
public void getprofit(){
	CabBookingServiceImpl cabBookingImp = new CabBookingServiceImpl();
	
	assertEquals(100.0, cabBookingImp.getprofit(5, 25),0.0);
}


}
