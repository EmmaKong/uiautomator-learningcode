package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class baiduOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openBaidu();
		
		
	}
	
	
    private void openBaidu() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.baidu.searchbox/.SplashActivity");

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
