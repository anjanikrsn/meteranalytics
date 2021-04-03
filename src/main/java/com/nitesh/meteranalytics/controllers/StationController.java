package com.nitesh.meteranalytics.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.meteranalytics.dao.StationDAOImpl;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.models.Station;



@RestController
@RequestMapping("/api/v1/stations")
public class StationController {

	//@Autowired
	//MeterReadingRepository meterReadingRepository;
	StationDAOImpl stationDAOImpl = new StationDAOImpl();
	@GetMapping
	public List<Station> list() throws SQLException {
		//return meterReadingRepository.findAll();
		return stationDAOImpl.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public void createMeterReading(@RequestBody Station station, HttpServletResponse response) throws SQLException {
		if(1 == stationDAOImpl.add(station)) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	}
	
	@GetMapping("/{id}")
	public Meter get(@PathVariable("id") Long id) {
		//return meterReadingRepository.getOne(id);
		return null;
	}
}
