package AutoRunner;

import java.io.IOException;

//import android.os.RemoteException;


import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class WeichatOperation extends UiAutomatorTestCase {
	/*
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openWeiChat();
		
		readUnreadmsg();
		
		scanMyPosts();
		
		scanFriendCircle(10);
		
		saySomething("JUST FOR TESTING!");
		
		readUnreadSubscription(); 
		
	}
	*/
	
	UiDevice uiDevice;	
	// 构造函数
	public WeichatOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	void openWeiChat() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.tencent.mm/.ui.LauncherUI");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //等待5秒  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  	
	     
	     System.out.println("Open Weichat!");
	}
	
	void update() throws UiObjectNotFoundException{
		//获取屏幕大小
		int height = uiDevice.getDisplayHeight();
		int width = uiDevice.getDisplayWidth();	
			 
		// 下拉刷新
		uiDevice.swipe(width/2, 500, width/2, height-500, 50);
		//等待2秒  
		try {  
			Thread.sleep(2000);  
		} catch (InterruptedException e1) {  
			e1.printStackTrace();  
	    }          
	}
	
	void OptIn() throws UiObjectNotFoundException{  // 点赞
		UiObject bqf = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/bqf").description("Comment"));
		bqf.click();
		sleep(2000);
		UiObject bpt = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/bpt"));	
		UiObject cancel = new UiObject(new UiSelector().text("Cancel"));
		if(!cancel.exists()){
			bpt.click();
			System.out.println("Opt in");
		}	
	}
	
	void scanMyPosts() throws UiObjectNotFoundException{
		// 进入 my posts 两种方法
		UiObject Me = new UiObject(new UiSelector().text("Me"));
		UiObject  profile_photo = new UiObject(new UiSelector().descriptionContains("my profile photo"));
		if(Me.exists()){
			Me.clickAndWaitForNewWindow();
		
			UiObject Myposts = new UiObject(new UiSelector().text("My Posts").resourceId("android:id/title"));
			Myposts.click();
						
		}else if(profile_photo.exists()){
			profile_photo.clickAndWaitForNewWindow();		
		}
		
		UiObject aqi = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/aqi"));  //边界线
		UiScrollable ListView = new UiScrollable(new UiSelector().resourceId("com.tencent.mm:id/bqu").scrollable(true));
		while(true){
			ListView.scrollForward();
			if(aqi.exists()){
				break;
			}
		}
		
		uiDevice.pressBack();
		
	}
	
	void saySomething(String some) throws UiObjectNotFoundException{    // 发表
		
		UiObject discover = new UiObject(new UiSelector().text("Discover"));
		
		UiObject MomentsTitle = new UiObject(new UiSelector().text("Moments").resourceId("android:id/text1"));
		
		if(discover.exists()){
			discover.clickAndWaitForNewWindow();
			
			UiObject Moments = new UiObject(new UiSelector().text("Moments"));
			Moments.clickAndWaitForNewWindow();	
			sleep(2000);
			
			UiObject SharePhoto = new UiObject(new UiSelector().description("Share Photo"));
			SharePhoto.longClick();
			
		}else if(MomentsTitle.exists()){
			
			UiObject SharePhoto = new UiObject(new UiSelector().description("Share Photo"));
			SharePhoto.longClick();	
		}
		
		UiObject textView = new UiObject(new UiSelector().className("android.widget.EditText"));
		textView.click();
		textView.setText(some);
		
		UiObject sendButton = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/ee").text("Send"));
		sendButton.click();
		sleep(1000);
		
		uiDevice.pressBack();
		
	}
	
    void sendMessage(String message) throws UiObjectNotFoundException{
		
		UiObject messageEdit = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/u6"));
		messageEdit.click();
		messageEdit.setText(message);
		sleep(1000);
		
		UiObject sendButton = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/ub").text("Send"));
		if(sendButton.exists()){
			sendButton.click();		
		}	
		System.out.println("Send a message successfully!");
		uiDevice.pressBack();
		
	}
	
	void scanFriendCircle(int num) throws UiObjectNotFoundException{
		UiObject discover = new UiObject(new UiSelector().text("Discover"));
		discover.clickAndWaitForNewWindow();
		
		UiObject Moments = new UiObject(new UiSelector().text("Moments"));
		Moments.clickAndWaitForNewWindow();
		
		update();
		
		scanMyPosts();
		
		OptIn();
		
		UiScrollable Listview = new UiScrollable(new UiSelector().resourceId("com.tencent.mm:id/bqu").className("android.widget.ListView").scrollable(true));
		
		if(Listview.exists()){
			while(true){
				for(int i = num; i>0; i--){
					Listview.scrollForward(); 
					sleep(1000);
				
				}
				break;
			
			}
		}
		sleep(2000);
		// 返回顶端
		for(int i = num; i>0; i--){
			Listview.scrollBackward();	
		}
		uiDevice.pressBack();
		
	}
	
	void readUnreadmsg() throws UiObjectNotFoundException{
				
		UiObject chats = new UiObject(new UiSelector().text("Chats"));
	    chats.clickAndWaitForNewWindow();
	
		UiObject recentchatList = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/aw6"));
		int numofchat = recentchatList.getChildCount();
		
		for(int i = 0; i < numofchat; i++){
			
			sleep(2000);
			UiObject messageLayout = recentchatList.getChild(new UiSelector().className("android.widget.LinearLayout").
					resourceId("com.tencent.mm:id/a4s").index(i + 6));			
			UiObject unreadIndi_sub = messageLayout.getChild(new UiSelector().resourceId("com.tencent.mm:id/a4t"));	
			UiObject Subscription = messageLayout.getChild(new UiSelector().text("Subscription Accounts"));
			if(Subscription.exists()){  //订阅号信息
				if(unreadIndi_sub.exists()){
					System.out.println("There is unread Subscription!");
					unreadIndi_sub.clickAndWaitForNewWindow();
					sleep(2000);	
					uiDevice.pressBack();
									
				}						
			}else{
				UiObject unreadIndi = messageLayout.getChild(new UiSelector().resourceId("com.tencent.mm:id/g2"));
				if(unreadIndi.exists()){
					unreadIndi.clickAndWaitForNewWindow();
					
					UiScrollable messageListView = new UiScrollable(new UiSelector().resourceId("com.tencent.mm:id/tk").scrollable(true));
					if(messageListView.exists()){
						while(true){
							messageListView.scrollBackward();
							sleep(1000);
							UiObject timestamp = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/ac"));
							if(timestamp.exists()){
								System.out.println("I have read the messages");
								break;  // 退出循环
							}	
						}
					}
					
					sendMessage("hahaha!");
					sleep(1000);
					uiDevice.pressBack();
					
				}			
				
			}	
			
		}
				
	}
	
	
	void readUnreadSubscription() throws UiObjectNotFoundException{   // 阅读 订阅号
		
		UiObject chats = new UiObject(new UiSelector().text("Chats"));
	    chats.clickAndWaitForNewWindow();
	    UiObject recentchatList = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/aw6"));
	    UiObject messageLayout = recentchatList.getChild(new UiSelector().className("android.widget.LinearLayout").
	    		resourceId("com.tencent.mm:id/a4s"));			
		UiObject Subscription = messageLayout.getChild(new UiSelector().text("Subscription Accounts"));
	
		if(Subscription.exists()){  // 订阅号信息
			
			Subscription.clickAndWaitForNewWindow();	
			sleep(1000);
			
			UiObject SubListView = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/bvl"));				
		    if(SubListView.exists()){
		    	int numofsub = SubListView.getChildCount();
		    	System.out.println("There are " + numofsub + " Subscriptions!");
				for(int i = 0; i < numofsub; i++){
					UiObject subLayout = SubListView.getChild(new UiSelector().className("android.widget.LinearLayout").
							resourceId("com.tencent.mm:id/a4s").index(i));			
					UiObject unreadIndiSub = subLayout.getChild(new UiSelector().resourceId("com.tencent.mm:id/g2"));	
					if(unreadIndiSub.exists()){
						subLayout.clickAndWaitForNewWindow();
						
						sleep(2000);
						
						
						
						
						
						
						uiDevice.pressBack();
								
					}
										
				}		
					
			}
		    
		    uiDevice.pressBack();			
		}		
	}
	
	


}
