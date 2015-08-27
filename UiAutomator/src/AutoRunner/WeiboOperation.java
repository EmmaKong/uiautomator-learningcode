package AutoRunner;

import java.io.IOException;




import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class WeiboOperation extends UiAutomatorTestCase {
	/*
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
			
			
		openWeibo();
			 
	    update();
			 
		scanHomepage();
			 
		scanFriendcircle();
		
		scanMyWeibo();
		
		shareSomething();
		
		clearCache();
		
		getUiDevice().pressHome();
					
	}
*/

	UiDevice uiDevice;	
	// ���캯��
	public WeiboOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	void openWeibo() throws UiObjectNotFoundException{
			
		try {
		    Runtime.getRuntime().exec("am start -n com.sina.weibo/.SplashActivity");
		       
		} catch (IOException e) {
			e.printStackTrace();		
		}
		//�ȴ� ����
		try {  
		    Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
		    e1.printStackTrace();  
		}  	
		
		System.out.println("Open Weibo!");
	}
		
	void update() throws UiObjectNotFoundException{
		//��ȡ��Ļ��С
		int height = uiDevice.getDisplayHeight();
		int width = uiDevice.getDisplayWidth();	
		// ˢ��
		UiObject weiboHome = new UiObject(new UiSelector().description("Home"));
	    weiboHome.clickAndWaitForNewWindow();
			 
		// ����ˢ��
	    uiDevice.swipe(width/2, 100, width/2, height-100, 5);
		//�ȴ�5��  
		try {  
			Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
			e1.printStackTrace();  
	    }          
	}
		
	void scanHomepage() throws UiObjectNotFoundException{
		
		int width = uiDevice.getDisplayWidth();
			
		UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));	
		rltitlemiddle.click();
			
	//	UiObject Homepage = new UiObject(new UiSelector().text("Homepage"));
	//	Homepage.clickAndWaitForNewWindow();
		sleep(2000);
		uiDevice.click(width/2, 250);
		
		UiScrollable listview = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser").scrollable(true));
		if(listview.exists()){
				
			//listview.scrollForward(); // һֱ���»���ͣ������
			//listview.scrollForward(100);
			listview.scrollIntoView(new UiObject(new UiSelector().textContains("chuby1tubby")));					
		}
		
		sleep(2000);
		
	}
		
	void scanFriendcircle() throws UiObjectNotFoundException{
		
		int width = uiDevice.getDisplayWidth();
			
		UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));	
		rltitlemiddle.click();
			
		//UiObject Friendcircle = new UiObject(new UiSelector().text("Friends Circle"));
		//Friendcircle.clickAndWaitForNewWindow();
		sleep(2000);
		uiDevice.click(width/2, 370);
				
		UiScrollable listview = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser").scrollable(true));
		if(listview.exists()){	
			listview.scrollIntoView(new UiObject(new UiSelector().textContains("Asura_Girl")));
			// ���¹�����֪������ ������ Asural_Girl�������ı�		
			
		}
		
		sleep(2000);	
	}
	
	
	void scanMyWeibo() throws UiObjectNotFoundException{
	
		int width =uiDevice.getDisplayWidth();
			
		UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));		
		rltitlemiddle.click();
			
		//UiObject Myweibo = new UiObject(new UiSelector().text("My Weibo"));
		//Myweibo.clickAndWaitForNewWindow();
		sleep(2000);
		uiDevice.click(width/2, 575);
		
		UiScrollable listView = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser"));
		if(listView.exists()){
			
			//listView.scrollForward();    // �׳��쳣��why?
			// ��������
			listView.scrollIntoView(new UiObject(new UiSelector().textContains("Oh Yeah")));
			
		}
		sleep(2000);
			
	}
	
	void shareSomething() throws UiObjectNotFoundException{
		UiObject share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rl_composer"));
	    if(share.exists()){
	    	share.clickAndWaitForNewWindow();
	    	UiObject sharebytext = new UiObject(new UiSelector().text("Text"));
	    	sharebytext.clickAndWaitForNewWindow();
	    	
	    	UiObject editView = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/edit_view").className("android.widget.EditText"));
	    	editView.setText("JUST FOR TESTING!");
	    	
	    	UiObject sendButton = new UiObject(new UiSelector().text("Send").enabled(true));
	    	if(true){
	    		sendButton.clickAndWaitForNewWindow();
	    	}
		 
	    }
		
	}
	
	void clearCache() throws UiObjectNotFoundException{
		
		UiObject weiboProfile = new UiObject(new UiSelector().description("Profile"));
	    weiboProfile.clickAndWaitForNewWindow();
		 
		UiObject weiboSettings = new UiObject(new UiSelector().description("Settings"));
		weiboSettings.clickAndWaitForNewWindow();
		 
		UiObject clearcache  = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/cleanCacheLayout"));
		clearcache.clickAndWaitForNewWindow();  
		 
		UiObject clearOk  = new UiObject(new UiSelector().text("OK"));
		if(clearOk.exists()){
			clearOk.click();  
			sleep(2000);
		}
		uiDevice.pressBack();
		
	}
	
	
	
	
}
