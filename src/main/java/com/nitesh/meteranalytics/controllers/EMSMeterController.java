package com.nitesh.meteranalytics.controllers;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.meteranalytics.dao.EMSMeterReadingDAOImpl;
import com.nitesh.meteranalytics.dao.MeterReadingDAOImpl;
import com.nitesh.meteranalytics.models.EMSMeter;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.repositories.MeterReadingRepository;



@RestController
@RequestMapping("/api/v1/emsreadings")
public class EMSMeterController {

	//@Autowired
	//MeterReadingRepository meterReadingRepository;
	EMSMeterReadingDAOImpl meterReadingDAOImpl = new EMSMeterReadingDAOImpl();
	@GetMapping
	public List<EMSMeter> list() throws SQLException {
		//return meterReadingRepository.findAll();
		return meterReadingDAOImpl.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public void createMeterReading(@RequestBody EMSMeter meter, HttpServletResponse response) throws SQLException {
		if(1 == meterReadingDAOImpl.add(meter)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	}
	
	@GetMapping("/{meterNo}/{fromDate}/{toDate}")
	public List<EMSMeter> get(@PathVariable("meterNo") Long meterNo, @PathVariable("fromDate") Timestamp fromDate, @PathVariable("toDate") Timestamp toDate) {
		return this.meterReadingDAOImpl.findByMeterNoAndData(meterNo, fromDate, toDate);
	}
}
