
package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class test extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		// 获取屏幕大小
		//int height = getUiDevice().getDisplayHeight();
		//int width = getUiDevice().getDisplayWidth();
	
		//getUiDevice().swipe(width-10, height/2, 10, height/2, 2); 
		
		// 打开 蘑菇街
	     try {
	         Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
	    	
	     } catch (IOException e) {
				e.printStackTrace();
				
	     }
	    
	}
}
