package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public abstract class AbstractFrame extends JFrame{

	public Container pane;

	// Abstract Method 
	public abstract void init();

	public AbstractFrame( String name ){
		super(name);
		pane = getContentPane();
		addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}      
		});
	}
	public void displayMsg( String msg ){
		JOptionPane.showMessageDialog(this,msg);
	}
	public boolean validateText( String name,String text ){
		char[] arr= text.toCharArray();
		int i,l = arr.length;
		if( l<1 ){
			displayMsg( name + " Can not be empty !!! " );
			return false;
		}
		for(i=0;i<l;i++)
			if( arr[i]!=' ' )
				return true;
		displayMsg( name + " Can not be empty !!! " );
		return false;
	}
}