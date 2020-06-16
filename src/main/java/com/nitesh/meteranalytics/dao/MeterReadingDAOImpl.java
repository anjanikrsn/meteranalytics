package com.nitesh.meteranalytics.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class MeterReadingDAOImpl implements MeterReadingDAO<Meter>{

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(Meter emp) throws SQLException {
		int result = -1;
		String query = QueryBuilder.insertCustomQuery(emp);
		try ( PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
			//pstmt.setLong(1, 11);
			pstmt.setDate(1, emp.getDate());
			//pstmt.setString(2, String.valueOf(emp.getDate().getMonth()));
			pstmt.setBigDecimal(2,getPrevReading(emp));
			pstmt.setBigDecimal(3, emp.getPresentReading());
			//pstmt.setBigDecimal(5, emp.getKWH());
			//pstmt.setString(6, emp.getRemarks());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Meter findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meter> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Meter emp) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public BigDecimal getPrevReading(Meter c) {
		
		String tableName  = c.getQuarterNumber() + "_" + c.getStationName();
		String query = QueryBuilder.selectPrevQuery(tableName, "pres_reading");
		try ( Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			if(rs.next()) {
				return rs.getBigDecimal(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new BigDecimal(0);
		
	}


}
