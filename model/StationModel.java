package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
import classes.*;

public class StationModel extends Model{

	private ResultSet res;
	private ArrayList<Medium> list;
	private String sql;


	public StationModel(){
		super();
	}

	public ArrayList<Medium> getMediums(){
		sql = "select * from medium where status=1";
		res = driver.getData(sql);
		Medium md;
		list = new ArrayList<Medium>();
		try{
			while( res.next() ){
				md = new Medium( res.getInt("id"),res.getString("name"),res.getString("status") );
				list.add( md );
			}
		}
		catch( Exception ex ){

		}
		return list;
	}

	public boolean addNewStation( Station st ){
		sql = "select id,name from stations where name='"+st.getName()+"' and medium_id="+st.getMedium();
		res = driver.getData(sql);
		try{
			if( res.next() )
				return false;
		}
		catch( Exception ex ){

		}
		sql = "insert into stations ( name,medium_id ) values ( '"+st.getName()+"',"+st.getMedium()+")" ;
		int c;
		try{
			c = driver.updateData( sql );
			/*if(c<1)
				return false;*/
		}
		catch( Exception ex ){

		}
		return true;
	}

	public ArrayList<Station> getMediumStations( int mid ){
		sql = "select id,name from stations where medium_id="+mid;
		Station st;
		ArrayList<Station> list = new ArrayList<Station>();
		try{
			res = driver.getData(sql);
			while( res.next() ){
				st = new Station( res.getInt("id"),res.getString("name") );
				st.setMedium(mid);
				list.add( st );

			}
		}
		catch( Exception exx ){

		}
		//System.out.println( "List Size = "+list.size() );
		return list;
	}

	public void deleteStations( Integer[] arr ){
		int c = 0;
		if( arr.length>0 ){
			sql = "delete from stations where ";
			for( Integer id:arr ){
				if( c>0 )
					sql += " or ";
				sql += "id = "+id;
				c++;
			}	
			int count = driver.updateData(sql);
		}

	}
	
}