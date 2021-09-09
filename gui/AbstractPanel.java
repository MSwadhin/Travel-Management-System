package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class AbstractPanel extends JPanel{

	public abstract void init();
	public AbstractPanel(){
		setBorder( BorderFactory.createEmptyBorder( 20,50,20,50 ) );
	}
}