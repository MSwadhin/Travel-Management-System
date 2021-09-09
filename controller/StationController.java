package controller;

import gui.*;
import model.*;
import classes.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StationController implements ControllerInterface{

	protected MainFrame frame;
	protected StationModel model;
	protected StationPanel contPanel;
	protected int curMediumId;

	public StationController( MainFrame frm ){
		model = new StationModel();
		setFrame( frm );
		
	}

	public void init(){
		setPanel();
	}

	public void setFrame( MainFrame frm ){
		frame = frm;
	}

	public ArrayList<Medium> getMediums(){
		return model.getMediums();
	}


	public void setPanel(){

		contPanel = new StationPanel();
		contPanel.setMediumList(model.getMediums());
		
		contPanel.init();
		contPanel.addMediumSeleceAction( new ItemListener(){
			public void itemStateChanged( ItemEvent ie ){
				curMediumId = contPanel.getSelectedMedium();
				if( curMediumId>=0 ){
					contPanel.setStaionList( model.getMediumStations(curMediumId) );
					contPanel.showStations();
				}
			}
		});

		contPanel.setAddButtonAction( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){

				addStation();
				contPanel.setStaionList( model.getMediumStations(curMediumId) );
				contPanel.showStations();
			}
		} );

		contPanel.setDeleteButtonAction( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				deleteStations( contPanel.getSelectedLocId() );
				contPanel.setStaionList( model.getMediumStations(curMediumId) );
				contPanel.showStations();
			}
		} );

		frame.setContentPanel( contPanel );	
	}

	public void addStation(){
		curMediumId = contPanel.getSelectedMedium();
		String name = contPanel.getStationName();
		if ( frame.validateText( "Station Name",name ) ){
			if( curMediumId>0 ){
				Station st = new Station(0,name) ;
				st.setMedium( curMediumId );
				if( !model.addNewStation(st) ){
					frame.displayMsg("Station is Already in This Medium");
				}
				contPanel.showStations();
			}
			else{
				frame.displayMsg("Please Select A Medium First");
			}
		}	
	}

	public void deleteStations( Integer[] arr ){
		if( arr.length<1 )
			frame.displayMsg("Please Select Any Station");
		else 
			model.deleteStations(arr);
	}

}