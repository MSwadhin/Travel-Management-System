package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
import classes.*;


public class VehicleModel extends Model{



	public ArrayList<Route> getAllRoutes( int mid ){

		sql = "select * from routes where mid="+mid;
		ArrayList<Route> rl = new ArrayList<Route>();
		Route r;
		try{
			driver.getData(sql);
			while( res.next() ){
				r = new Route( res.getInt("id"),res.getString("name") );
				r.setMedium( res.getInt("mid") );
				r.setSrc( res.getInt("sid") );
				r.setDest( res.getInt("did") );
				rl.add( r );
			}
		}
		catch( Exception ex ){}
		return rl;
	}

	public void addVehicle( int rid,int mid,String name  ){
		sql = "insert into vehicles (name,rid) values( '"+name+"',"+rid+" )";
		try{
			int c = driver.updateData(sql);
			System.out.println(sql);
		}
		catch(Exception ex){}
	}
}