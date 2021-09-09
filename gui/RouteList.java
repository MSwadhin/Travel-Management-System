package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import classes.*;

public class RouteList{

	private ArrayList<Route> mediumList;
	private JComboBox<String> mediumDropdown;
	private int selectedMedium;
	private String selectedName;
	private JPanel cont;


	public RouteList( JPanel c ){
		cont = c;
	}


	public void setList( ArrayList<Route> list ){
		mediumList = list;
	}

	public JComboBox<String> show(  ){
		
		ArrayList<String> medNameList = new ArrayList<String>();
		medNameList.add("None");
		if( mediumList==null || mediumList.size()<1 ){
			//System.out.println("NF");
			// No Need
		}else{

			selectedName = "None";
			for( Route mi:mediumList )
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
			
		}
		return mediumDropdown;
	}

	public int getSelected(){
		if( selectedName.equals("None") )
			return -1;
		for( Route mi:mediumList )
			if( mi.getName().equals( selectedName ) )
				return mi.getId();
		return -1;
	}

	public void addSeleceAction( ItemListener al ){
		mediumDropdown.addItemListener( al );
	}
}