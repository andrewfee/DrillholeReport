package servlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.*;

public class DbHelper{

	//public static final String TABLE_NAME = "Drillholes";

	public static final String KEY_ID = "id";
	public static final String KEY_LENGTH = "length";
	public static final String KEY_EASTING = "easting";
	public static final String KEY_NORTHING = "northing";
	public static final String KEY_ELEVATION = "elevation";
	public static final String KEY_AREA = "area";
	public static final String KEY_DRILLER = "driller";
	public static final String KEY_CASING = "casing";
	public static final String KEY_DRILLDATE = "drilldate";
	

	private static Connection getConnection() throws URISyntaxException, SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}

	public static ArrayList<DrillholeRecord> SelectDrillholes(java.util.Date start, java.util.Date end) throws URISyntaxException, SQLException 
	{
		ArrayList<DrillholeRecord> records = new ArrayList<DrillholeRecord>();
		
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM drillholes WHERE drilldate >= ? AND drilldate <= ?");

		java.sql.Date sqlStartDate = new java.sql.Date(start.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(end.getTime());
		
		st.setDate(1, sqlStartDate);
		st.setDate(2, sqlEndDate);
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
			String id = rs.getString(KEY_ID);
			double length = rs.getDouble(KEY_LENGTH);
			double easting = rs.getDouble(KEY_EASTING);
			double northing = rs.getDouble(KEY_NORTHING);
			double elevation = rs.getDouble(KEY_ELEVATION);
			String area = rs.getString(KEY_AREA);
			String driller = rs.getString(KEY_DRILLER);
			double casing = rs.getDouble(KEY_CASING);
			java.sql.Date drilldate = rs.getDate(KEY_DRILLDATE);
			
			java.util.Date drillDateFormatted = new java.util.Date(drilldate.getTime());
			
			records.add(new DrillholeRecord(id, length, easting, northing, elevation, area, driller, casing, drilldate));
			
		}
		rs.close();
		st.close();
		return records;
	}
}
