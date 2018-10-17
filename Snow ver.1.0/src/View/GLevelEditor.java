package View;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.GConstants;
import Controller.GMapManager;
import Controller.KeyControl;
import Controller.MouseControl;
import Model.GCharacter;
import Stages.GUser;
import View.GLevelSelect.MyActionListener;

public class GLevelEditor extends JPanel {
	private MainFrame win;
	private JButton Back, Save, Load;
	private JButton Box, Spike, Goal, Delete;
	private GThread Runner;
	private GMapManager mapmanager;
	private GUser User;
	private int LoadMap= -1;
	
	public GLevelEditor(MainFrame win){
		this.win = win;
		GConstants.GObject.clear();
		GConstants.key = new KeyControl();
		GConstants.mouse = new MouseControl();
		this.addKeyListener(GConstants.key);
		this.addMouseListener(GConstants.mouse);
		this.addMouseMotionListener(GConstants.mouse);
		mapmanager = new GMapManager();

		Runner = new GThread();
		Runner.start();
		GConstants.mouse.Floor();
		
		addButton();
	}
	
	public GLevelEditor(MainFrame win, int LoadMap){
		this.win = win;
		this.LoadMap = LoadMap;
		GConstants.key = new KeyControl();
		GConstants.mouse = new MouseControl();
		this.addKeyListener(GConstants.key);
		this.addMouseListener(GConstants.mouse);
		this.addMouseMotionListener(GConstants.mouse);
		mapmanager = new GMapManager();

		Runner = new GThread();
		Runner.start();
		GConstants.mouse.Floor();
		
		addButton();
	}
	
	public void addButton(){
		Back = new JButton();
		Back.setBorder(null);
		Back.setIcon(new ImageIcon("images/Back.png"));
		Back.setActionCommand(GConstants.LevelEditor.Back.toString());
		Back.addActionListener(new MyActionListener());
		Back.setContentAreaFilled(false);
		this.add(Back);
		
		Save = new JButton();
		Save.setBorder(null);
		Save.setIcon(new ImageIcon("images/Save.png"));
		Save.setActionCommand(GConstants.LevelEditor.Save.toString());
		Save.addActionListener(new MyActionListener());
		Save.setContentAreaFilled(false);
		this.add(Save);
		
		Load = new JButton();
		Load.setBorder(null);
		Load.setIcon(new ImageIcon("images/Load.png"));
		Load.setActionCommand(GConstants.LevelEditor.Load.toString());
		Load.addActionListener(new MyActionListener());
		Load.setContentAreaFilled(false);
		this.add(Load);
		
		Box = new JButton();
		Box.setBorder(null);
		Box.setIcon(new ImageIcon(GConstants.BoxURL));
		Box.setActionCommand(GConstants.LevelEditor.Box.toString());
		Box.addActionListener(new MyActionListener());
		Box.setContentAreaFilled(false);
		this.add(Box);
		
		Spike = new JButton();
		Spike.setBorder(null);
		Spike.setIcon(new ImageIcon("images/Spike.png"));
		Spike.setActionCommand(GConstants.LevelEditor.Spike.toString());
		Spike.addActionListener(new MyActionListener());
		Spike.setContentAreaFilled(false);
		this.add(Spike);
		
		Goal = new JButton();
		Goal.setBorder(null);
		Goal.setIcon(new ImageIcon("images/Goal.png"));
		Goal.setActionCommand(GConstants.LevelEditor.Goal.toString());
		Goal.addActionListener(new MyActionListener());
		Goal.setContentAreaFilled(false);
		this.add(Goal);
		
		Delete = new JButton();
		Delete.setBorder(null);
		Delete.setIcon(new ImageIcon("images/Delete.png"));
		Delete.setActionCommand(GConstants.LevelEditor.Delete.toString());
		Delete.addActionListener(new MyActionListener());
		Delete.setContentAreaFilled(false);
		this.add(Delete);

	}
	
	@Override 
	public void paintComponent(Graphics g){ 
		this.requestFocusInWindow();
		this.setCursor(GConstants.c);
		g.clearRect(0, 0, getWidth(), getHeight());
		Back.setLocation(10, 10);
		Save.setLocation(70, 10);
		Load.setLocation(130, 10);
		Box.setLocation(520, 10);
		Spike.setLocation(580, 10);
		Goal.setLocation(640, 10);
		Delete.setLocation(700, 10);
		
		Back.repaint();
		Save.repaint();
		Load.repaint();
		Box.repaint();
		Spike.repaint();
		Goal.repaint();
		Delete.repaint();
		
		g.drawImage(new ImageIcon(GConstants.BackgroundURL).getImage(), 0, 0, 
				GConstants.FrameWidth, GConstants.FrameHight, null);
		g.drawImage(new ImageIcon("images/Hero.png").getImage(), GConstants.key.getPositionX(), GConstants.key.getPositionY(), 50, 50, null);

		if(GConstants.mouse.getSelectedBlock() != null){
			g.drawImage(new ImageIcon("images/"+GConstants.mouse.getSelectedBlock()+"_OnMouse.png").getImage(), GConstants.mouse.getonX(), GConstants.mouse.getonY(), 50, 50, null);
		}
		try{
			for(GCharacter e : GConstants.GObject) {
				g.drawImage(e.getImage().getImage(), e.getPosX(), e.getPosY(), 50, 50, null);
			}
		}catch(Exception e){}
		

		
	}
	class GThread extends Thread implements Runnable{
	
		@SuppressWarnings("deprecation")
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
		        	if(GConstants.key.keyDraw() == 0){
						GConstants.mouse.mouseDraw();
					}else if(GConstants.key.keyDraw() == 1){
						GConstants.key.reset();
					}else{
						this.stop();
					}
					repaint();
		            GThread.sleep(40); 
		        }catch (Exception ex){ } 
			} 
		}
	}
	
	class MyActionListener implements ActionListener{
		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(GConstants.LevelEditor.valueOf(e.getActionCommand())){
			case Back: 
				Runner.stop();
				GConstants.GObject.clear();
				win.change(GConstants.SwitchPanel.Main.toString()); break;
			case Save: 
				if(LoadMap == -1){
					new GMapManager().SaveMap("Stage5", false);
				}else{
					try {
						new GMapManager();
						GMapManager.save("Stage5", GConstants.maps, false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Runner.stop();
				win.change(GConstants.SwitchPanel.selection.toString()); break;
			case Load: Runner.stop(); 
				User = new GUser(win, 1);
				win.getContentPane().removeAll();
				win.getContentPane().add(User);
				win.revalidate();
				win.repaint();
				break;
			case Box:  GConstants.mouse.SetSelectedBlock("Box"); break;
			case Spike: GConstants.mouse.SetSelectedBlock("Spike"); break;
			case Goal: GConstants.mouse.SetSelectedBlock("Goal"); break;
			case Delete: GConstants.mouse.SetSelectedBlock("Delete"); break;
			default:
				break;
			}
		}
	}
}
