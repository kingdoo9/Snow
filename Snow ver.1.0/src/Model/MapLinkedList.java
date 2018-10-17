package Model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Vector;

public class MapLinkedList implements Serializable{

	private boolean LockLevel = true;
	private String MapName;
	private Vector<GCharacter> Object;
	
	public String getMapName() {return MapName;}
	public void setMapName(String mapName) {MapName = mapName;}
	public Vector<GCharacter> getObject() {return Object;}
	public void setObject(Vector<GCharacter> object) {Object = object;}
	
	public void UnLockLevel(){this.LockLevel = false;}
	public boolean getLockLevel(){return this.LockLevel;}
	

	
}
