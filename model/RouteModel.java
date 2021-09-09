package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
import classes.*;


public class RouteModel extends Model{



	public ArrayList<Station> getSations( int mid ){

		Station st;
		ArrayList<Station> stList = new ArrayList<Station>();
		sql = "select id,name from stations where medium_id=" + mid;
		try{
			res = driver.getData( sql );
			while( res.next() ){
				st = new Station( res.getInt("id"),res.getString("name") );
				st.setMedium( mid );
				stList.add(st);
			}
		}
		catch( Exception ex ){

		}
		return stList;
	}


	public void addNewRoute( int si,int di,int mi,String name ){
		sql = "insert into routes (name,sid,did,mid) values ( '"+name+"','"+si+"','"+di+"','"+mi+"' )";
		try{
			driver.updateData( sql );
		}
		catch( Exception ex ){

		}
	}


	public ArrayList<Route> getAllRoutes( int mid ){

		sql = "select * from routes where medium_id="+mid;
		ArrayList<Route> rl = new ArrayList<Route>();
		Route r;
		try{
			driver.getData(sql);
			while( res.next() ){
				r = new Route( res.getInt("id"),res.getString("name") );
				r.setMedium( res.getInt("medium_id") );
				r.setSrc( res.getInt("sid") );
				r.setDest( res.getInt("did") );
				rl.add( r );
			}
		}
		catch( Exception ex ){}
		return rl;
	}
}