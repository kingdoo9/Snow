package Controller;

import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import Constants.GConstants;
import Model.GCharacter;
import Model.MapLinkedList;

public class MouseControl extends MouseInputAdapter{
	private int x, y, onX, onY;
	private boolean mouse_left_click = false;
	private boolean Override = false;
	private String Selected_Block;
	private Point onMouse;
	private PointerInfo MouseInfor;

	public int getonX(){return onX;}
	public int getonY(){return onY;}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			if(e.getY() <= 60);
			else if(Selected_Block != null){
				mouse_left_click = true;
				x = e.getX();
				y = e.getY();
				x = SnapToGridX(x);
				y = SnapToGridY(y);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		for(GCharacter object : GConstants.GObject){
			if(object.getselected() == true){
				int x = e.getX();
				int y = e.getY();
				x = SnapToGridX(x);
				y = SnapToGridY(y);
				
				for(GCharacter Obobject : GConstants.GObject){
					if(Obobject.getPosX() == x && Obobject.getPosY() == y){
						Override = true;
						break;
					}
				}
				if(Override == false){
					object.setPosX(x);
					object.setPosY(y);
				}
				GConstants.c = new Cursor(0);
				object.setselected(false);
			}
			Override = false;
		}

	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(Selected_Block != null){
			onX = SnapToGridX(e.getX());
			onY = SnapToGridY(e.getY());
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		for(GCharacter object : GConstants.GObject){
			if(e.getX() > object.getPosX() && e.getX() < object.getPosX()+50){
				if(e.getY() > object.getPosY() && e.getY() < object.getPosY()+50){
					GConstants.c = new Cursor(13);
					object.setselected(true);
					Selected_Block = object.getName();
				}
			}
		}
		
	}
	public void SetSelectedBlock(String GameObject){
		this.Selected_Block = GameObject;
	}
	public String getSelectedBlock(){ return Selected_Block;}
	
	public void mouseDraw(){
		
		if(mouse_left_click){
			for(GCharacter object : GConstants.GObject){
				if(object.getPosX() == x && object.getPosY() == y){
					Override = true;
					break;
				}
			}
			if(Override == false){
				if(Selected_Block.equals("Box")){
					GCharacter Obs = new GCharacter();
					Obs.SetCharacter("Box", x, y, GConstants.BoxURL);
					GConstants.GObject.add(Obs);
					mouse_left_click = false;
				
				}else if(Selected_Block.equals("Spike")){
					GCharacter Obs = new GCharacter();
					Obs.SetCharacter("Spike", x, y, GConstants.ImageURL+"Spike.png");
					GConstants.GObject.add(Obs);
					mouse_left_click = false;
				}else if(Selected_Block.equals("Goal")){
					GCharacter Obs = new GCharacter();
					Obs.SetCharacter("Goal", x, y, GConstants.ImageURL+"Goal.png");
					GConstants.GObject.add(Obs);
					mouse_left_click = false;
				}
			}else if(Selected_Block.equals("Delete")){
				for(GCharacter object : GConstants.GObject){
					if(x == object.getPosX() && y == object.getPosY()){
							GConstants.GObject.remove(object);
					}
				}
				mouse_left_click = false;
			}
			Override = false;
		}
	}
	
	public void Floor(){
		for(int i=-100; i<1050; i+=50){
			GCharacter Obs = new GCharacter();
			Obs.SetCharacter("box", i, 550, GConstants.BoxURL);
			GConstants.GObject.add(Obs);
		}
	}
	
	public int SnapToGridX(double x){ // MapEditor에서 block들을 열에 맞게 설정하는 함수.
		for(int i=0; i<1050; i+=50){
			if(x <= i+50 && x >= i){
				x = i;
			}
		}
		return (int) x;
	}
	public int SnapToGridY(double y){
		for(int i=0; i<600; i+=50){
			if(y <= i+50 && y >= i){
				y = i;
			}
		}
		return (int) y;
	}
}

