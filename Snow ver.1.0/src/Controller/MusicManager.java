package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusicManager {
	public static Mixer mixer;//¹Í¼­ Ãß°¡
	public static Clip clip;
	
	public MusicManager(String MusicName){
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = (Info) new DataLine.Info(Clip.class, null);
		try{ clip = (Clip)mixer.getLine(dataInfo); }
		catch(LineUnavailableException lue) {lue.printStackTrace();}
		try
		{
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audios/Open.wav"));
			clip.open(audioStream);
		}
		catch(LineUnavailableException lue) {lue.printStackTrace();}
		catch(UnsupportedAudioFileException uafe){ uafe.printStackTrace();}
		catch(IOException ioe){ ioe.printStackTrace();}
		clip.start();
		do
		{
			try{ Thread.sleep(50); }
			catch(InterruptedException ie) {ie.printStackTrace();}
			
		}while(clip.isActive());
	}

}
