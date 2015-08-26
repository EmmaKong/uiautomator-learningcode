package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class baiduOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openBaidu();
		
		searchSomething("haha");
		sleep(3000);
		
		changeSkin(10); 
		
		getUiDevice().pressHome();
		
	}
	
	
    private void openBaidu() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.baidu.searchbox/.SplashActivity");

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
    
    private void searchSomething(String some) throws UiObjectNotFoundException{
    	UiObject searchBox = new UiObject(new UiSelector().resourceId("com.baidu.searchbox:id/baidu_searchbox"));
    	searchBox.clickAndWaitForNewWindow();
    	
    	UiObject searchInput = new UiObject(new UiSelector().resourceId("com.baidu.searchbox:id/SearchTextInput"));
    	searchInput.click();
    	
    	UiObject clearButton = new UiObject(new UiSelector().resourceId("com.baidu.searchbox:id/float_clear_content"));
    	if(clearButton.exists()){
    		clearButton.click();
    	}
    	searchInput.setText(some);
    	
    	UiObject searchOrCancel = new UiObject(new UiSelector().resourceId("com.baidu.searchbox:id/float_search_or_cancel"));
    	searchOrCancel.clickAndWaitForNewWindow();
    	
    	// uiautomator �޷�ʶ�� android.view.View ������
        UiObject searchContent = new UiObject(new UiSelector().className("android.view.View").index(0));
        searchContent.clickAndWaitForNewWindow();  // ���ҳ���м�λ��
       	
    	sleep(1000);
    	getUiDevice().pressBack();
    	getUiDevice().pressBack();
    	
    }
    
    private void changeSkin(int num) throws UiObjectNotFoundException{   // ������ߵ� num��
    	UiObject homeHeader = new UiObject(new UiSelector().resourceId("com.baidu.searchbox:id/home_header_container"));
    	UiObject skinIndi = homeHeader.getChild(new UiSelector().index(1).className("android.widget.ImageView"));
    	skinIndi.clickAndWaitForNewWindow();
    
    	for (int i = num; i > 0; i--){
    		
    		UiScrollable  skinCenter = new UiScrollable(new UiSelector().resourceId("com.baidu.searchbox:id/skin_center_gallery"));
        	skinCenter.setAsHorizontalList();
        	skinCenter.scrollBackward();
        	
        	sleep(1000); 	
    	}
    	sleep(1000);
    	UiObject applyButton = new UiScrollable(new UiSelector().resourceId("com.baidu.searchbox:id/skin_center_apply").clickable(true));
    	if(true){
    		
    		applyButton.click();
    	}
    	sleep(1000);
    	getUiDevice().pressBack();
    
    }
	

}
