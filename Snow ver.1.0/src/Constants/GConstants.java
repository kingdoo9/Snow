package Constants;

import java.awt.Cursor;
import java.util.LinkedList;
import java.util.Vector;

import Controller.KeyControl;
import Controller.MouseControl;
import Model.GCharacter;
import Model.MapLinkedList;

public class GConstants {

	public static final int FrameWidth = 1050;
	public static final int FrameHight = 600;
	
	public static final int Speed = 5;
	public static final int Jump = 13;
	public static final int JumpCount = 2;
	
	public static int SMapNum = 1;
	public static int LMapNum = 1;
	
	public static final String ImageURL = "images/";
	public static final String MainBackgroundURL = "images/MainBackground.jpg";
	public static final String Background2URL = "images/background1.jpg";
	public static final String Stage1URL = "images/stage1.jpg";
	public static final String Stage2URL = "images/stage2.jpg";
	public static final String Stage3URL = "images/stage3.jpg";
	public static final String Stage4URL = "images/stage4.jpg";
	public static final String Stage5URL = "images/stage3.jpg";
	public static final String BackgroundURL = "images/background2.jpg";
	public static final String BoxURL = "images/Box1.png";
	public static enum SwitchPanel { Main, selection, Option, MapEditor, GameOver, Stage1, Stage2, Stage3, Stage4, Stage5};
	public static enum LevelSelect { Back, Stage1, Stage2, Stage3, Stage4, Stage5};
	public static enum levelPlay { one, two, three, four, five, six, seven, eight, nine, ten, back};
	public static enum LevelEditor { Back, Save, Load, Box, Spike, Goal, Delete};
	
	public static KeyControl key = new KeyControl();
	public static MouseControl mouse = new MouseControl();
	
	public static Vector<GCharacter> GObject = new Vector<GCharacter>();
	public static LinkedList<MapLinkedList> maps = new LinkedList<MapLinkedList>();
	public static Cursor c = new Cursor(0);
}
