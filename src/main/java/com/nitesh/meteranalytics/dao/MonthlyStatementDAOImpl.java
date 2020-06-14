package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.MonthlyStatement;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class MonthlyStatementDAOImpl implements MeterReadingDAO<MonthlyStatement> {

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(MonthlyStatement emp) throws SQLException {
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public MonthlyStatement findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonthlyStatement> findAll() throws SQLException {
		String query = QueryBuilder.selectQuery(new ArrayList<String>(), MonthlyStatement.getTableName());
		List<MonthlyStatement> statementList = new ArrayList<MonthlyStatement>();
		try ( Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				MonthlyStatement monthlyStmt = new MonthlyStatement();
				monthlyStmt.setId(rs.getLong(1));
				monthlyStmt.setPF_NO(rs.getString(2));
				monthlyStmt.setName(rs.getString(3));
				monthlyStmt.setDesg(rs.getString(4));
				monthlyStmt.setQrtsNo(rs.getString(5));
				monthlyStmt.setStation(rs.getString(6));
				monthlyStmt.setPrevReading(rs.getBigDecimal(7));
				monthlyStmt.setPresReading(rs.getBigDecimal(8));
				monthlyStmt.setUnits(rs.getBigDecimal(9));
				monthlyStmt.setAmount(rs.getDouble(10));
				monthlyStmt.setArrearAmount(rs.getDouble(11));
				monthlyStmt.setTotalAmount(rs.getDouble(12));
				monthlyStmt.setRemarks(rs.getString(13));
				statementList.add(monthlyStmt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statementList;
	}

	@Override
	public void update(MonthlyStatement emp) throws SQLException {
		// TODO Auto-generated method stub

	}

}
