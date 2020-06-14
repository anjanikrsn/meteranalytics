package com.nitesh.meteranalytics.query;

import java.util.ArrayList;
import com.nitesh.meteranalytics.models.Meter;

public class QueryBuilder {

	public static String insertQuery(Meter emp) {
		return "INSERT INTO " + "tb_"+ emp.getQuarterNumber() + "_" + emp.getStationName() + " VALUES(?, ?, ?, ?, ?, ?, ?)";
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
}