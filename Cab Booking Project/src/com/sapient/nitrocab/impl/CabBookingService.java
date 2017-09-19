package com.sapient.nitrocab.impl;

import java.util.List;

import  com.sapient.nitrocab.beanEntity.CabRequest;
import com.sapient.nitrocab.beanEntity.CabRequestImpl;

public interface CabBookingService {

	CabRequestImpl cabBookingprocess(List<CabRequest> cabReq);
	
}
