package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class MeterReadingDAOImpl implements MeterReadingDAO<Meter>{

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(Meter emp) throws SQLException {
		int result = -1;
		String query = QueryBuilder.insertQuery(emp);
		try ( PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
			pstmt.setLong(1, 11);
			pstmt.setDate(2, emp.getDate());
			pstmt.setString(3, String.valueOf(emp.getDate().getMonth()));
			pstmt.setBigDecimal(4, emp.getPreviousReading());
			pstmt.setBigDecimal(5, emp.getPresentReading());
			pstmt.setBigDecimal(6, emp.getKWH());
			pstmt.setString(7, emp.getRemarks());
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

}
