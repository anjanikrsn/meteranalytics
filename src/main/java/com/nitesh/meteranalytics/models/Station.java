package com.nitesh.meteranalytics.models;

public class Station {

	private String stationCode;
	private String stationName;
	
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public static String getTableName() {
		return "Station";
	}
	
}
