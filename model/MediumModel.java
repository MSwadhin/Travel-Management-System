package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import classes.Medium;

public class MediumModel extends Model{

	private ResultSet res;
	private ArrayList<Medium> list;
	public ArrayList<Medium> getAll(){
		String sql = "select * from medium";
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
	public void update( ArrayList<Medium> mlist ){
		String sql,values="";
		int i,c=0;
		Medium mi;
		for( i=0;i<mlist.size();i++  ){
			mi = mlist.get(i);
			sql = "update medium set status='" + mi.getStatus() + "' where name='" + mi.getName() + "'";
			c += driver.updateData(sql);
			//System.out.println(mi.getStatus());
			//System.out.println(mi.getName());
		}
		//System.out.println(c);
	}
	public MediumModel(){
		super();
	}
}