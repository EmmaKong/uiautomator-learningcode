package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class CameraOperation extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		openCamera();
		
		
		
		
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

}
