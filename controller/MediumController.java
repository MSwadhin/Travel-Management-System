package controller;

import gui.*;
import model.*;
import classes.Medium;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class MediumController implements ControllerInterface{

	private MainFrame frame;
	private ArrayList<Medium> mediumList;
	private MediumModel model;
	private MediumPanel contPanel;



	public MediumController( MainFrame frm ){
		model = new MediumModel();
		setFrame( frm );
		
		
	}

	public void init(){
		setPanel();
	}

	public void setFrame( MainFrame frm ){
		frame = frm;
	}

	public void setMediumList(){
		mediumList = model.getAll();
	}

	public void setPanel(){

		setMediumList();
		contPanel = new MediumPanel();
		ArrayList<MediumWidget> widgets = new ArrayList<MediumWidget>();
		MediumWidget wi;
		boolean tf;
		for( Medium mi:mediumList ){
			if( mi.getStatus().equals("1") )
				tf = true;
			else 
				tf = false;
			wi = new MediumWidget( mi.getName(),tf );
			widgets.add(wi);

		}
		contPanel.setWidgets( widgets );
		contPanel.init();
		frame.setContentPanel( contPanel );
		contPanel.setSaveAction( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				updateList();
			}
		} );		
	}

	public void updateList(){

		ArrayList<MediumWidget> wits = contPanel.getWidgets();
		ArrayList<Medium> mds = new ArrayList<Medium>();
		Medium md;
		for( MediumWidget mw:wits ){
			md = new Medium( 1,mw.getName(),mw.getStatusKey() );
			mds.add(md);
		}
		model.update(mds);
		setPanel();
	}	
}