package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.EMSMeter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class EMSMeterReadingDAOImpl implements MeterReadingDAO<EMSMeter>{

	static Connection dbConnection = JDBCConnection.getConnection();
	 
	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-ddHHmmsss");
	
	@Override
	public int add(EMSMeter emsObj) throws SQLException {
		int result = -1;
		String query = QueryBuilder.insertQuery(emsObj);
		try ( PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
			pstmt.setBigDecimal(1, emsObj.getMeterNo());
			pstmt.setString(2, emsObj.getPostingTime());
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

	public List<EMSMeter> findByMeterNoAndData(Long meterNo, String fromDate, String toDate) {
		List<EMSMeter> resultList = new ArrayList<EMSMeter>();
		if(StringUtils.isEmpty(meterNo) || StringUtils.isEmpty(fromDate)) {
			return resultList;
		}
		if(StringUtils.isEmpty(toDate)) {
			toDate = fromDate;
		}
		String query = QueryBuilder.findByMeterNoAndDateQuery(meterNo, fromDate, toDate);
		try ( Statement stmt = dbConnection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				EMSMeter emsObj = new EMSMeter();
				emsObj.setMeterNo(rs.getBigDecimal(1));
				emsObj.setPostingTime(rs.getString(2));
				emsObj.setWattageTotal(rs.getBigDecimal(3));
				emsObj.setVarianceTotal(rs.getBigDecimal(4));
				emsObj.setPf(rs.getBigDecimal(5));
				emsObj.setVaTotal(rs.getBigDecimal(6));
				emsObj.setVry(rs.getBigDecimal(7));
				emsObj.setVyb(rs.getBigDecimal(8));
				emsObj.setVbr(rs.getBigDecimal(9));
				emsObj.setVr(rs.getBigDecimal(10));
				emsObj.setVy(rs.getBigDecimal(11));
				emsObj.setVb(rs.getBigDecimal(12));
				emsObj.setIr(rs.getBigDecimal(13));
				emsObj.setIy(rs.getBigDecimal(14));
				emsObj.setIb(rs.getBigDecimal(15));
				emsObj.setFrequency(rs.getBigDecimal(16));
				emsObj.setVrHarmonics(rs.getBigDecimal(17));
				emsObj.setVyHarmonics(rs.getBigDecimal(18));
				emsObj.setVbHarmonics(rs.getBigDecimal(19));
				emsObj.setIrHarmonics(rs.getBigDecimal(20));
				emsObj.setIyHarmonics(rs.getBigDecimal(21));
				emsObj.setIbHarmonics(rs.getBigDecimal(22));
				resultList.add(emsObj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}
	 
	private java.sql.Timestamp parseTimestamp(String timestamp) {
	    try {
	        return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}

}
