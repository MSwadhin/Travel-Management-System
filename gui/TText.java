package gui;

import java.awt.*;
import javax.swing.*;

public class TText extends JTextField{

	public TText( int n ){
		super(n);
		//setPreferredSize( new Dimension(200,45) );
		setMaximumSize( new Dimension(300,30) );
		//setBackground( new Color(100,100,100) );
	}
}