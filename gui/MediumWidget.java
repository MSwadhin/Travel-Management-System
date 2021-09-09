package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MediumWidget extends Widget{

	private String name;
	private JCheckBox status;
	private JLabel statusKey;


	public MediumWidget( String n,boolean isChecked ){
		name = n;
		status = new JCheckBox( name,isChecked );
		statusKey = new JLabel( "0" );
		status.setMaximumSize( new Dimension( 200,45 ) );
		if( isChecked==true )
			statusKey.setText("1");
		else 
			statusKey.setText("0");
		status.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {         
				statusKey.setText((
			   		 e.getStateChange()==1?"1":"0"
			   	));
			}           
		});
		add( status );
		//setBackground( new Color(200,200,200) );
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setAlignmentX( Component.LEFT_ALIGNMENT );
	}
	public String getName(){ return name; }
	public String getStatusKey(){ return statusKey.getText(); }
}