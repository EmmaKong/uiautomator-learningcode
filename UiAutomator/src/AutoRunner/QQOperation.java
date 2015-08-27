package AutoRunner;

import java.io.IOException;

//import android.os.RemoteException;



import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class QQOperation extends UiAutomatorTestCase {
	/*
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openQQ();
		
		update();
		
		readUnreadmsg();
		
		scanQQZone();
		
		accountSetting();
		
		addsomeone("772097770");
		
		getUiDevice().pressHome();
		
	}
	*/
	
	UiDevice uiDevice;	
	// 构造函数
	public QQOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	void openQQ() throws UiObjectNotFoundException{
		
		try {
		    Runtime.getRuntime().exec("am start -n com.tencent.mobileqq/.activity.SplashActivity");
		       
		} catch (IOException e) {
			e.printStackTrace();		
		}
		//等待 缓冲
		try {  
		    Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
		    e1.printStackTrace();  
		}  	
		
		System.out.println("Open MobileQQ!");
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
	
	void readUnreadmsg() throws UiObjectNotFoundException{
		UiObject QQtabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
				
		UiObject message = QQtabs.getChild(new UiSelector().index(0).className("android.widget.RelativeLayout"));
		if(!message.isSelected()){
			message.clickAndWaitForNewWindow();
		}
		
		UiObject recentchatList = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/recent_chat_list"));
		
		int numofchat = recentchatList.getChildCount();
		recentchatList.swipeDown(1);
		if(numofchat > 1){  // 搜索框，index为0
			for(int i = 1; i < numofchat; i++){
			
				sleep(1000);
				UiObject messageLayout = recentchatList.getChild(new UiSelector().className("android.widget.LinearLayout").index(i));			
				UiObject unreadIndi = messageLayout.getChild(new UiSelector().resourceId("com.tencent.mobileqq:id/unreadmsg"));
				
				if(unreadIndi.exists()){
					System.out.println("The "+i+"th unread message list");	
					messageLayout.clickAndWaitForNewWindow();
				
					UiScrollable messageListView = new UiScrollable(new UiSelector().resourceId("com.tencent.mobileqq:id/listView1").scrollable(true));
					if(messageListView.exists()){
						while(true){
							messageListView.scrollBackward();
							sleep(1000);
							UiObject timestamp = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/chat_item_time_stamp"));
							if(timestamp.exists()){
								System.out.println("I find it");	
								break;  // 退出循环
							}	
						}
					}
					uiDevice.pressBack();
							
				}		
			
			}		
		}else{
			System.out.println("There exists no unread messages!");	
		}
				
	}
	
	
	void scanRelatedwithMe(int num) throws UiObjectNotFoundException{   // num 控制浏览长度
		
		UiObject qzoneMenu = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.LinearLayout").index(3));
		
		UiObject relatedwithMe = qzoneMenu.getChild(new UiSelector().index(3).resourceId("com.tencent.mobileqq:id/name"));
		relatedwithMe.clickAndWaitForNewWindow();
		
		update();
		UiScrollable relatedwithMemainView = new UiScrollable(new UiSelector().resourceId("com.tencent.mobileqq:id/name").scrollable(true));
		if(relatedwithMemainView.exists()){
			while(true){
				for(int i = num; i>0; i--){
					relatedwithMemainView.scrollForward();   // 遇到 缓存没缓过来的，就停了。。。
					sleep(1000);
				
				}
				break;
			
			}
		}
		uiDevice.pressBack();
		
	}
	
	void saySomething(String some) throws UiObjectNotFoundException{    // 发表说说
		
		UiObject QzoneTitle = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.RelativeLayout").clickable(true));
		
		UiObject sendSomethingButton = QzoneTitle.getChild(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.LinearLayout").clickable(true));
		sendSomethingButton.click();
		
		UiObject popMenu = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.LinearLayout").clickable(true).packageName("com.tencent.mobileqq"));
		UiObject Something = popMenu.getChild(new UiSelector().index(0).className("android.widget.LinearLayout").clickable(true));
		Something.clickAndWaitForNewWindow();
		
		UiObject textView = new UiObject(new UiSelector().className("android.widget.EditText"));
		textView.click();
		textView.setText(some);
		
		UiObject sendButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnRightText"));
		sendButton.click();
		
		uiDevice.pressBack();
		
	}
	
	void scanMainzone(int num) throws UiObjectNotFoundException{   // num 控制浏览长度
		
		UiScrollable Mainview = new UiScrollable(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.view.View").scrollable(true));
		
		if(Mainview.exists()){
			while(true){
				for(int i = num; i>0; i--){
					Mainview.scrollForward(); 
					sleep(1000);
				
				}
				break;
			
			}
		}
		sleep(2000);
		// 返回顶端
		for(int i = num; i>0; i--){
			Mainview.scrollBackward();	
		}
				
	}
	
	
	
	void scanQQZone() throws UiObjectNotFoundException{
		UiObject QQtabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		
		UiObject dynamic = QQtabs.getChild(new UiSelector().index(2).className("android.widget.FrameLayout"));
		if(!dynamic.isSelected()){
			dynamic.clickAndWaitForNewWindow();
			sleep(1000);
		}
		
		UiObject qZoneEntry = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/qzone_feed_entry"));
		qZoneEntry.clickAndWaitForNewWindow();
	
		update();   // 下拉刷新
		sleep(2000);
		
		scanRelatedwithMe(10);
		sleep(1000);
		
		scanMainzone(10); 
		sleep(1000);
		
		saySomething("JUST FOR TESTING!");
	
		
	}
	
	void accountSetting() throws UiObjectNotFoundException{ 
		
		UiObject settingEntry = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/conversation_head"));
		settingEntry.click();
		sleep(1000);
		
		UiObject settingButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/settings"));
		settingButton.clickAndWaitForNewWindow();
		
		// 改变登录状态
		UiObject accountSwitch = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/account_switch"));
		accountSwitch.clickAndWaitForNewWindow();
		
		UiObject online = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.RelativeLayout").index(4));
		UiObject nowstate0 = online.getChild(new UiSelector().index(1));  // 在线
		UiObject hiding = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.RelativeLayout").index(5));
		UiObject nowstate1 = hiding.getChild(new UiSelector().index(1));  // 隐身
		if(nowstate0.exists()){
			hiding.click();
			System.out.println("Change QQ to the state of hinding");
			
		}else if(nowstate1.exists()){
			online.click();
			System.out.println("Change QQ to the state of online");		
		}
		uiDevice.pressBack();
		uiDevice.pressBack();
		uiDevice.pressBack();
			
		
	}
	
	void addsomeone(String sb) throws UiObjectNotFoundException{ 
		
		UiObject QQtabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
			
		UiObject contacts = QQtabs.getChild(new UiSelector().index(1).className("android.widget.RelativeLayout"));
		if(!contacts.isSelected()){
			contacts.clickAndWaitForNewWindow();
		}
		update();
		
		UiObject addButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnRightText"));
		addButton.clickAndWaitForNewWindow();
		
		UiObject searchText = new UiObject(new UiSelector().className("android.widget.EditText"));	
		searchText.click();
		searchText.setText(sb);
		
		UiObject searchButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/btn_cancel_search"));
		searchButton.clickAndWaitForNewWindow();
		
		UiObject add = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/txt").className("android.widget.Button"));
		add.clickAndWaitForNewWindow();
		
		UiObject vertifyText = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.EditText"));
		//vertifyText.clearTextField();  // 不能完全清除
		// 删除text内容
		String edit = vertifyText.getText();
		vertifyText.clickBottomRight();
    	for (int i = 0; i < edit.length(); i++) {
    		uiDevice.pressDelete();
    	   
    	}
    	vertifyText.setText("I am Emma");

		
		UiObject nextButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnRightText").className("android.widget.TextView"));
		nextButton.clickAndWaitForNewWindow();
		
		sleep(1000);
		UiObject send = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnRightText").className("android.widget.TextView"));
		send.click();
		sleep(1000);
		uiDevice.pressBack();
		sleep(1000);
	
		uiDevice.pressBack();
		
	}
	


}
