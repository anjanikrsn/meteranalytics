package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.Quarter;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class QuarterDAOImpl implements MeterReadingDAO<Quarter> {

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(Quarter emp) throws SQLException {
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Quarter findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quarter> findAll() throws SQLException {
		String query = QueryBuilder.selectQuery(new ArrayList<String>(), Quarter.getTableName());
		List<Quarter> quarterList = new ArrayList<Quarter>();
		try ( Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			Map<String, List<String>> quartersMap = new HashMap<>();
			String stationCode = null;
			while(rs.next()) {
				stationCode = rs.getString(1);
				if(quartersMap.get(stationCode) == null) {
					List<String> tempQuarterList = new ArrayList<>();
					tempQuarterList.add(rs.getString(2));
					quartersMap.put(stationCode, tempQuarterList);
				} else {
					List<String> existingList = quartersMap.get(stationCode);
					existingList.add(rs.getString(2));
				}
			}
			for(Entry<String, List<String>> data : quartersMap.entrySet()) {
				Quarter quarter = new Quarter();
				quarter.setStationCode(data.getKey());
				quarter.setQuarterNo(data.getValue());
				quarterList.add(quarter);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quarterList;
	}

	@Override
	public void update(Quarter emp) throws SQLException {
		// TODO Auto-generated method stub

	}

}
