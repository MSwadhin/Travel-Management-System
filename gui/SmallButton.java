package gui;

import java.awt.*;
import javax.swing.*;

public class SmallButton extends JButton{

	public SmallButton( String n ){
		super(n);
		setMaximumSize( new Dimension(120,30) );
		setBackground( new Color(0, 0, 51) );
		setForeground( new Color(255,255,255) );
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}