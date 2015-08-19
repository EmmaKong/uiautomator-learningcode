package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class QQOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openQQ();
		
		
	}
	
private void openQQ() throws UiObjectNotFoundException{
		
		try {
		    Runtime.getRuntime().exec("am start -n com.tencent.mobileqq/.activity.SplashActivity");
		       
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
