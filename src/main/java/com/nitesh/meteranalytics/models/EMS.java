package com.nitesh.meteranalytics.models;

public class EMS {

	private Long meterNo;
	private String meterName;
	
	public Long getEMSNo() {
		return meterNo;
	}
	public void setEMSNo(Long meterNo) {
		this.meterNo = meterNo;
	}
	public String getEMSName() {
		return meterName;
	}
	public void setEMSName(String stationName) {
		this.meterName = stationName;
	}
	
	public static String getTableName() {
		return "ems";
	}
	
}
