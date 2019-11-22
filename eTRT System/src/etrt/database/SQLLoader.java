package etrt.database;

import java.sql.*;

public class SQLLoader
{
	public static String USERNAME = new String("leduy");
    public static String PASSWORD = new String("homework11");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/cs157");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");

	public static void
	main(String[] args) throws ClassNotFoundException
	{
		
		// Load the Driver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName(JDBC_DRIVER);

		try
		{
		          // Get a connection from the connection factory
			Connection con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);

			// Create a Statement object so we can submit SQL statements to the driver
			Statement stmt = con.createStatement();

			// Submit the statement
			for (int i=0; i<InsertRows.length; ++i)
			{
				System.out.print(InsertRows[i] + "...");
				int rowsAffected = stmt.executeUpdate(InsertRows[i]);
				if (rowsAffected == 1)
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

	static String[]	InsertRows = {
"ALTER TABLE PATIENT AUTO_INCREMENT = 120",
"insert into PATIENT(first_name,last_name ) values ('John','Smith')",
"insert into PATIENT(first_name,last_name )  values ('Kim','Nguyen')",
"insert into PATIENT(first_name,last_name ) values ('Juan','Carlos')",
"insert into PATIENT(first_name,last_name ) values ('Mike','Jones')",
"insert into PATIENT(first_name,last_name ) values ('Chloe','Hernandez')",
"insert into PATIENT(first_name,last_name ) values ('Sarah','Wilson')",
"ALTER TABLE VISIT AUTO_INCREMENT = 520",
"insert into VISIT(thc) values (120)",
"insert into VISIT(thc) values (121)",
"insert into VISIT(thc) values (122)",
"insert into VISIT(thc) values (123)",
"insert into VISIT(thc) values (124)",
"insert into VISIT(thc) values (125)",
"ALTER TABLE THI AUTO_INCREMENT = 100",
"ALTER TABLE TFI AUTO_INCREMENT = 50",
"CREATE TRIGGER insert_visit BEFORE INSERT ON VISIT " // 
+ "FOR EACH ROW " //
+ "BEGIN " //
//+ "IF (NEW.visit_number is null) THEN " //
+ "SET NEW.visit_number = (SELECT 1+MAX(visit_number) FROM VISIT WHERE thc= NEW.thc); " //
//+ "END IF; " //
+ "END;" 
	};
}
