package application;

import java.sql.*;


public class BazaPodataka {
	
	private ResultSet rs;
	private Statement statement;
	private Connection connection;
	private final String naziv="User";
	
	private boolean closeStatement = false;
	public static final String URL = "jdbc:mysql://localhost:3306/login?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS="halco1002";
	
	
	public BazaPodataka() {  //Uspjesno poveze (user login info se nalazi u ovoj bazi)
		   try {
	            Class.forName ("com.mysql.jdbc.Driver");
	        }
	        catch (Exception e) {
	            System.out.println("Failed to load JDBC/ODBC driver.");
	            return;
	        }
		   
		   try {                                                                       // Establish the database connection, create a statement for execution of SQL commands.
	            connection = DriverManager.getConnection (URL,USER,PASS );     // username and password are passed into this Constructor
	            statement  = connection.createStatement();
	             System.out.println("Uspjesno povezano");
	        }
	        catch (SQLException exception ) {
	            System.out.println ("\n*** SQLException caught ***\n");
	            while (exception != null) 
	            {                                                                         // tell us the problem
	                System.out.println ("SQLState:    " + exception.getSQLState()  );
	                System.out.println ("Message:     " + exception.getMessage()   );
	                System.out.println ("Error code:  " + exception.getErrorCode() );
	                exception = exception.getNextException ();

	                System.out.println ( "" );
	            }
	        }
	        catch ( java.lang.Exception exception ) {
	            exception.printStackTrace();
	        }
   
		   
	}
	
}

