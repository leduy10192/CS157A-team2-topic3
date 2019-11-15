package etrt.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author ivan
*/
public class Project3Builder{
	
	public static String USERNAME = new String("leduy");
    public static String PASSWORD = new String("homework11");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/cs157");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");
	static String[]	Tables = {
			"CREATE TABLE PATIENT (" + 
				"thc INT PRIMARY KEY AUTO_INCREMENT, " + 
				"first_name VARCHAR(20) NOT NULL, " + 
				"last_name VARCHAR(40) NOT NULL);",
			"CREATE TABLE VISIT (" +
				"visit_id INT PRIMARY KEY AUTO_INCREMENT, " + 
                                "visit_datetime DATETIME DEFAULT CURRENT_TIMESTAMP, "+
				"visit_date VARCHAR(20) AS (DATE_FORMAT(visit_datetime,'%m/%d/%Y')), " + 
				"visit_number INT DEFAULT 1, " + 
				"thc INT NOT NULL, " +
				"FOREIGN KEY(`thc`) REFERENCES PATIENT(`thc`))",
			"CREATE TABLE THI (" +
				"thi_id INT PRIMARY KEY AUTO_INCREMENT, " + 
				"f1 SMALLINT, " + 
				"f2 SMALLINT, " + 
				"e3 SMALLINT, " + 
				"f4 SMALLINT, " + 
				"c5 SMALLINT, " + 
				"e6 SMALLINT, " + 
				"f7 SMALLINT, " + 
				"c8 SMALLINT, " + 
				"f9 SMALLINT, " + 
				"e10 SMALLINT, " + 
				"c11 SMALLINT, " + 
				"f12 SMALLINT, " + 
				"f13 SMALLINT, " + 
				"e14 SMALLINT, " + 
				"f15 SMALLINT, " + 
				"e16 SMALLINT, " + 
				"e17 SMALLINT, " + 
				"f18 SMALLINT, " + 
				"c19 SMALLINT, " + 
				"f20 SMALLINT, " + 
				"e21 SMALLINT, " + 
				"e22 SMALLINT, " + 
				"c23 SMALLINT, " + 
				"f24 SMALLINT, " + 
				"e25 SMALLINT, " + 
				"f_score SMALLINT, " + 
				"e_score SMALLINT, " + 
				"c_score SMALLINT, " + 
				"total_score SMALLINT, " + 
				"visit_id INT, " +
				"FOREIGN KEY(`visit_id`) REFERENCES VISIT(`visit_id`))",
			"CREATE TABLE TFI (" +
				"tfi_id INT PRIMARY KEY AUTO_INCREMENT, " + 
				"i1 SMALLINT, " + 
				"i2 SMALLINT, " + 
				"i3 SMALLINT, " + 
				"sc4 SMALLINT, " + 
				"sc5 SMALLINT, " + 
				"sc6 SMALLINT, " + 
				"c7 SMALLINT, " + 
				"c8 SMALLINT, " + 
				"c9 SMALLINT, " + 
				"sl10 SMALLINT, " + 
				"sl11 SMALLINT, " + 
				"sl12 SMALLINT, " + 
				"a13 SMALLINT, " + 
				"a14 SMALLINT, " + 
				"a15 SMALLINT, " + 
				"r16 SMALLINT, " + 
				"r17 SMALLINT, " + 
				"r18 SMALLINT, " + 
				"q19 SMALLINT, " + 
				"q20 SMALLINT, " + 
				"q21 SMALLINT, " + 
				"q22 SMALLINT, " + 
				"e23 SMALLINT, " + 
				"e24 SMALLINT, " + 
				"e25 SMALLINT, " + 
				"i_score SMALLINT, " + 
				"sc_score SMALLINT, " + 
				"c_score SMALLINT, " + 
				"sl_score SMALLINT, " + 
				"a_score SMALLINT, " + 
				"r_score SMALLINT, " + 
				"q_score SMALLINT, " + 
				"e_score SMALLINT, " + 
				"total_score SMALLINT, " + 
				"visit_id INT, " + 
				"FOREIGN KEY(`visit_id`) REFERENCES VISIT(`visit_id`))"
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
