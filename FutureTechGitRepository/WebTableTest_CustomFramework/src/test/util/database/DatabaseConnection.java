package test.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	public boolean isDriverLoaded(String driver) {
		try {
			Class.forName(driver);
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC driver not found!");
			e.printStackTrace();
			return false;
		}
	}
	
	public void connectToDatabase(String dbParameters) {
		try {
			connection = DriverManager.getConnection(dbParameters, "asad", "asad");
		} catch (SQLException e) {
			System.out.println("\nConnection Failed! Check output console\n");
			e.printStackTrace();
			return;
		} 
	}
	
	public boolean isConnectedToDatabase() {
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean createStatement() {
		try {
			statement = connection.createStatement();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
	}
	
	public void runQuery(String query) {
		try {
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	/*String country[] = {"Russia", "Arab Emirates", "Bangladesh", "Canada", "India", "USA"};
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
	System.out.println("\nOracle JDBC connect and query test completed.");*/

}
