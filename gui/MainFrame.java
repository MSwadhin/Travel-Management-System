package gui;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


public class MainFrame extends AbstractFrame{

	public LeftBarPanel leftBarPanel;
	public AbstractPanel midlePanel;

	public MainFrame(){

		super("Transport Management System");
		setLayout( new BorderLayout(0,0) );
		setSize( 800,600 );
		//setVisible( true );
	}
	public void setContentPanel( AbstractPanel panel ){
		
		if( midlePanel!=null ){
			midlePanel.setVisible(false);
			midlePanel = null;
		}
		midlePanel = panel;
		add( midlePanel );
		setVisible(true);
	}
	public void init(){
		leftBarPanel = new LeftBarPanel();
		leftBarPanel.setFrame( this );
		pane.add( leftBarPanel,BorderLayout.WEST );
	}
}