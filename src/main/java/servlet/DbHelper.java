package servlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;


public class DbHelper{

	private static Connection getConnection() throws URISyntaxException, SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}

	public void createTable() throws URISyntaxException, SQLException {
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
		stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
		stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
		/*
		ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
		while (rs.next()) {
			System.out.println("Read from DB: " + rs.getTimestamp("tick"));
		}
		*/
	}
}
