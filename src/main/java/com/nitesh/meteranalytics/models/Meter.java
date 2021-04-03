package com.nitesh.meteranalytics.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Meter {
	
	@Override
	public String toString() {
		return "Meter [id=" + id + ", readingDate=" + readingDate + ", prevReading=" + prevReading + ", presReading="
				+ presReading + ", kwh=" + kwh + ", remarks=" + remarks + ", stationName=" + stationName
				+ ", quarterNumber=" + quarterNumber + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date readingDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Column(name = "prev_reading")
	private BigDecimal prevReading;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private BigDecimal presReading;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Column(name = "KWH")
	private BigDecimal kwh;
	
	@Column(name = "remarks")
	private String remarks; 
	
	private String stationName;
	
	private String quarterNumber;
	
	public Date getDate() {
		return readingDate;
	}
	public void setDate(Date readingDate) {
		this.readingDate = readingDate;
	}
	public BigDecimal getPreviousReading() {
		return prevReading;
	}
	public void setPreviousReading(BigDecimal prevReading) {
		this.prevReading = prevReading;
	}
	public BigDecimal getPresentReading() {
		return presReading;
	}
	public void setPresentReading(BigDecimal presReading) {
		this.presReading = presReading;
	}
	public BigDecimal getKWH() {
		return kwh;
	}
	public void setKWH(BigDecimal kwh) {
		this.kwh = kwh;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getQuarterNumber() {
		return quarterNumber;
	}
	public void setQuarterNumber(String quarterNumber) {
		this.quarterNumber = quarterNumber;
	}
	
	
}
