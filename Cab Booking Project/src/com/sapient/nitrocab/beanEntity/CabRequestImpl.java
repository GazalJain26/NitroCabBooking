package com.sapient.nitrocab.beanEntity;

public class CabRequestImpl {
	
	private CabAvailable cab;
	private String serviceId;
	
	public CabAvailable getCab() {
		return cab;
	}
	public void setCab(CabAvailable cab) {
		this.cab = cab;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	@Override
	public String toString() {
		return "CabRequestImpl [cabreq=" + cab + ", serviceId=" + serviceId
				+ "]";
	}
	
	

}
