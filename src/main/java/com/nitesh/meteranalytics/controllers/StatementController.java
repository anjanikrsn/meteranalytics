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

import com.nitesh.meteranalytics.dao.MonthlyStatementDAOImpl;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.models.MonthlyStatement;



@RestController
@RequestMapping("/api/v1/statements")
public class StatementController {

	//@Autowired
	//MeterReadingRepository meterReadingRepository;
	MonthlyStatementDAOImpl statementDaoImpl = new MonthlyStatementDAOImpl();
	@GetMapping
	public List<MonthlyStatement> list() throws SQLException {
		//return meterReadingRepository.findAll();
		return statementDaoImpl.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public void createMeterReading(@RequestBody MonthlyStatement station, HttpServletResponse response) throws SQLException {
		if(1 == statementDaoImpl.add(station)) {
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
