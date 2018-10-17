package Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Vector;

import Constants.GConstants;
import Model.GCharacter;
import Model.MapLinkedList;

public class GMapManager {

	public void SaveMap(String Filename, boolean appends){
		MapLinkedList M = new MapLinkedList();
		M.setMapName("Map No."+GConstants.SMapNum);
		M.setObject( (Vector<GCharacter>) GConstants.GObject.clone());
		GConstants.maps.add(M);
		for(int i =0; i<GConstants.maps.size(); i++){
			GConstants.maps.get(i).UnLockLevel();
		}
		GConstants.SMapNum++;
		GConstants.GObject.clear();
		try {
			save(Filename, GConstants.maps, appends);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void LoadMap(String Filename){
		try {
			GConstants.maps = (LinkedList<MapLinkedList>) read(Filename);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static public void save(String fileName, Object object, boolean appends) throws IOException {
		FileOutputStream FileOutputStream = new FileOutputStream(fileName, appends);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(FileOutputStream);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
		objectOutputStream.writeObject(object);
		objectOutputStream.close();			
	}
	
	static public Object read(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}

}
