package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AppStoreOperation extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		 openAppstore();
		 DownloadOrOpen("QQ");
		 sleep(1000);
		 
		 DownloadOrOpen("TempleRun");
		 sleep(1000);
		 
		 updateApps();
		
		
	}
	
	
	private void openAppstore() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.bbk.appstore/.ui.AppStore");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //�ȴ�5��  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  			
	}
	
	private void DownloadOrOpen(String appname) throws UiObjectNotFoundException{
		
		 UiObject search = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/key_label"));
	     
	     search.setText(appname);	     
	     //�ȴ�3��  
	     try {  
	         Thread.sleep(3000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     
	     UiObject searchresult = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/package_list_item_info_layout"));
	     // ���� ���� �� ��  ��ť
	     UiObject downButton =  searchresult.getChild(new UiSelector().resourceId("com.bbk.appstore:id/download_status"));  
	     UiObject openButton =  searchresult.getChild(new UiSelector().resourceId("com.bbk.appstore:id/open_status")); 
	     if(downButton.exists()){
	    	 downButton.click();
	    	 
	    	 UiObject downloadContainer = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/download_container"));
	    	 downloadContainer.clickAndWaitForNewWindow();
	    	 
	    	 UiObject downloadingItems = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/downloading_item"));
	    	 UiObject downloadButton = downloadingItems.getChild(new UiSelector().index(5)); 
	    	 // ��ͣ
	         downloadButton.click();
	    	 
	    	//�ȴ�3��  
		     try {  
		         Thread.sleep(3000);  
		     } catch (InterruptedException e1) {  
		         e1.printStackTrace();  
		     }
	    	 // ����
		     downloadButton.click();
		     // ɾ��
		     UiObject indicator = downloadingItems.getChild(new UiSelector().index(6)); 
		     indicator.clickAndWaitForNewWindow();		     
		     UiObject downloadcancel = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/cancel_layout"));
		     downloadcancel.click();
		     
		     getUiDevice().pressBack();
		     getUiDevice().pressBack();	     
		     getUiDevice().pressBack();   // ��������ҳ��
		     	         	 
	     }else if(openButton.exists()){
	    	 openButton.click();
	    	 //�ȴ�10��  
		     try {  
		         Thread.sleep(10000);  
		     } catch (InterruptedException e1) {  
		         e1.printStackTrace();  
		     }
		     // ���� appstore
		     getUiDevice().pressBack();	     
		     getUiDevice().pressBack();  
	     }    		 
		
	}
	
	private void updateApps() throws UiObjectNotFoundException{
		UiObject updateNotice = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/update_noti_num"));
		if(updateNotice.exists()){
			// text�е����ݣ�ת��������
			int Num =  Integer.valueOf(updateNotice.getText()).intValue();
			System.out.println("The Number of apps needed to be upodated is: " + Num);
			
			updateNotice.clickAndWaitForNewWindow();
			UiObject updateNum = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/update_num"));
			updateNum.clickAndWaitForNewWindow();
			
			UiObject updateAll = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/update_all_layout"));
			updateAll.click();
			
		    UiObject updatedOk = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/common_dialog_positive_btn"));
		    updatedOk.click();
		    
		    UiObject downloadEntry = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/download_entry"));
		    downloadEntry.clickAndWaitForNewWindow();
		    
		    getUiDevice().pressBack();
		    getUiDevice().pressBack();
		    	    		
		}
			
		
	}
	
		

}

