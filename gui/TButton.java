package gui;

import java.awt.*;
import javax.swing.*;

public class TButton extends JButton{

	public TButton( String n ){
		super(n);
		setMaximumSize( new Dimension(200,45) );
		setBackground( new Color(220,220,220) );
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}