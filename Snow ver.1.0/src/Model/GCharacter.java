package Model;

import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

import org.w3c.dom.css.Rect;

public class GCharacter implements Cloneable, Serializable{

	private int Life;
	private String Name;
	private ImageIcon Image;
	private int posX;
	private int posY;
	private int jump;
	private boolean selected = false;
	
	//getters and setters
	public int getLife() {return Life;}
	public void setLife(int life) {Life = life;}
	public String getName() {return Name;}
	public void setName(String name) {Name = name;}
	public ImageIcon getImage() {return Image;}
	public void setImage(ImageIcon image) {Image = image;}
	public int getPosX() {return posX;}
	public void setPosX(int posX) {this.posX = posX;}
	public int getPosY() {return posY;}
	public void setPosY(int posY) {this.posY = posY;}
	public int getJump() {return jump;}
	public void setJump(int jump) {this.jump = jump;}
	public void setselected(boolean selected) {this.selected = selected;}
	public boolean getselected(){return selected;}
	
	
	public void initkey(){
		this.posX = 50;
		this.posY = 490;
	}
	
	public void SetCharacter(String name, int x, int y, String URL){
		this.Name = name;
		this.posX = x;
		this.posY = y;
		this.Image = new ImageIcon(URL);
	}
	
	
	
}


