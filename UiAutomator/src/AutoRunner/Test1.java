package AutoRunner;

//import android.widget.RelativeLayout;
import android.widget.TextView;
//import android.widget.LinearLayout;
import android.widget.ListView;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class Test1 extends UiAutomatorTestCase {
	 public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		 
		 getUiDevice().pressHome(); 
		 
		 UiScrollable appview = new UiScrollable (new UiSelector().scrollable(true));
	     appview.setAsHorizontalList();
	     int appNum = appview.getChildCount();
	     System.out.println("The Number of horizontal view: " + appNum);
	     
		 UiObject settingApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()), "Settings");
		 settingApp.clickAndWaitForNewWindow();
		
	     
	     UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));  
	     
	     UiObject vivoiceItem = settingItems.getChildByText(new UiSelector().text("vivoice"), "vivoice", true);  
	     vivoiceItem.clickAndWaitForNewWindow();
	     getUiDevice().pressBack();  
	     getUiDevice().pressHome(); 
	     
	     
	     UiObject FileManagerApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()), "File Manager");
		 FileManagerApp.clickAndWaitForNewWindow();
	     
	     UiObject CatagoryItem = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/category_browse"));
	     CatagoryItem.click();
	     
	     UiObject apksItem = new UiObject(new UiSelector().text("Apks"));
	     apksItem.clickAndWaitForNewWindow();
	     
	     UiObject apksListView = new UiObject(new UiSelector().className(ListView.class.getName())); 
	     
	     UiObject firstItem = apksListView.getChild(new UiSelector().index(0));
	    
	     firstItem.clickAndWaitForNewWindow();
	     UiObject cancelBut = new UiObject(new UiSelector().text("Cancel"));
	     cancelBut.click();
	     getUiDevice().pressBack();
	  
	     getUiDevice().pressHome(); 
	        
	   //  UiObject weiboApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()),"");
		// weiboApp.clickAndWaitForNewWindow();
		 getUiDevice().pressHome(); 
		 
	     
	     
	 
	 }

}
