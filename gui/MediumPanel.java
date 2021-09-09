package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MediumPanel extends AbstractPanel{

	private JButton saveButton;
	private ArrayList<MediumWidget> widgets;

	public MediumPanel(){

		setPreferredSize( new Dimension(600,600) );
		setLayout( new BoxLayout( this,BoxLayout.Y_AXIS  ) );
		setBackground(Color.WHITE);
	}
	public void setWidgets( ArrayList<MediumWidget> ws ){
		widgets = ws;
	}
	public void init(){
		for( Widget wi:widgets )
			add( wi );
		saveButton = new SmallButton("Save");
		saveButton.setAlignmentX( Component.LEFT_ALIGNMENT );
		add( saveButton );
		
	}
	public void setSaveAction( ActionListener al ){
		saveButton.addActionListener( al );
	}
	public ArrayList<MediumWidget> getWidgets(){ return widgets; }
}