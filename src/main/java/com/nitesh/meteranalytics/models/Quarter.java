package com.nitesh.meteranalytics.models;

import java.util.List;

public class Quarter {
	
	private String stationCode;
	private List<String> quarterNo;

	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public List<String> getQuarterNo() {
		return quarterNo;
	}
	public void setQuarterNo(List<String> quarterNo) {
		this.quarterNo = quarterNo;
	}
	
	@Override
	public String toString() {
		return "Quarter {stationName = " + stationCode + ", has quarters = " + quarterNo + "}";
	}
	public static String getTableName() {
		return "quarters";
	}
	
}
