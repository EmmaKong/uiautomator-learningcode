package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class iMusicOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openiMusic();
		UiObject nosongsIndicate = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/nosongtext"));
		if(nosongsIndicate.exists()){
			
			SearchandDownloadSong("See You Again");
			sleep(2000);
			
			
			SearchandDownloadSong("mygod");
			
			
			
			
		}
		
		
		
		
		
	}
	
	private void openiMusic() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.android.bbkmusic/.WidgetToTrackActivity");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //等待5秒  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  			
	}
	
	private void SearchandDownloadSong(String songname) throws UiObjectNotFoundException{
		
		UiObject iMusictabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject discover = iMusictabs.getChild(new UiSelector().index(4));
		discover.clickAndWaitForNewWindow();
		
		UiObject searchView = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/search_view"));	
		searchView.click();
		
		searchView.setText(songname);
		
        UiObject thesong = new UiObject(new UiSelector().text(songname)); 
        
        if(thesong.exists()){
        	System.out.println("Find the song: " + songname);
        	//使用getFromParent()方法 获取当前对象同级的 演唱者名字
        	UiObject aristname = thesong.getFromParent(new UiSelector().resourceId("com.android.bbkmusic:id/arist_name"));
        	System.out.println("The arist is: " + aristname);
        	thesong.clickAndWaitForNewWindow();
        	
        	
        	
        	
        	
        	UiObject cancelButton = new UiObject(new UiSelector().text("Cancel"));	
        	cancelButton.click();
        	
        	
        }else{
        	
        	UiObject listView = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/search_list_view"));
        	UiObject onesong = listView.getChild(new UiSelector().index(0));
        	UiObject downloadbutton = onesong.getChild(new UiSelector().resourceId("com.android.bbkmusic:id/more_layout"));
        	downloadbutton.click();
        	
       
        	UiObject cancelButton = new UiObject(new UiSelector().text("Cancel"));	
        	cancelButton.click();
        	
        	
        	
        }
		
		
		
		
		
	}
	
	

}
