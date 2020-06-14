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

import com.nitesh.meteranalytics.dao.QuarterDAOImpl;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.models.Quarter;



@RestController
@RequestMapping("/api/v1/quarters")
public class QuarterController {

	//@Autowired
	//MeterReadingRepository meterReadingRepository;
	QuarterDAOImpl quarterDAOImpl = new QuarterDAOImpl();
	@GetMapping
	public List<Quarter> list() throws SQLException {
		//return meterReadingRepository.findAll();
		return quarterDAOImpl.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public void createMeterReading(@RequestBody Quarter quarter, HttpServletResponse response) throws SQLException {
		if(1 == quarterDAOImpl.add(quarter)) {
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
