package com.nitesh.meteranalytics.dao;

import java.sql.SQLException;
import java.util.List;

public interface MeterReadingDAO<T> {
	
	public int add(T type) 
	        throws SQLException; 
	    public void delete(int id) 
	        throws SQLException; 
	    public T findOne(int id) 
	        throws SQLException; 
	    public List<T> findAll()
	        throws SQLException; 
	    public void update(T type) 
	        throws SQLException; 
}
