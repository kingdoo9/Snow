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
import Stages.GStage4.MyActionListener;
import View.GLevelEditor;
import View.GPlay;
import View.MainFrame;

public class GUser extends JPanel{
	

	private MainFrame win;
	private GMapManager MapManager;
	private JButton buttons[];
	private JButton User, Back;
	private GPlay play;
	private GLevelEditor editor;
	private int GameMode;
	
	public GUser(MainFrame win, int Gamemode) {
		this.win = win;
		this.GameMode = Gamemode;
		GConstants.maps = new LinkedList<MapLinkedList>();
		MapManager = new GMapManager();
		MapManager.LoadMap("Stage5");
		buttons = new JButton[GConstants.maps.size()];
		
		User = new JButton();
		User.setBorder(null);
		User.setIcon(new ImageIcon("images/USERS.png"));
		User.setContentAreaFilled(false);
		this.add(User);
		
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
		
		switch(GConstants.maps.size()){
		case 10: buttons[9].setActionCommand(GConstants.levelPlay.ten.toString());
		case 9: buttons[8].setActionCommand(GConstants.levelPlay.nine.toString());
		case 8: buttons[7].setActionCommand(GConstants.levelPlay.eight.toString());
		case 7: buttons[6].setActionCommand(GConstants.levelPlay.seven.toString());
		case 6: buttons[5].setActionCommand(GConstants.levelPlay.six.toString());
		case 5: buttons[4].setActionCommand(GConstants.levelPlay.five.toString());
		case 4: buttons[3].setActionCommand(GConstants.levelPlay.four.toString());
		case 3: buttons[2].setActionCommand(GConstants.levelPlay.three.toString());
		case 2:	buttons[1].setActionCommand(GConstants.levelPlay.two.toString());
		case 1: buttons[0].setActionCommand(GConstants.levelPlay.one.toString());
		default: break;
		}		
		
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(GConstants.Stage5URL).getImage(), 0, 0, 
				GConstants.FrameWidth, GConstants.FrameHight, null);
		
		User.setLocation(375, 50);
		Back.setLocation(10,10);
		for(int i=0; i<GConstants.maps.size(); i++){
			if((100 + (i*195)) > 880){
				buttons[i].setLocation((100 + (i-5)*195), 320);
				buttons[i].repaint();
			}else{
				buttons[i].setLocation(100 + (i * 195), 200);
				buttons[i].repaint();
			}
		}

		
		
		User.repaint();
		Back.repaint();


	}

	class MyActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(GConstants.levelPlay.valueOf(e.getActionCommand())){
			case back: win.change(GConstants.SwitchPanel.selection.toString()); break;
			case one:
				if(GameMode == 0){
					play = new GPlay(win, 5, 1);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);
				}else{
					GConstants.GObject.addAll(GConstants.maps.get(0).getObject());
					editor = new GLevelEditor(win, 0);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case two:
				if(GameMode == 0){
					play = new GPlay(win, 5, 2);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(1).getObject());
					editor = new GLevelEditor(win, 1);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case three:
				if(GameMode == 0){
					play = new GPlay(win, 5, 3);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(2).getObject());
					editor = new GLevelEditor(win, 2);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case four:
				if(GameMode == 0){
					play = new GPlay(win, 5, 4);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(3).getObject());
					editor = new GLevelEditor(win, 3);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case five:
				if(GameMode == 0){
					play = new GPlay(win, 5, 5);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(4).getObject());
					editor = new GLevelEditor(win, 4);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case six:
				if(GameMode == 0){
					play = new GPlay(win, 5, 6);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(5).getObject());
					editor = new GLevelEditor(win, 5);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case seven:
				if(GameMode == 0){
					play = new GPlay(win, 5, 7);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(6).getObject());
					editor = new GLevelEditor(win, 6);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case eight:
				if(GameMode == 0){
					play = new GPlay(win, 5, 8);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(7).getObject());
					editor = new GLevelEditor(win, 7);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case nine:
				if(GameMode == 0){
					editor = new GLevelEditor(win, 8);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);

				}else{
					GConstants.GObject.addAll(GConstants.maps.get(8).getObject());
					editor = new GLevelEditor(win, 8);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				win.revalidate();
				win.repaint();
				break;
			case ten:
				if(GameMode == 0){
					play = new GPlay(win, 5, 10);
					win.getContentPane().removeAll();
					win.getContentPane().add(play);
					win.revalidate();
					win.repaint();
				}else{
					GConstants.GObject.addAll(GConstants.maps.get(9).getObject());
					editor = new GLevelEditor(win, 9);
					win.getContentPane().removeAll();
					win.getContentPane().add(editor);
				}
				break;
			default:
				break;
			}
		}
	}


}
