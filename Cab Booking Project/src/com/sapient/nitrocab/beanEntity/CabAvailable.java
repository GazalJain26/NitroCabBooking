package com.sapient.nitrocab.beanEntity;

public class CabAvailable implements Comparable<CabAvailable>{
	private String cabId;
	private Long cabLocation;
	private Double travellingDis;
	private Double timetaken;
	private Double profit;
	private boolean isbooked =false;
	
	
	public CabAvailable(String cabId, Long cabLocation) {
		super();
		this.cabId = cabId;
		this.cabLocation = cabLocation;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}
	public Long getCabLocation() {
		return cabLocation;
	}

	public void setCabLocation(Long cabLocation) {
		this.cabLocation = cabLocation;
	}

	public Double getTravellingDis() {
		return travellingDis;
	}
	
	public void setTravellingDis(Double travellingDis) {
		this.travellingDis = travellingDis;
	}
	
	public Double getTimetaken() {
		return timetaken;
	}
	
	public void setTimetaken(Double timetaken) {
		this.timetaken = timetaken;
	}


	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public boolean isIsbooked() {
		return isbooked;
	}

	public void setIsbooked(boolean isbooked) {
		this.isbooked = isbooked;
	}

	@Override
	public String toString() {
		return "CabAvailable [cabId=" + cabId + ", cabLocation=" + cabLocation+ "]";
	}

	@Override
	public int compareTo(CabAvailable o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}
	
	
	

}
