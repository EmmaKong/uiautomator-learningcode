package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class CameraOperation extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		openCamera();
		
		takePhotoWithModule("Beauty");
		sleep(2000);
		
		takeVideoWithTime(5);   // Â¼ÖÆ5Ãë
		
		getUiDevice().pressHome();
		
	}
	
	
	private void openCamera() throws UiObjectNotFoundException{
		
		try {
		    Runtime.getRuntime().exec("am start -n com.android.camera/.CameraActivity");
		       
		} catch (IOException e) {
			e.printStackTrace();		
		}
		//µÈ´ý »º³å
		try {  
		    Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
		    e1.printStackTrace();  
		}  	
	}
	
	private void takePhotoWithModule(String module) throws UiObjectNotFoundException{
		
		UiObject setting = new UiObject(new UiSelector().resourceId("com.android.camera:id/other_setting_indicator"));
		setting.clickAndWaitForNewWindow();
		
		UiObject gridView = new UiObject(new UiSelector().className("android.widget.GridView"));
		UiObject wantedmodule = gridView.getChild(new UiSelector().text(module));
		wantedmodule.clickAndWaitForNewWindow();
		
		UiObject shutterButton = new UiObject(new UiSelector().resourceId("com.android.camera:id/shutter_button").clickable(true));
		shutterButton.click();

		
	}
	
	private void takeVideoWithTime(int time) throws UiObjectNotFoundException{
		
		UiObject videoButton = new UiObject(new UiSelector().resourceId("com.android.camera:id/video_shutter_button"));
		videoButton.click();
		
		//UiObject recordingTime = new UiObject(new UiSelector().resourceId("com.android.camera:id/recording_time"));
		UiObject stopButton = new UiObject(new UiSelector().resourceId("com.android.camera:id/thumbnail_rotate"));
		sleep(time*1000);
		stopButton.click();
		
		getUiDevice().pressBack();
	
		
	}
		
}
