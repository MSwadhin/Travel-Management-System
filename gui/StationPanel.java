package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import classes.*;


public class StationPanel extends MediumList{

	private JButton addStationButton;
	private JButton deleteStationButton;
	private TText newStationName; 
	private ArrayList<StationWidget> widgets;
	private ArrayList<Station> stationList;
	private JPanel stPanel;

	public StationPanel(){

		setPreferredSize( new Dimension(600,600) );
		setLayout( new BoxLayout( this,BoxLayout.Y_AXIS  ) );
		setBackground(Color.WHITE);
	}
	public void init(){
		JLabel header = new JLabel("Add New Station:");
		JLabel header2 = new JLabel("Select Medium:");
		add(header2);
		showMediums();
		add(header);
		newStationName = new TText(40);
		newStationName.setAlignmentX( Component.LEFT_ALIGNMENT );
		addStationButton = new SmallButton("Add Station");
		deleteStationButton = new SmallButton("Delete");

		add(newStationName);
		add(addStationButton);
		showStations();
	}


	public void setAddButtonAction( ActionListener al ){
		addStationButton.addActionListener(al);
	}

	public void setDeleteButtonAction( ActionListener al ){
		deleteStationButton.addActionListener(al);
	}

	public String getStationName(  ){
		return newStationName.getText();
	}

	public void setStaionList( ArrayList<Station> list ){
		stationList = list;
	}

	public void showStations(){

		if( stPanel!=null ){
			stPanel.setVisible(false);
		}

		stPanel = new JPanel();
		stPanel.setLayout( new FlowLayout( ) );
		stPanel.setBackground(Color.WHITE);

		JLabel lb =new JLabel("ALL Stations");
		stPanel.add(lb);
		widgets = new ArrayList<StationWidget>();
		if( stationList==null || stationList.size()<1 ){
			JLabel lb2 =new JLabel("No Stations Found !");
			stPanel.add(lb2);
		}
		else{

			int i = 0;
			StationWidget w;
			for( Station st:stationList ){
				w = new StationWidget( st.getName(),false );
				w.setId(st.getId());
				widgets.add( w );
				stPanel.add( widgets.get(i) );
				i++;
			}
			
			
		}
		add(stPanel);
		if( stationList!=null && stationList.size()>0 && deleteStationButton!=null )
			add( deleteStationButton );

	}




	public Integer[] getSelectedLocId(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if( widgets!=null && widgets.size()>0 ){
			for( StationWidget sw:widgets )
				if( sw.getStatusKey().equals("1") ){
					arr.add(sw.getId());

				}
		}
		Integer[] list =  arr.toArray( new Integer[ arr.size() ] );
		return list;
	}





	class StationWidget extends MediumWidget{
		private int id;

		public void setId(int i){ id = i; }
		public int getId(){ return id; }
		public StationWidget( String n,boolean f ){
			super(n,f);
		}
	}

}