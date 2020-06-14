package com.nitesh.meteranalytics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nitesh.meteranalytics.connection.JDBCConnection;
import com.nitesh.meteranalytics.models.Meter;
import com.nitesh.meteranalytics.models.Station;
import com.nitesh.meteranalytics.query.QueryBuilder;

public class StationDAOImpl implements MeterReadingDAO<Station> {

	static Connection dbConnection = JDBCConnection.getConnection();
	
	@Override
	public int add(Station emp) throws SQLException {
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Station findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> findAll() throws SQLException {
		String query = QueryBuilder.selectQuery(new ArrayList<String>(), Station.getTableName());
		List<Station> stationList = new ArrayList<Station>();
		try ( Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				Station station = new Station();
				station.setStationCode(rs.getString(1));
				station.setStationName(rs.getString(2));
				stationList.add(station);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stationList;
	}

	@Override
	public void update(Station emp) throws SQLException {
		// TODO Auto-generated method stub

	}

}
