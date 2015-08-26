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
			
			System.out.println("There is no songs in this phone");
			SearchandDownloadSong("See You Again");
			sleep(1000);					
			SearchandDownloadSong("mygod");
			sleep(1000);
			SearchandDownloadSong("Better");
			sleep(1000);
			SearchandDownloadSong("You Raise Me Up");
			sleep(1000);
	    	SearchandDownloadSong("haha");
					
		}else{
			
			 SearchandPlaySong("hha");
			 sleep(1000);
			 SearchandPlaySong("Better");
			 
			 SearchandDownloadSong("Nothing");
			 
			 PlaySongRandomly(); 
			
		}
		
		getUiDevice().pressHome();
		
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
		sleep(2000);
		
		UiObject searchlistView = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/search_list_view"));	
		UiObject songlayout = searchlistView.getChild(new UiSelector().className("android.widget.FrameLayout"));
		
		UiObject thesong = songlayout.getChild(new UiSelector().text(songname));  
		
        if(thesong.exists()){
        	System.out.println("Find the song: " + songname);
        	//使用getFromParent()方法 获取当前对象同级的 演唱者名字
        	String aristname = thesong.getFromParent(new UiSelector().resourceId("com.android.bbkmusic:id/arist_name")).getText();       	
        	System.out.println("The arist is: " + aristname);
        	     	
        	UiObject downloadButton = songlayout.getChild(new UiSelector().resourceId("com.android.bbkmusic:id/more_layout"));
        	
        	downloadButton.click();
        	sleep(2000);
 
        	UiObject cancelButton = new UiObject(new UiSelector().text("Cancel"));	
        	cancelButton.click();
        	
        	
        }else{
        	// 取搜索列表中的第一项       	
        	UiObject onesong = searchlistView.getChild(new UiSelector().index(0));
        	String onesongname = onesong.getChild(new UiSelector().resourceId("com.android.bbkmusic:id/music_name")).getText();
        	System.out.println("Download a song: " + onesongname);
        	UiObject downloadbutton = onesong.getChild(new UiSelector().resourceId("com.android.bbkmusic:id/more_layout"));
        	downloadbutton.click();
        	
            sleep(2000);
        	UiObject cancelButton = new UiObject(new UiSelector().text("Cancel"));	
        	cancelButton.click();        	
        }	
		
	}
	
	private void PlaySongRandomly() throws UiObjectNotFoundException{  //随机播放
		UiObject iMusictabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Songs = iMusictabs.getChild(new UiSelector().text("Songs").resourceId("android:id/title"));
		Songs.clickAndWaitForNewWindow();
		
		UiObject shuffle = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/shuffer_text"));
		shuffle.click();
		
		getUiDevice().pressBack();
	
	}
	
	private void SearchandPlaySong(String songname) throws UiObjectNotFoundException{
		
		UiObject iMusictabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Songs = iMusictabs.getChild(new UiSelector().text("Songs").resourceId("android:id/title"));
		Songs.clickAndWaitForNewWindow();
		
		UiObject wantedsong = new UiObject(new UiSelector().text(songname));
		if(wantedsong.exists()){
			System.out.println("Find the song: " + songname);
			wantedsong.click();
			getUiDevice().pressBack();
		}else{
			System.out.println("Cannot find the song: " + songname);
		}
		
		
		
	}
	

}
