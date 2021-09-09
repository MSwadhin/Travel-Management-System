package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import classes.*;


public class VehiclePanel extends RoutePanel{

	private TText name;
	private JButton addButton;
	private ArrayList<Route> rList;
	public RouteList routes;
	private JComboBox<String> c1;
	private JLabel dTitel;

	public VehiclePanel(){

		setPreferredSize( new Dimension(600,600) );
		setLayout( new BoxLayout( this,BoxLayout.Y_AXIS  ) );
		setBackground(Color.WHITE);
	}

	@Override
	public void init(){
		showMediums();
	}

	public void showRoutes( ArrayList<Route> list ){
		rList = list;
		if( c1!=null ){
			c1.setVisible(false);
		}
		routes = new RouteList(this);
		rList = list;
		routes.setList( rList );

		c1 = routes.show();
		add(c1);
		addButton = new SmallButton("Add Route");
		name = new TText(100);
		add(name);
		add( addButton );

	}

	public void setAddAction( ActionListener al ){
		if( addButton!=null ){
			addButton.addActionListener(al);
		}
	}
}