/* Insert values from an array to an oracle database table (the table is already created!)
 * To test this code create a table named countrynames with one column 'name' and type 'varchar2(10)
 * This java program will automatically populate countrynames table from array values in java program
 * Compiled with JDK 1.8, ojdbc6.jar and Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String country[] = {"Arab Emirates", "Bangladesh", "Canada", "India", "USA"};
		
		System.out.println("Print the name of the countries to insert in database: \n");

		for(int i=0; i<country.length; i++) {
			System.out.println(country[i]);
		}
		
		try {
			dataTable(country);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dataTable(String country[]) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		
		try {
//			DriverManager.getConnection("jdbc:oracle:thin:@server_name/server_ipaddress:port_number:sid", "user_name", "password")
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "asad", "asad");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} 
		
		if (connection != null) {
			System.out.println("\nYou made it, take control of your database now!");
		} else {
			System.out.println("\nFailed to make connection!");
		}
		
		Statement sqlStatement = connection.createStatement();
		
		for (int i=0; i<country.length; i++) {
			ResultSet sqlResultSet = sqlStatement.executeQuery("insert into countrynames values('" + country[i] + "')");
		}
		
//		Write your SQL statement inside executeQuerty(" ")
		ResultSet sqlResultSetSelect = sqlStatement.executeQuery("select * from countrynames");
		
		System.out.println("Country List: ");
		
		while (sqlResultSetSelect.next()) {
//			The method getString() is 1-based; the count of columns start from 1;
			System.out.println(sqlResultSetSelect.getString(1));
		}
		
		connection.close();
		System.out.println("\nOracle JDBC connect and query test completed.");
	}
}
