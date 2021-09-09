package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model{

	protected DBDriver driver;
	protected String sql;
	protected ResultSet res;

	public Model(){
		driver = DBDriver.getInstance();
	}
}