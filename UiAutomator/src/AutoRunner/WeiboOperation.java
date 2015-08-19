package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class WeiboOperation extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
			
			
		openWeibo();
			 
	    update();
			 
		scanHomepage();
			 
		//scanFriendcircle();
		
		//scanMyWeibo();
		shareSomething();
		
		clearCache();
		
		
		
		
			
	}

		
	private void openWeibo() throws UiObjectNotFoundException{
			
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
	}
		
	private void update() throws UiObjectNotFoundException{
		//��ȡ��Ļ��С
		int height = getUiDevice().getDisplayHeight();
		int width = getUiDevice().getDisplayWidth();	
		// ˢ��
		UiObject weiboHome = new UiObject(new UiSelector().description("Home"));
	    weiboHome.clickAndWaitForNewWindow();
			 
		// ����ˢ��
	    getUiDevice().swipe(width/2, 100, width/2, height-100, 5);
		//�ȴ�5��  
		try {  
			Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
			e1.printStackTrace();  
	    }          
	}
		
	private void scanHomepage() throws UiObjectNotFoundException{
			
	//	UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));
			
	//	rltitlemiddle.click();
			
	//	UiObject Homepage = new UiObject(new UiSelector().text("Homepage"));
	//	Homepage.clickAndWaitForNewWindow();
		UiScrollable listview = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser").scrollable(true));
		if(listview.exists()){
			while(true){
				
				//listview.scrollForward(); // һֱ���»���ͣ������
				
				listview.scrollIntoView(new UiObject(new UiSelector().textContains("chuby1tubby")));				
				break;  //  ����ѭ��
				
			}
			
			
		}
		
		sleep(2000);
		
	}
		
	private void scanFriendcircle() throws UiObjectNotFoundException{
		UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));
			
		rltitlemiddle.click();
			
		UiObject Friendcircle = new UiObject(new UiSelector().text("Friends Circle"));
		Friendcircle.clickAndWaitForNewWindow();
		
		UiScrollable listview = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser").scrollable(true));
		if(listview.exists()){
			while(true){
				
				listview.scrollIntoView(new UiObject(new UiSelector().textContains("Asural_Girl")));
				// ���¹�����֪������ ������ Asural_Girl�������ı�			
			}	
		}
		
			
	}
	
	
	private void scanMyWeibo() throws UiObjectNotFoundException{
		UiObject rltitlemiddle = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitlemiddle"));
			
		rltitlemiddle.click();
			
		UiObject Myweibo = new UiObject(new UiSelector().text("My Weibo"));
		Myweibo.clickAndWaitForNewWindow();
		
		UiScrollable listview = new UiScrollable(new UiSelector().resourceId("com.sina.weibo:id/lvUser").scrollable(true));
		if(listview.exists()){
			while(true){
				
				listview.scrollForward();  // ��������
			
			}
			
			
		}
			
	}
	
	private void shareSomething() throws UiObjectNotFoundException{
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
	
	private void clearCache() throws UiObjectNotFoundException{
		
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
		getUiDevice().pressBack();
		
	}
	
	
	
	
}