import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author ivan
*/
public class Project3Builder{
	
	public static String USERNAME = new String("user1");
    public static String PASSWORD = new String("testinguser1");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test1");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");
	static String[]	Tables = {
			"create table VISIT (" +
				"visit_id VARCHAR(10) PRIMARY KEY, " + 
				"visit_date DATE NOT NULL, " + 
				"patient_first_name VARCHAR(20) NOT NULL, " + 
				"patient_last_name VARCHAR(40) NOT NULL, " + 
				"patient_thc VARCHAR(20) NOT NULL, " + 
				"visit_sequence_number INT NOT NULL)",
			"create table THI (" +
				"question_number VARCHAR(2) PRIMARY KEY, " + 
				"question_type VARCHAR(1) NOT NULL, " + 
				"question_text VARCHAR(100) NOT NULL, " + 
				"question_score INT NOT NULL, " + 
				"thi_visit_id VARCHAR(10) NOT NULL, " +
				"FOREIGN KEY(`thi_visit_id`) REFERENCES VISIT(`visit_id`))",
			"create table TFI (" +
				"question_number VARCHAR(2) PRIMARY KEY, " + 
				"subscale_name VARCHAR(2) NOT NULL, " + 
				"question_text VARCHAR(100) NOT NULL, " + 
				"question_score INT, " + 
				"tfi_visit_id VARCHAR(10) NOT NULL, " + 
				"FOREIGN KEY(`tfi_visit_id`) REFERENCES VISIT(`visit_id`))"
				};

	public static void main(String[] args) throws ClassNotFoundException{
		
		// Load the Driver
		Class.forName(JDBC_DRIVER);

		try
		{
		    // Get a connection
			Connection con = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);

			// Create a Statement object so we can submit SQL statements to the driver
			Statement stmt = con.createStatement();

			// Create tables
			for (int i=0; i<Tables.length; ++i){
				System.out.print(Tables[i] + "...");
				int rowsAffected = stmt.executeUpdate(Tables[i]);
				if (rowsAffected == 0)	// DDL statements return rowcount of 0
					System.out.println("OK");
			}
			
			// Close the statement
			stmt.close();

			// Close the connection
			con.close();
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 }
	}	
}
