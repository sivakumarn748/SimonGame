package game;

import java.util.Random;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RectangularShape;

import javax.swing.*;

public class SimonUI {
	public JWindow window = new JWindow();
	public JLabel notice = new JLabel("Simon");
	public JLabel Level = new JLabel("0");
	public JLabel Total = new JLabel("0");
	public JLabel Selected = new JLabel("0");
	
	public ArrayList<Key> LIST = new ArrayList<Key>();
	public ArrayList<Key> thisRoundList = new ArrayList<Key>();
	public int level = 0;
	
	
	public Key red = new Key(Color.red, 'R', this);
	public Key blue = new Key(Color.blue, 'B', this);
	public Key green = new Key(Color.green, 'G', this);
	public Key yellow = new Key(Color.yellow, 'Y', this);
	
	public Key[] btns = {red, blue, green, yellow};
	
	public static boolean proceed = true;
	
	public void makeUI() {	
		labelConfig();
		buttonConfig();
		
		window.setLayout(null);
		window.setBounds(100, 100, 300, 300);
		window.setVisible(true);
	}
	
	private void buttonConfig() {
		red.button.setBounds(0, 0, 100, 100);
		blue.button.setBounds(200, 0, 100, 100);
		green.button.setBounds(0, 200, 100, 100);
		yellow.button.setBounds(200, 200, 100, 100);
		
		window.add(red.button);
		window.add(blue.button);
		window.add(green.button);
		window.add(yellow.button);
	}
	
	private void labelConfig() {
		notice.setBounds(100, 100, 100, 100);
		notice.setOpaque(true);
		notice.setForeground(Color.WHITE);
		notice.setHorizontalAlignment(JLabel.CENTER);
		notice.setVerticalAlignment(JLabel.CENTER);
		notice.setFont(new Font("Latin", Font.ITALIC, 20));
		window.add(notice);
		
		Level.setBounds(100, 0, 100, 100);
		Level.setHorizontalAlignment(JLabel.CENTER);
		Level.setVerticalAlignment(JLabel.CENTER);
		Level.setFont(new Font("Latin", Font.BOLD, 30));
		window.add(Level);
		
		Total.setBounds(0, 100, 100, 100);
		Total.setHorizontalAlignment(JLabel.CENTER);
		Total.setVerticalAlignment(JLabel.CENTER);
		Total.setFont(new Font("Latin", Font.BOLD, 40));
		window.add(Total);
		
		Selected.setBounds(200, 100, 100, 100);
		Selected.setHorizontalAlignment(JLabel.CENTER);
		Selected.setVerticalAlignment(JLabel.CENTER);
		Selected.setFont(new Font("Latin", Font.BOLD, 40));
		window.add(Selected);
	}
	
	Key nextLevel() {
		level = level + 1;
		Level.setText("L : " + level);
		
		Random random = new Random();
		Key k = btns[random.nextInt(btns.length)];
		
		thisRoundList.clear();
		notice.setBackground(k.button.getBackground());
		LIST.add(k);
		Total.setText("" + LIST.size());
		Selected.setText("" + thisRoundList.size());
		
		return k;
	}
	
	public void play() {
		nextLevel();
	}
	
}
