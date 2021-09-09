package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;



public class LoginFrame extends AbstractFrame{
	
	private JPasswordField pass;
	private JTextField userName;
	private JButton loginButton;

	
	public LoginFrame(){
		super( "Transport Management System" );
		setSize( 360,220 );
		this.getContentPane().setBackground( new Color( 158, 185, 212 ) );
		setLayout( new FlowLayout() );
		addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}      
		} );
		
		init();
	}

	public void init(){

		JLabel userLabel = new JLabel(" User Name : ");
		JLabel passLabel = new JLabel(" Password :   ");
		userName = new JTextField(20);
		pass = new JPasswordField(20);
		loginButton = new JButton(" Login ");
		loginButton.setForeground( new Color(255,255,255) );
		loginButton.setBackground( new Color(0, 0, 51) );
		add( userLabel );
		add( userName );
		add( passLabel );
		add( pass );
		add( loginButton );
	}

	public void addErrorMsg( String msg ){
		JOptionPane.showMessageDialog(this,msg);
	}
	
	public String getUser(){
		return this.userName.getText();
	}
	public String getPass(){
		return new String( this.pass.getPassword() );
	}
	
	public void registerLoginButtonListener( ActionListener al ){
		this.loginButton.addActionListener( al );
	}
	
	
}