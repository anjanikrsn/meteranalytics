package com.nitesh.meteranalytics.query;

import java.util.ArrayList;
import com.nitesh.meteranalytics.models.Meter;

public class QueryBuilder {

	public static String insertQuery(Meter emp) {
		return "INSERT INTO " + "tb_"+ emp.getQuarterNumber() + "_" + emp.getStationName() + " VALUES(?, ?, ?, ?, ?, ?, ?)";
	}

	public static String insertCustomQuery(Meter emp) {
		return "INSERT INTO " + "tb_"+ emp.getQuarterNumber() + "_" + emp.getStationName() + " (date_of_reading,prev_reading,pres_reading) VALUES(?,?, ? )";
	}

	public static String selectQuery(ArrayList<String> fields, String tableName) {
		if(fields == null || fields.isEmpty()) {
			return "SELECT * FROM " + tableName;
		} else {
			StringBuilder query = new StringBuilder();
			query.append("SELECT ");
			String prefix = "";
			for(String field : fields) {
				query.append(prefix);
				prefix = ",";
				query.append(field);
			}
			query.append(" FROM TABLE" + tableName);
			return query.toString();
		}
	}

	public static String selectPrevQuery(String tableName, String colName) {
		// TODO Auto-generated method stub
		return "select  " + colName + " from tb_"+ tableName + " where date_of_reading = (SELECT MAX(date_of_reading) from tb_" +  tableName + " )";
		
	}
}