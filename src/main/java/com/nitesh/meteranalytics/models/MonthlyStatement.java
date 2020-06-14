package com.nitesh.meteranalytics.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class MonthlyStatement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String PF_NO;
	private String name;
	private String desg;
	private String qrtsNo;
	private String station;
	private BigDecimal prevReading;
	private BigDecimal presReading;
	private BigDecimal units;
	private double amount;
	private double arrearAmount;
	private double totalAmount;
	private String remarks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPF_NO() {
		return PF_NO;
	}
	public void setPF_NO(String pF_NO) {
		PF_NO = pF_NO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getQrtsNo() {
		return qrtsNo;
	}
	public void setQrtsNo(String qrtsNo) {
		this.qrtsNo = qrtsNo;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public BigDecimal getPrevReading() {
		return prevReading;
	}
	public void setPrevReading(BigDecimal prevReading) {
		this.prevReading = prevReading;
	}
	public BigDecimal getPresReading() {
		return presReading;
	}
	public void setPresReading(BigDecimal presReading) {
		this.presReading = presReading;
	}
	public BigDecimal getUnits() {
		return units;
	}
	public void setUnits(BigDecimal units) {
		this.units = units;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getArrearAmount() {
		return arrearAmount;
	}
	public void setArrearAmount(double arrearAmount) {
		this.arrearAmount = arrearAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public static String getTableName() {
		return "tb_stmt1";
	}
	
	
}
