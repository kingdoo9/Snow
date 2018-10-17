package Stages;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.GConstants;
import Controller.GMapManager;
import Model.MapLinkedList;
import Stages.GStage2.MyActionListener;
import View.GPlay;
import View.MainFrame;

public class GStage4 extends JPanel{


	private MainFrame win;
	private GMapManager MapManager;
	private JButton buttons[];
	private JButton Stage4, Back;
	private GPlay play;
	
	public GStage4(MainFrame win) {
		this.win = win;
		GConstants.maps = new LinkedList<MapLinkedList>();
		MapManager = new GMapManager();
		MapManager.LoadMap("Stage4");
		buttons = new JButton[GConstants.maps.size()];
		
		Stage4 = new JButton();
		Stage4.setBorder(null);
		Stage4.setIcon(new ImageIcon("images/STAGE4.png"));
		Stage4.setContentAreaFilled(false);
		this.add(Stage4);
		
		Back = new JButton();
		Back.setBorder(null);
		Back.setIcon(new ImageIcon("images/Back.png"));
		Back.setActionCommand(GConstants.levelPlay.back.toString());
		Back.addActionListener(new MyActionListener());
		Back.setContentAreaFilled(false);
		this.add(Back);
		
		for(int i=0; i<GConstants.maps.size(); i++){
			buttons[i] = new JButton();
			buttons[i].setBorder(null);
			if(GConstants.maps.get(i).getLockLevel() == true){
				buttons[i].setIcon(new ImageIcon("images/Level_OnMouse.png"));
			}else{
				buttons[i].setIcon(new ImageIcon("images/Level.png"));
				buttons[i].addActionListener(new MyActionListener());
			}
			buttons[i].setContentAreaFilled(false);
			this.add(buttons[i]);
		}
		
		buttons[0].setActionCommand(GConstants.levelPlay.one.toString());
		buttons[1].setActionCommand(GConstants.levelPlay.two.toString());
		buttons[2].setActionCommand(GConstants.levelPlay.three.toString());
		buttons[3].setActionCommand(GConstants.levelPlay.four.toString());
		buttons[4].setActionCommand(GConstants.levelPlay.five.toString());
		buttons[5].setActionCommand(GConstants.levelPlay.six.toString());
		buttons[6].setActionCommand(GConstants.levelPlay.seven.toString());
		buttons[7].setActionCommand(GConstants.levelPlay.eight.toString());
		buttons[8].setActionCommand(GConstants.levelPlay.nine.toString());
		buttons[9].setActionCommand(GConstants.levelPlay.ten.toString());
		
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(GConstants.Stage4URL).getImage(), 0, 0, 
				GConstants.FrameWidth, GConstants.FrameHight, null);
		
		Stage4.setLocation(375, 50);
		Back.setLocation(10,10);
		buttons[0].setLocation(100, 200);
		buttons[1].setLocation(295, 200);
		buttons[2].setLocation(490, 200);
		buttons[3].setLocation(685, 200);
		buttons[4].setLocation(880, 200);
		buttons[5].setLocation(100, 320);
		buttons[6].setLocation(295, 320);
		buttons[7].setLocation(490, 320);
		buttons[8].setLocation(685, 320);
		buttons[9].setLocation(880, 320);
		
		
		Stage4.repaint();
		Back.repaint();
		buttons[0].repaint();
		buttons[1].repaint();
		buttons[2].repaint();
		buttons[3].repaint();
		buttons[4].repaint();
		buttons[5].repaint();
		buttons[6].repaint();
		buttons[7].repaint();
		buttons[8].repaint();
		buttons[9].repaint();


	}

	class MyActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(GConstants.levelPlay.valueOf(e.getActionCommand())){
			case back: win.change(GConstants.SwitchPanel.selection.toString()); break;
			case one:
				play = new GPlay(win, 4, 1);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case two:
				play = new GPlay(win, 4, 2);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case three:
				play = new GPlay(win, 4, 3);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case four:
				play = new GPlay(win, 4, 4);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case five:
				play = new GPlay(win, 4, 5);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case six:
				play = new GPlay(win, 4, 6);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case seven:
				play = new GPlay(win, 4, 7);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case eight:
				play = new GPlay(win, 4, 8);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case nine:
				play = new GPlay(win, 4, 9);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			case ten:
				play = new GPlay(win, 4, 10);
				win.getContentPane().removeAll();
				win.getContentPane().add(play);
				win.revalidate();
				win.repaint(); 
				break;
			default:
				break;
			}
		}
	}


}
