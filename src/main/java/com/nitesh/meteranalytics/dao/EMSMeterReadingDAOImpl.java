package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.EMSMeter;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class EMSMeterReadingDAOImpl implements MeterReadingDAO<EMSMeter>{

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(EMSMeter emsObj) throws SQLException {
		int result = -1;
		String query = QueryBuilder.insertQuery(emsObj);
		try ( PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
			pstmt.setBigDecimal(1, emsObj.getMeterNo());
			pstmt.setDate(2, emsObj.getPostingTime());
			pstmt.setBigDecimal(3, emsObj.getWattageTotal());
			pstmt.setBigDecimal(4, emsObj.getVarianceTotal());
			pstmt.setBigDecimal(5, emsObj.getPf());
			pstmt.setBigDecimal(6, emsObj.getVaTotal());
			pstmt.setBigDecimal(7, emsObj.getVry());
			pstmt.setBigDecimal(8, emsObj.getVyb());
			pstmt.setBigDecimal(9, emsObj.getVbr());
			pstmt.setBigDecimal(10, emsObj.getVr());
			pstmt.setBigDecimal(11, emsObj.getVy());
			pstmt.setBigDecimal(12, emsObj.getVb());
			pstmt.setBigDecimal(13, emsObj.getIr());
			pstmt.setBigDecimal(14, emsObj.getIy());
			pstmt.setBigDecimal(15, emsObj.getIb());
			pstmt.setBigDecimal(16, emsObj.getFrequency());
			pstmt.setBigDecimal(17, emsObj.getVrHarmonics());
			pstmt.setBigDecimal(18, emsObj.getVyHarmonics());
			pstmt.setBigDecimal(19, emsObj.getVbHarmonics());
			pstmt.setBigDecimal(20, emsObj.getIrHarmonics());
			pstmt.setBigDecimal(21, emsObj.getIyHarmonics());
			pstmt.setBigDecimal(22, emsObj.getIbHarmonics());
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
	public EMSMeter findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EMSMeter> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EMSMeter emp) throws SQLException {
		// TODO Auto-generated method stub

	}

}
