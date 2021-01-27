package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.EMSMeter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class EMSMeterDAOImpl implements MeterReadingDAO<EMSMeter>{

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(EMSMeter emsObj) throws SQLException {
		int result = -1;
		String query = QueryBuilder.insertQuery(emsObj);
		try ( PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
			pstmt.setLong(1, 11);
			pstmt.setBigDecimal(2, emsObj.getMeterNo());
			pstmt.setString(3, emsObj.getPostingTime());
			pstmt.setBigDecimal(4, emsObj.getWattageTotal());
			pstmt.setBigDecimal(5, emsObj.getVarianceTotal());
			pstmt.setBigDecimal(6, emsObj.getVaTotal());
			pstmt.setBigDecimal(4, emsObj.getPf());
			pstmt.setBigDecimal(5, emsObj.getVry());
			pstmt.setBigDecimal(6, emsObj.getVyb());
			pstmt.setBigDecimal(4, emsObj.getVbr());
			pstmt.setBigDecimal(5, emsObj.getVr());
			pstmt.setBigDecimal(6, emsObj.getVy());
			pstmt.setBigDecimal(4, emsObj.getVb());
			pstmt.setBigDecimal(5, emsObj.getIr());
			pstmt.setBigDecimal(6, emsObj.getIy());
			pstmt.setBigDecimal(6, emsObj.getIb());
			pstmt.setBigDecimal(6, emsObj.getFrequency());
			pstmt.setBigDecimal(6, emsObj.getVrHarmonics());
			pstmt.setBigDecimal(6, emsObj.getVyHarmonics());
			pstmt.setBigDecimal(6, emsObj.getVbHarmonics());
			pstmt.setBigDecimal(6, emsObj.getIrHarmonics());
			pstmt.setBigDecimal(6, emsObj.getIyHarmonics());
			pstmt.setBigDecimal(6, emsObj.getIbHarmonics());
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
