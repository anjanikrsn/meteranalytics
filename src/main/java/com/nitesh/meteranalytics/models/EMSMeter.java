package com.nitesh.meteranalytics.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class EMSMeter {
	
	@Override
	public String toString() {
		return "EMSMeter [meter no=" + meter_no + ", readingDate=" + posting_time + ", prevReading=" + meter_no + ", presReading="
				+ w_total + ", kwh=" + var_total + ", remarks=" + va_total + ", va="
				+ "]";
	}
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "meter_no")
	private BigDecimal meter_no;
	
	@Id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "posting_time")
	private String posting_time;
	
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "w_total")
	private BigDecimal w_total;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Column(name = "var_total")
	private BigDecimal var_total;
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "va_total")
	private BigDecimal va_total; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "pf")
	private BigDecimal pf; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vry")
	private BigDecimal vry; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vyb")
	private BigDecimal vyb; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vbr")
	private BigDecimal vbr; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vr")
	private BigDecimal vr; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vy")
	private BigDecimal vy; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vb")
	private BigDecimal vb; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "ir")
	private BigDecimal ir; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "iy")
	private BigDecimal iy; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "ib")
	private BigDecimal ib; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal frequency; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vr_harmonics")
	private BigDecimal vr_harmonics; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vy_harmonics")
	private BigDecimal vy_harmonics; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "vb_harmonics")
	private BigDecimal vb_harmonics;
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "ir_harmonics")
	private BigDecimal ir_harmonics; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "iy_harmonics")
	private BigDecimal iy_harmonics; 
	
	@JsonFormat(shape=JsonFormat.Shape.NUMBER_FLOAT)
	@Column(name = "ib_harmonics")
	private BigDecimal ib_harmonics;

	public String getPostingTime() {
		return posting_time;
	}
	public void setPostingTime(String postingTime) {
		this.posting_time = postingTime;
	}
	public BigDecimal getMeterNo() {
		return meter_no;
	}
	public void setMeterNo(BigDecimal meterNo) {
		this.meter_no = meterNo;
	}
	public BigDecimal getWattageTotal() {
		return w_total;
	}
	public void setWattageTotal(BigDecimal wattageTotal) {
		this.w_total = wattageTotal;
	}
	public BigDecimal getVarianceTotal() {
		return var_total;
	}
	public void setVarianceTotal(BigDecimal varianceTotal) {
		this.var_total = varianceTotal;
	}
	public BigDecimal getVaTotal() {
		return va_total;
	}
	public void setVaTotal(BigDecimal vaTotal) {
		this.va_total = vaTotal;
	}
	public BigDecimal getPf() {
		return pf;
	}
	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}
	public BigDecimal getVry() {
		return vry;
	}
	public void setVry(BigDecimal vry) {
		this.vry = vry;
	}
	public BigDecimal getVyb() {
		return vyb;
	}
	public void setVyb(BigDecimal vyb) {
		this.vyb = vyb;
	}
	public BigDecimal getVbr() {
		return vbr;
	}
	public void setVbr(BigDecimal vbr) {
		this.vbr = vbr;
	}
	public BigDecimal getVr() {
		return vr;
	}
	public void setVr(BigDecimal vr) {
		this.vr = vr;
	}
	public BigDecimal getVy() {
		return vy;
	}
	public void setVy(BigDecimal vy) {
		this.vy = vy;
	}
	public BigDecimal getVb() {
		return vb;
	}
	public void setVb(BigDecimal vb) {
		this.vb = vb;
	}
	public BigDecimal getIr() {
		return ir;
	}
	public void setIr(BigDecimal ir) {
		this.ir = ir;
	}
	public BigDecimal getIy() {
		return iy;
	}
	public void setIy(BigDecimal iy) {
		this.iy = iy;
	}
	public BigDecimal getIb() {
		return ib;
	}
	public void setIb(BigDecimal ib) {
		this.ib = ib;
	}
	public BigDecimal getFrequency() {
		return frequency;
	}
	public void setFrequency(BigDecimal frequency) {
		this.frequency = frequency;
	}
	public BigDecimal getVrHarmonics() {
		return vr_harmonics;
	}
	public void setVrHarmonics(BigDecimal vrHarmonics) {
		this.vr_harmonics = vrHarmonics;
	}
	public BigDecimal getVyHarmonics() {
		return vy_harmonics;
	}
	public void setVyHarmonics(BigDecimal vyHarmonics) {
		this.vy_harmonics = vyHarmonics;
	}
	public BigDecimal getVbHarmonics() {
		return vb_harmonics;
	}
	public void setVbHarmonics(BigDecimal vbHarmonics) {
		this.vb_harmonics = vbHarmonics;
	}
	public BigDecimal getIrHarmonics() {
		return ir_harmonics;
	}
	public void setIrHarmonics(BigDecimal irHarmonics) {
		this.ir_harmonics = irHarmonics;
	}
	public BigDecimal getIyHarmonics() {
		return iy_harmonics;
	}
	public void setIyHarmonics(BigDecimal iyHarmonics) {
		this.iy_harmonics = iyHarmonics;
	}
	public BigDecimal getIbHarmonics() {
		return ib_harmonics;
	}
	public void setIbHarmonics(BigDecimal ibHarmonics) {
		this.ib_harmonics = ibHarmonics;
	}	
	
}
