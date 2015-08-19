package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AlbumsOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openAlbums();
		
		
	}
	
	private void openAlbums() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.vivo.gallery/com.android.gallery3d.vivo.GalleryTabActivity");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //µÈ´ý5Ãë  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  			
	}
	

}
