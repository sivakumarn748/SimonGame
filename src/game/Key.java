package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Key implements ActionListener {
	
	private Color color;
	public char name;
	public JButton button;
	private SimonUI parent;
	
	public void setup() {
		button.setBackground(color);
		button.addActionListener(this);
	}
	
	public Key(Color c, char n, SimonUI u) {
		color = c;
		name = n;
		parent = u;
		button = new JButton();
		setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.thisRoundList.add(this);
		
		parent.Selected.setText("" + parent.thisRoundList.size());
	
		if(parent.thisRoundList.size() <= parent.LIST.size()) {
			
			for(int i=0; i<parent.thisRoundList.size(); i++) {
				if(parent.LIST.get(i) != parent.thisRoundList.get(i)) {
					System.exit(0);
				}
			}
			
			if(parent.thisRoundList.size() == parent.LIST.size()) {
				parent.nextLevel();
			}
		}
			
	}
}
