package controller;


import java.awt.*;
import java.awt.event.*;

import gui.*;
import model.*;
import classes.*;

/*
*
* Starts The Application
* Does Authentication
* Implements User Based Frame & Panels
*/

public class LoginController{
	
	private LoginFrame frame;
	private String userName;
	private String pass;
	private UserModel userModel;
	private User curUser;
	
	public LoginController(){
		userModel = new UserModel();
		this.frame = new LoginFrame();
		this.frame.registerLoginButtonListener( new LoginListener() );
		frame.setVisible(true);
	}

	public void loginAttempt(){
		if( frame.validateText("User Name",userName) && frame.validateText( "Password",pass ) ){		
			int id = userModel.checkUser( userName,pass );
			if( id>(-1) ){
				
				curUser = userModel.getUser();
				if( curUser!=null ){
					// User Classification 
					// Based on that initialize Frame
					int userLevel = curUser.getLevel();
					if( userLevel==1 ){
						// User's level is the highest
						MainFrame mainFrame = new MainFrame();
						this.frame.setVisible(false);
						this.frame = null;
						mainFrame.init();
						mainFrame.setVisible(true);
					}
					else if( userLevel==2 ){
						// Mid Level User

					}

				}
			}
			else
				frame.displayMsg( "Invalid User Name or Password !!!" );	
		}		
	}
	
	class LoginListener implements ActionListener{
		public void actionPerformed( ActionEvent ae ){
			userName = frame.getUser();
			pass = frame.getPass();
			loginAttempt();
		}
	}
	
}