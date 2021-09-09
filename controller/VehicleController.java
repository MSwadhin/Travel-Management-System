package controller;
import gui.*;
import model.*;
import classes.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class VehicleController extends RouteController{

	private VehicleModel vmodel;
	private VehiclePanel contPanel;
	private MainFrame mf;

	public VehicleController( MainFrame frm ){
		super(frm);
		mf = frm;
		vmodel = new VehicleModel();
		contPanel = new VehiclePanel();
	}

	public void init(){
		setPanel();
	}
	public void setPanel(){
		contPanel.setMediumList( getMediums() );
		contPanel.init();

		contPanel.addMediumSeleceAction( new ItemListener(){
			public void itemStateChanged( ItemEvent ie ){
				curMediumId = contPanel.getSelectedMedium();
				contPanel.showRoutes( vmodel.getAllRoutes(curMediumId) );
				contPanel.setVisible(false);
				contPanel.setVisible(true);
				contPanel.setAddAction( new ActionListener(){
				
					public void actionPerformed( ActionEvent ae ){
						curMediumId = contPanel.getSelectedMedium();
						contPanel.showRoutes( vmodel.getAllRoutes(curMediumId) );		
						int rid = contPanel.routes.getSelected();
						String name = contPanel.getName();
						addNewVehicle( rid,curMediumId,name );
						//contPanel.showSrc( rmodel.getSations( curMediumId ) );
					}
							
				} );
			}
		
			
		});


		

		frame.setContentPanel(contPanel);
	}

	public void addNewVehicle( int rid,int mid,String name ){
		frame.validateText( name,"Vehicle Name" );
		vmodel.addVehicle(rid,mid,name);
	}
}