package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;
import android.widget.ListView;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FilemanagerOperation extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openFilemanager();
		
		deleteAllApks();
		
		getUiDevice().pressHome();
		
	}
	
	private void openFilemanager() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.android.filemanager/.FileManagerActivity");
	       
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
	
	private void deleteAllApks() throws UiObjectNotFoundException{
		
		UiObject CatagoryItem = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/category_browse"));
		UiObject CategoryView = new UiObject(new UiSelector().className("android.widget.TextView").text("Category"));
		if(!CategoryView.exists()){
			CatagoryItem.click();
		}
	     
	    UiObject apksItem = new UiObject(new UiSelector().text("Apks"));
	    apksItem.clickAndWaitForNewWindow();
	     
	    UiObject apksListView = new UiObject(new UiSelector().className(ListView.class.getName())); 
	    int apksNum = apksListView.getChildCount();
	    if(apksNum > 0){
	    	UiObject editButton = new UiObject(new UiSelector().className("android.widget.Button").text("Edit"));
	    	editButton.click();
	    	sleep(1000);
	    	
	    	UiObject allButton = new UiObject(new UiSelector().className("android.widget.Button").text("All"));
	    	allButton.click();
	    	
	    	UiObject deleteButton = new UiObject(new UiSelector().className("android.widget.Button").text("Delete"));
	        deleteButton.click();
	    	
	        UiObject deleteAlert = new UiObject(new UiSelector().resourceId("android:id/alertTitle").text("Delete"));
	        if(deleteAlert.exists()){
	        	UiObject Okbutton = new UiObject(new UiSelector().resourceId("android:id/button1").text("OK"));
	        	Okbutton.click();	        	
	        }
	    	
	    }
	    sleep(1000);
	    getUiDevice().pressBack();
	    
	     
		
		
	}
	
	

}




