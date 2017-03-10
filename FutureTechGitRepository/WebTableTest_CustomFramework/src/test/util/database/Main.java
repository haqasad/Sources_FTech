package test.util.database;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection database = new DatabaseConnection();
	    System.out.println(database.isDriverLoaded("oracle.jdbc.driver.OracleDriver"));
	    database.connectToDatabase("jdbc:oracle:thin:@localhost:1521:orcl");
	    System.out.println(database.isConnectedToDatabase());
	    System.out.println(database.createStatement());
	    database.runQuery("select * from countrynames");
	    database.closeConnection();

	}

}
