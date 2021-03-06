package AutoRunner;

import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FilemanagerOperation extends UiAutomatorTestCase {
	
	//public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
	//	openFilemanager();
		
	//	deleteAllApks();
		
	//	getUiDevice().pressHome();
		
	//}
	
	UiDevice uiDevice;	
	// ���캯��
	public FilemanagerOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	void openFilemanager() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.android.filemanager/.FileManagerActivity");
	       
	     } catch (IOException e) {
				e.printStackTrace();		
	     }
	    //�ȴ� ����
	    try {  
	    	Thread.sleep(5000);  
	    } catch (InterruptedException e1) {  
	    	e1.printStackTrace();  
	    }  	
	    
	    System.out.println("Open Filemanager!");
	}
	
    void deleteAllApks() throws UiObjectNotFoundException{
		
		UiObject CatagoryItem = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/category_browse"));
		UiObject CategoryView = new UiObject(new UiSelector().className("android.widget.TextView").text("Category"));
		if(!CategoryView.exists()){
			CatagoryItem.click();
		}
	     
	    UiObject apksItem = new UiObject(new UiSelector().text("Apks"));
	    apksItem.clickAndWaitForNewWindow();
	    
	    UiObject noapks = new UiObject(new UiSelector().text("No apks"));
	    if(!noapks.exists()){
	     
	    	//UiObject apksListView = new UiObject(new UiSelector().className(ListView.class.getName()).resourceId("com.android.filemanager:id/category_listView")); 
	    
	    
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
	    	
	        System.out.println("Delete all Apk files!");
	    }else{
	    	
	    	System.out.println("There exists no Apk files!");
	    }
	    sleep(1000);
	    uiDevice.pressBack();
	   
	}
	
    void copyAllImages() throws UiObjectNotFoundException{
    	
    	UiObject CatagoryItem = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/category_browse"));
		UiObject CategoryView = new UiObject(new UiSelector().className("android.widget.TextView").text("Category"));
		if(!CategoryView.exists()){
			CatagoryItem.click();
		}
		
		UiObject imagesItems = new UiObject(new UiSelector().text("Images"));
		imagesItems.clickAndWaitForNewWindow();
		
		UiObject noimages = new UiObject(new UiSelector().text("No images"));
	    if(!noimages.exists()){
	    	    	
	    	//UiObject imagesListView = new UiObject(new UiSelector().className(ListView.class.getName()).resourceId("com.android.filemanager:id/category_listView")); 
		    
		    UiObject editButton = new UiObject(new UiSelector().className("android.widget.Button").text("Edit"));
		    editButton.click();
		    sleep(1000);
		    
		    UiObject allButton = new UiObject(new UiSelector().className("android.widget.Button").text("All"));
	    	allButton.click();
	    	
	    	UiObject copyButton = new UiObject(new UiSelector().className("android.widget.Button").text("Copy"));
	        copyButton.click();
	        sleep(1000);
	    	
	        UiObject pasteAll = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/parseBtn").text("Paste all"));
	        if(pasteAll.exists()){
	        	
	        	pasteAll.click();	        	
	        }
	        System.out.println("Copy all Image files!");
		    	
		}else{
			
			System.out.println("There exists no Image files!");
		}
	    sleep(1000);
	    uiDevice.pressBack();
		    	
    }
    

}

