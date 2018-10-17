package View;

import java.awt.Container;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Stages.GStage1;
import Stages.GStage2;
import Stages.GStage3;
import Stages.GStage4;
import Stages.GUser;
import Constants.GConstants;

public class MainFrame extends JFrame{
	private GMainview mainview;
	private GLevelSelect levelselect;
	private GLevelEditor leveleditor;
	private GStage1 Stage1;
	private GStage2 Stage2;
	private GStage3 Stage3;
	private GStage4 Stage4;
	private GUser User;
	
	public MainFrame(){
		
		mainview = new GMainview(this);
		levelselect = new GLevelSelect(this);
		this.addKeyListener(GConstants.key);
		
	    this.add(this.mainview);
	}
	
	public void change(String panelName){        // 패널 1번과 2번 변경 후 재설정
	    
		if(panelName.equals(GConstants.SwitchPanel.Main.toString())){
			getContentPane().removeAll();
			getContentPane().add(mainview);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.selection.toString())){

			getContentPane().removeAll();
			getContentPane().add(levelselect);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Stage1.toString())){
			Stage1 = new GStage1(this);
			getContentPane().removeAll();
			getContentPane().add(Stage1);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Stage2.toString())){
			Stage2 = new GStage2(this);
			getContentPane().removeAll();
			getContentPane().add(Stage2);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Stage3.toString())){
			Stage3 = new GStage3(this);
			getContentPane().removeAll();
			getContentPane().add(Stage3);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Stage4.toString())){
			Stage4 = new GStage4(this);
			getContentPane().removeAll();
			getContentPane().add(Stage4);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Stage5.toString())){
			User = new GUser(this, 0);
			getContentPane().removeAll();
			getContentPane().add(User);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.Option.toString())){
			getContentPane().removeAll();
			getContentPane().add(levelselect);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.MapEditor.toString())){
			getContentPane().removeAll();
			leveleditor = new GLevelEditor(this);
			getContentPane().add(leveleditor);
			revalidate();
			repaint();
		}else if(panelName.equals(GConstants.SwitchPanel.GameOver.toString())){
			System.exit(0);
		}
	}

}
