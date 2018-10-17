package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//import javax.media.Player;




import View.GLevelEditor.GThread;
import Constants.GConstants;
import Controller.MusicManager;

public class GMainview extends JPanel{
	private JButton Start, Editor, Exit;
	private MainFrame win;
	public GThread music;
	
	public GMainview(MainFrame win) {
		this.win = win;

		music = new GThread();
		music.start();
		
		Start = new JButton();
		Start.setBorder(null);
		Start.setIcon(new ImageIcon("images/START.png"));
		Start.setActionCommand(GConstants.SwitchPanel.selection.toString());
		Start.addActionListener(new MyActionListener());
		Start.setContentAreaFilled(false);
		this.add(Start);
		
		Editor = new JButton();
		Editor.setBorder(null);
		Editor.setIcon(new ImageIcon("images/MAPEDITOR.png"));
		Editor.setActionCommand(GConstants.SwitchPanel.MapEditor.toString());
		Editor.addActionListener(new MyActionListener());
		Editor.setContentAreaFilled(false);
		this.add(Editor);
		
		Exit = new JButton();
		Exit.setBorder(null);
		Exit.setIcon(new ImageIcon("images/EXIT.png"));
		Exit.setActionCommand(GConstants.SwitchPanel.GameOver.toString());
		Exit.addActionListener(new MyActionListener());
		Exit.setContentAreaFilled(false);
		this.add(Exit);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Start.setLocation(375, 200);
		Editor.setLocation(375, 300);
		Exit.setLocation(375, 400);
		g.drawImage(new ImageIcon(GConstants.MainBackgroundURL).getImage(), 0, 0,
				GConstants.FrameWidth, GConstants.FrameHight, null);
		Start.repaint();
		Editor.repaint();
		Exit.repaint();

	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(GConstants.SwitchPanel.valueOf(e.getActionCommand())){
			case selection: win.change(GConstants.SwitchPanel.selection.toString()); break;
			case Option: win.change(GConstants.SwitchPanel.Option.toString()); break;
			case MapEditor: win.change(GConstants.SwitchPanel.MapEditor.toString()); break;
			case GameOver: win.change(GConstants.SwitchPanel.GameOver.toString()); break;
			default:
				break;
			}

		}
		
	}
	
	class GThread extends Thread implements Runnable{
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
		    		MusicManager music = new MusicManager("Open");
		            GThread.sleep(30); 
		        }catch (Exception ex){ } 
			} 
		}
	}
	
}
