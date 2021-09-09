package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;


public class LeftBarPanel extends AbstractPanel{

	private JButton mediumsButton;
	private JButton stationButton;
	private JButton routeButton;
	private JButton pathsButton;
	private JButton coachClassButton;
	private JButton vehicleButton;
	private MainFrame frame;
	private ControllerInterface cr;

	public LeftBarPanel(){
		setPreferredSize( new Dimension(200,600) );
		setLayout( new BoxLayout( this,BoxLayout.Y_AXIS  ) );
		setBackground(new Color(182,182,182));
		setBorder( BorderFactory.createEmptyBorder( 0,0,0,0 ) );
		init();
	}

	public void init(){
		mediumsButton = new TButton("Mediums");
		stationButton = new TButton("Stations");
		routeButton = new TButton("Route");
		
		coachClassButton = new TButton("Coach Classes");
		vehicleButton = new TButton("Vehicles");
		add( mediumsButton );
		add( stationButton );
		add( routeButton );
		//add( coachClassButton );
		add( vehicleButton );
		addActions();

	}

	public void setFrame( MainFrame fr ){
		frame = fr;
	}

	public void addActions(){

		mediumsButton.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				cr = new MediumController( frame );
				cr.init();
			}
		});
		
		stationButton.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				cr = new StationController( frame );
				cr.init();
			}
		});
		
		routeButton.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				cr = new RouteController( frame );
				cr.init();
			}
		});
		vehicleButton.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent ae ){
				cr = new VehicleController( frame );
				cr.init();
			}
		});
		
	}

}