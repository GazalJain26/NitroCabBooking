package com.sapient.nitrocab.utils;

import java.util.Comparator;


import com.sapient.nitrocab.beanEntity.CabAvailable;


public class CabprofitCheck implements Comparator<CabAvailable>{

	@Override
	public int compare(CabAvailable req1, CabAvailable req2) {
		int result;
		
		result = req1.getProfit().compareTo(req2.getProfit());
		return result;
	}

}
