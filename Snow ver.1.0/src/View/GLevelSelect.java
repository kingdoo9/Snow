package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Constants.GConstants;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.GMainview.MyActionListener;

public class GLevelSelect extends JPanel{
	private JButton Main, Stage1, Stage2, Stage3, Stage4, User, Back;
	private MainFrame win;
	
	
	public GLevelSelect(MainFrame win){
		this.win = win;
		
		
		Main = new JButton();
		Main.setBorder(null);
		Main.setIcon(new ImageIcon("images/LEVELSELECT.png"));
		Main.setContentAreaFilled(false);
		this.add(Main);
		
		Back = new JButton();
		Back.setBorder(null);
		Back.setIcon(new ImageIcon("images/Back.png"));
		Back.setActionCommand(GConstants.LevelSelect.Back.toString());
		Back.addActionListener(new MyActionListener());
		Back.setContentAreaFilled(false);
		this.add(Back);
		
		Stage1 = new JButton();
		Stage1.setBorder(null);
		Stage1.setIcon(new ImageIcon("images/Stage1C.png"));
		Stage1.setActionCommand(GConstants.LevelSelect.Stage1.toString());
		Stage1.addActionListener(new MyActionListener());
		Stage1.setContentAreaFilled(false);
		this.add(Stage1);
		
		Stage2 = new JButton();
		Stage2.setBorder(null);
		Stage2.setIcon(new ImageIcon("images/Stage2C.png"));
		Stage2.setActionCommand(GConstants.LevelSelect.Stage2.toString());
		Stage2.addActionListener(new MyActionListener());
		Stage2.setContentAreaFilled(false);
		this.add(Stage2);
		
		Stage3 = new JButton();
		Stage3.setBorder(null);
		Stage3.setIcon(new ImageIcon("images/Stage3C.png"));
		Stage3.setActionCommand(GConstants.LevelSelect.Stage3.toString());
		Stage3.addActionListener(new MyActionListener());
		Stage3.setContentAreaFilled(false);
		this.add(Stage3);
		
		Stage4 = new JButton();
		Stage4.setBorder(null);
		Stage4.setIcon(new ImageIcon("images/Stage4C.png"));
		Stage4.setActionCommand(GConstants.LevelSelect.Stage4.toString());
		Stage4.addActionListener(new MyActionListener());
		Stage4.setContentAreaFilled(false);
		this.add(Stage4);
		
		User = new JButton();
		User.setBorder(null);
		User.setIcon(new ImageIcon("images/Stage5C.png"));
		User.setActionCommand(GConstants.LevelSelect.Stage5.toString());
		User.addActionListener(new MyActionListener());
		User.setContentAreaFilled(false);
		this.add(User);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Main.setLocation(375, 50);
		Back.setLocation(10, 10);
		Stage1.setBounds(70, 175, 150, 150);
		Stage2.setBounds(260, 375, 150, 150);
		Stage3.setBounds(450, 175, 150, 150);
		Stage4.setBounds(640, 375, 150, 150);
		User.setBounds(830, 175, 150, 150);
		
		g.drawImage(new ImageIcon(GConstants.Background2URL).getImage(), 0, 0, 
				GConstants.FrameWidth, GConstants.FrameHight, null);

		Main.repaint();
		Back.repaint();
		Stage1.repaint();
		Stage2.repaint();
		Stage3.repaint();
		Stage4.repaint();
		User.repaint();

	}

	class MyActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(GConstants.LevelSelect.valueOf(e.getActionCommand())){
			case Back: win.change(GConstants.SwitchPanel.Main.toString()); break;
			case Stage1: win.change(GConstants.LevelSelect.Stage1.toString()); break;
			case Stage2: win.change(GConstants.LevelSelect.Stage2.toString()); break;
			case Stage3: win.change(GConstants.LevelSelect.Stage3.toString()); break;
			case Stage4: win.change(GConstants.LevelSelect.Stage4.toString()); break;
			case Stage5:  win.change(GConstants.LevelSelect.Stage5.toString()); break;
			default:
				break;
			}
		}
	}
	
}
