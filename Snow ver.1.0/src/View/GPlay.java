package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.GConstants;
import Controller.GMapManager;
import Controller.KeyControl;
import Model.GCharacter;
import Model.MapLinkedList;
import View.GLevelEditor.GThread;
import View.GLevelEditor.MyActionListener;

public class GPlay extends JPanel {
	private MainFrame win;
	private String Filename;
	private JButton Back;
	private GThread Runner;
	private int level, Stage;
	private GMapManager mapmanager;
	
	public GPlay(MainFrame win, int Stage, int level){
		this.win = win;
		this.level = level;
		this.Stage = Stage;
		GConstants.key = new KeyControl();
		this.addKeyListener(GConstants.key);

		FileWho(Stage);
		mapmanager = new GMapManager();
		mapmanager.LoadMap(Filename);
		Runner = new GThread();
		Runner.start();
		GConstants.mouse.Floor();
		
		Back = new JButton();
		Back.setBorder(null);
		Back.setIcon(new ImageIcon("images/Back.png"));
		Back.setActionCommand(GConstants.levelPlay.back.toString());
		Back.addActionListener(new MyActionListener());
		Back.setContentAreaFilled(false);
		this.add(Back);

		for(int i=0; i<GConstants.maps.size(); i++){
			MapLinkedList maplist = new MapLinkedList();
			maplist = GConstants.maps.get(this.level-1);
		}
		GConstants.GObject = new Vector<GCharacter>();
		GConstants.GObject.addAll(GConstants.maps.get(this.level-1).getObject());
	}
	
	public void FileWho(int Stage){
		switch(Stage){
		case 1: Filename = "Stage1"; break;
		case 2: Filename = "Stage2"; break;
		case 3: Filename = "Stage3"; break;
		case 4: Filename = "Stage4"; break;
		case 5: Filename = "Stage5"; break;
		}
	}
	public void clear(){	
		GConstants.GObject.clear();
		if(level < 10){
			GConstants.maps.get(level).UnLockLevel();
		}
		try {
			GMapManager.save(Filename, GConstants.maps, false);
			mapmanager.LoadMap(Filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		win.change(Filename);
		Runner.stop();
	}
	
	@Override 
	public void paintComponent(Graphics g){ 
		this.requestFocusInWindow();
		this.setCursor(GConstants.c);
		g.clearRect(0, 0, getWidth(), getHeight());
		Back.setLocation(10, 10);	
		Back.repaint();
		
		g.drawImage(new ImageIcon("images/"+Filename+".jpg").getImage(), 0, 0, 
				GConstants.FrameWidth, GConstants.FrameHight, null);
		g.drawImage(new ImageIcon("images/Hero.png").getImage(), GConstants.key.getPositionX(), GConstants.key.getPositionY(), 50, 50, null);

		try{
			for(GCharacter e : GConstants.GObject) {
				g.drawImage(e.getImage().getImage(), e.getPosX(), e.getPosY(), 50, 50, null);
			}
		}catch(Exception e){}
		

		
	}
	class GThread extends Thread implements Runnable{
	
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
		        	if(GConstants.key.keyDraw() == 0){
					}else if(GConstants.key.keyDraw() == 1){
						GConstants.key.reset();
					}else if(GConstants.key.keyDraw() == 2){
						clear();
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
			switch(GConstants.levelPlay.valueOf(e.getActionCommand())){
			case back: 
				Runner.stop();
				GConstants.GObject.clear();
				win.change(Filename); break;
			default:
				break;
			}
		}
	}
}
