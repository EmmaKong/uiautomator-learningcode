package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AlbumsOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openAlbums();
		
		scanGallery();
		
	}
	
	private void openAlbums() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.vivo.gallery/com.android.gallery3d.vivo.GalleryTabActivity");

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
	
	private void scanGallery() throws UiObjectNotFoundException{
		
		UiObject galleryTabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Photostabs = galleryTabs.getChild(new UiSelector().resourceId("com.vivo.gallery:id/tab_text").text("Photos"));
		if(!Photostabs.isSelected()){
			Photostabs.clickAndWaitForNewWindow();			
		}
		
		// uiautomatorviewer 无法识别相册内内容
		// 只能随意点击查看
		
		UiObject gallaryView = new UiObject(new UiSelector().resourceId("com.vivo.gallery:id/gl_root_view"));
		gallaryView.click();
		
		
		
		
		
	}
	
	

}
