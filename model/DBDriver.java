package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
* DBDriver Class 
* Singleton Pattern Used
* Can not be instanciated with "new" keyword
*/
public class DBDriver{
	
	// Static Members
	private static DBDriver instance = null;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/tms";
    private static final String USER = "root";
    private static final String PASS = "";
	// Non Static Members
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	
	// Private Constructor
	private DBDriver(){
		connect();
	}
	
	// Instance Creator
	// returns Object Reference
	public static DBDriver getInstance(){
		if( instance==null )
			instance = new DBDriver();
		return instance;
	}
	
	// connects database
	public void connect(){
		try{
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch( Exception ex ){
			
		}
	}
	
	// closes connection
	public void close() throws SQLException{
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
	}
	
	// Get Rows
	public ResultSet getData( String sql ){
		rs = null;
		try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(sql);
        }
        catch(Exception ex){
        }
        return rs;
	}
	
	// update method
	// dosent return any data
	public int updateData( String sql ){
		int numOfRowsUpdated = 0;
		try{
			stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
		}
		catch( Exception ex ){
			
		}
		return numOfRowsUpdated;
	}
}