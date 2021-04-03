package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.EMS;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class EMSMeterDAOImpl implements MeterReadingDAO<EMS>{

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(EMS emsObj) throws SQLException {
		/*
		 * int result = -1; String query = QueryBuilder.insertQuery(emsObj); try (
		 * PreparedStatement pstmt = dbConnection.prepareStatement(query)) {
		 * pstmt.setLong(1, 11); pstmt.setBigDecimal(2, emsObj.getMeterNo());
		 * pstmt.setString(3, emsObj.getPostingTime()); pstmt.setBigDecimal(4,
		 * emsObj.getWattageTotal()); pstmt.setBigDecimal(5, emsObj.getVarianceTotal());
		 * pstmt.setBigDecimal(6, emsObj.getVaTotal()); pstmt.setBigDecimal(4,
		 * emsObj.getPf()); pstmt.setBigDecimal(5, emsObj.getVry());
		 * pstmt.setBigDecimal(6, emsObj.getVyb()); pstmt.setBigDecimal(4,
		 * emsObj.getVbr()); pstmt.setBigDecimal(5, emsObj.getVr());
		 * pstmt.setBigDecimal(6, emsObj.getVy()); pstmt.setBigDecimal(4,
		 * emsObj.getVb()); pstmt.setBigDecimal(5, emsObj.getIr());
		 * pstmt.setBigDecimal(6, emsObj.getIy()); pstmt.setBigDecimal(6,
		 * emsObj.getIb()); pstmt.setBigDecimal(6, emsObj.getFrequency());
		 * pstmt.setBigDecimal(6, emsObj.getVrHarmonics()); pstmt.setBigDecimal(6,
		 * emsObj.getVyHarmonics()); pstmt.setBigDecimal(6, emsObj.getVbHarmonics());
		 * pstmt.setBigDecimal(6, emsObj.getIrHarmonics()); pstmt.setBigDecimal(6,
		 * emsObj.getIyHarmonics()); pstmt.setBigDecimal(6, emsObj.getIbHarmonics());
		 * result = pstmt.executeUpdate();
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } return result;
		 */
		return -1;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public EMS findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EMS> findAll() throws SQLException {
		String query = QueryBuilder.selectQuery(new ArrayList<String>(), EMS.getTableName());
		List<EMS> emsList = new ArrayList<EMS>();
		try ( Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				EMS ems = new EMS();
				ems.setEMSNo(rs.getLong(1));
				ems.setEMSName(rs.getString(2));
				emsList.add(ems);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emsList;
	}

	@Override
	public void update(EMS emp) throws SQLException {
		// TODO Auto-generated method stub

	}

}
