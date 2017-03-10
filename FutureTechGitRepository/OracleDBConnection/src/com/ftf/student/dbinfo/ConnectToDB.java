package com.ftf.student.dbinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {
	
	public void countryDataBase(String parameters) throws SQLException {
		
		String country[] = {"Russia", "Arab Emirates", "Bangladesh", "Canada", "India", "USA"};
		String dbParameters = "jdbc:oracle:thin:@" + parameters;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		System.out.println("\nOracle JDBC Driver Registered!");
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(dbParameters, "asad", "asad");
		} catch (SQLException e) {
			System.out.println("\nConnection Failed! Check output console\n");
			e.printStackTrace();
			return;
		} 
		
		if (connection != null) {
			System.out.println("\nDatabase connected! Ready to insert queries!\n");
		} else {
			System.out.println("\nFailed to make connection!\n");
		}
		
		Statement sqlStatement = connection.createStatement();
		
		for (int i=0; i<country.length; i++) {
			ResultSet sqlResultSet = sqlStatement.executeQuery("insert into countrynames values('" + country[i] + "')");
		}
		
		ResultSet sqlResultSetSelect = sqlStatement.executeQuery("select * from countrynames");
		
		System.out.println("Country List: ");
		
		while (sqlResultSetSelect.next()) {
			System.out.println(sqlResultSetSelect.getString(1));
		}
		
		connection.close();
		System.out.println("\nOracle JDBC connect and query test completed.");
	}

}
