package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import classes.User;

public class UserModel extends Model{

	private int id;
	private ResultSet res;

	public UserModel(){
		super();
		id = -1;
	}

	public int checkUser( String userName,String passWord ){
		String sql = "select uid from users where uname='"+userName+"' and pass='"+passWord+"'";
		int uid;
		res = driver.getData( sql );
		try{
			if( res.next() )
				id = res.getInt( "uid" );
		}
		catch( Exception ex ){
			ex.printStackTrace();
		}
		return id;
	}

	public User getUser(){
		String sql;
		User curUser=null,tmp;
		sql = "select uid,uname,level from users where uid="+id;
		res = driver.getData(sql);
		if( res==null )
			return curUser;
		try{
			if( res.next() ){
				tmp = new User( res.getInt("uid") );
				tmp.setName( res.getString("uname") );
				tmp.setLevel( res.getInt("level") );
				curUser = tmp;
			}
		}
		catch( Exception ex ){
			ex.printStackTrace();
		}
		return curUser;
	}


}