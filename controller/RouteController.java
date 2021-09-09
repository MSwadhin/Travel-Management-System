package controller;


import gui.*;
import model.*;
import classes.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class RouteController extends StationController{

	protected RoutePanel contPanel;
	protected RouteModel rmodel;

	public RouteController( MainFrame mf ){
		super( mf );
		rmodel = new RouteModel();
	}

	@Override
	public void init(){
		setPanel();
	}

	@Override
	public void setPanel(){
		contPanel = new RoutePanel();
		contPanel.setMediumList( getMediums() );
		contPanel.init();

		contPanel.addMediumSeleceAction( new ItemListener(){
			public void itemStateChanged( ItemEvent ie ){
				curMediumId = contPanel.getSelectedMedium();
				if( curMediumId>=0 ){
					//contPanel.setStaionList( model.getMediumStations(curMediumId) );
					//contPanel.showStations();
					contPanel.showSrc( rmodel.getSations( curMediumId ) );
					contPanel.setVisible( false );
					contPanel.setVisible( true );
				}
				contPanel.addButonAction( new ActionListener(){
					public void actionPerformed( ActionEvent ae ){

						curMediumId = contPanel.getSelectedMedium();
						int sid = contPanel.stationSrc.getSelected();
						int did = contPanel.stationDest.getSelected();
						String n = contPanel.getName();
						addNewRoute( sid,did,curMediumId,n );
						//contPanel.showSrc( rmodel.getSations( curMediumId ) );
					}
						
				} );
			}
		});

		frame.setContentPanel( contPanel );
	}

	public void addNewRoute( int si,int di,int mi,String name ){
		if( frame.validateText( name,"Route Name" ) ){
			rmodel.addNewRoute( si,di,mi,name );
		}
	}
}