package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import classes.*;

public abstract class MediumList extends AbstractPanel{

	protected ArrayList<Medium> mediumList;
	protected JComboBox<String> mediumDropdown;
	protected int selectedMedium;
	protected String selectedName;


	public void setMediumList( ArrayList<Medium> list ){
		mediumList = list;
	}

	public void showMediums(  ){
		
		ArrayList<String> medNameList = new ArrayList<String>();
		medNameList.add("None");
		if( mediumList==null || mediumList.size()<1 ){

		}else{

			selectedName = "None";
			for( Medium mi:mediumList )
				medNameList.add( mi.getName() );
			mediumDropdown = new JComboBox<String>(
				medNameList.toArray( new String[medNameList.size()] )
			);

			mediumDropdown.setMaximumSize( new Dimension( 200,40 ) );
			//mediumDropdown.setSelectedIndex(0);

			
			mediumDropdown.addItemListener( new ItemListener(){
	            public void itemStateChanged(ItemEvent ie) {
	                //if (ie.getStateChange() == ItemEvent.SELECTED){
	                    selectedName =  (String)mediumDropdown.getSelectedItem();
	                //}
	            }
	        });

			mediumDropdown.setAlignmentX( Component.LEFT_ALIGNMENT );

			add( mediumDropdown );
		}
	}

	public int getSelectedMedium(){
		if( selectedName.equals("None") )
			return -1;
		for( Medium mi:mediumList )
			if( mi.getName().equals( selectedName ) )
				return mi.getId();
		return -1;
	}

	public void addMediumSeleceAction( ItemListener al ){
		mediumDropdown.addItemListener( al );
	}
}