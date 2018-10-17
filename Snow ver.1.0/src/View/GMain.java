package View;

import javax.swing.JFrame;

import Constants.GConstants;

public class GMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame win = new MainFrame();
		
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(GConstants.FrameWidth, GConstants.FrameHight);
        win.setVisible(true);
	    win.setResizable(false);
	}

}
