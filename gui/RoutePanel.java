package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import classes.*;


public class RoutePanel extends StationPanel{

	private TText name;
	private JButton addButton;
	private ArrayList<Station> srcList;
	private ArrayList<Station> destList;
	public StationList stationSrc;
	public StationList stationDest;
	private ArrayList<Station> stations;
	private JComboBox<String> c1;
	private JComboBox<String> c2;
	private JLabel dTitel;
	private JLabel sTitel;

	public RoutePanel(){

		setPreferredSize( new Dimension(600,600) );
		setLayout( new BoxLayout( this,BoxLayout.Y_AXIS  ) );
		setBackground(Color.WHITE);
	}

	@Override
	public void init(){
		showMediums();
		stations = new ArrayList<Station>();

	}


	public void showSrc( ArrayList<Station> stList ){

		if( c1!=null ){
			c1.setVisible(false);
			c1 = null;
		}
		if( c2!=null ){
			c2.setVisible(false);
			c2 = null;
		}

		if( name!=null ){
			name.setVisible(false);
		}
		if( sTitel!=null ){
			sTitel.setVisible(false);
		}
		if( dTitel!=null ){
			dTitel.setVisible(false);
		}
		if( addButton!=null ){
			addButton.setVisible(false);
		}

		srcList = stList;
		destList = stList;
		stationSrc = new StationList(this);
		stationSrc.setList(stList);
		stationDest = new StationList(this);
		stationDest.setList(stList);
		sTitel = new JLabel( "Select Source" );
		dTitel = new JLabel( "Select Destination" );
		c1 = stationSrc.show();
		c2 = stationDest.show();
		add(sTitel);
		add( c1 );
		add( dTitel );
		add( c2 );
		name = new TText(100);
		add(name);
		
		addButton = new SmallButton("Add Route");
		add( addButton );


		//System.out.println("hello");
	}


	public String getName(){
		return name.getText();
	}

	public void addButonAction( ActionListener al ){
		if( addButton!=null )
			addButton.addActionListener( al );
	}
}