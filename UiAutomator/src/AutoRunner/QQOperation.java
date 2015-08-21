package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class QQOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openQQ();
		
		update();
		
		//scanQQZone();
		
		accountSetting();
		
		
		
	}
	
	private void openQQ() throws UiObjectNotFoundException{
		
		try {
		    Runtime.getRuntime().exec("am start -n com.tencent.mobileqq/.activity.SplashActivity");
		       
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
			 
		// ����ˢ��
	    getUiDevice().swipe(width/2, 500, width/2, height-500, 50);
		//�ȴ�2��  
		try {  
			Thread.sleep(2000);  
		} catch (InterruptedException e1) {  
			e1.printStackTrace();  
	    }          
	}
	
	private void scanRelatedwithMe(int num) throws UiObjectNotFoundException{   // num �����������
		
		UiObject qzoneMenu = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.LinearLayout").index(3));
		
		UiObject relatedwithMe = qzoneMenu.getChild(new UiSelector().index(3).resourceId("com.tencent.mobileqq:id/name"));
		relatedwithMe.clickAndWaitForNewWindow();
		
		update();
		UiScrollable relatedwithMemainView = new UiScrollable(new UiSelector().resourceId("com.tencent.mobileqq:id/name").scrollable(true));
		if(relatedwithMemainView.exists()){
			while(true){
				for(int i = num; i>0; i--){
					relatedwithMemainView.scrollForward();   // ���� ����û�������ģ���ͣ�ˡ�����
					sleep(1000);
				
				}
				break;
			
			}
		}
		getUiDevice().pressBack();
		
	}
	
	private void sendSomething(String some) throws UiObjectNotFoundException{    // ����˵˵
		
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
		
	}
	
	private void scanMainzone(int num) throws UiObjectNotFoundException{   // num �����������
		
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
		// ���ض���
		for(int i = num; i>0; i--){
			Mainview.scrollBackward();	
		}
				
	}
	
	
	
	private void scanQQZone() throws UiObjectNotFoundException{
		UiObject QQtabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		
		UiObject dynamic = QQtabs.getChild(new UiSelector().index(2).className("android.widget.FrameLayout"));
		dynamic.clickAndWaitForNewWindow();
		sleep(1000);
		//UiObject contacts = QQtabs.getChild(new UiSelector().index(1).className("android.widget.RelativeLayout"));
		//contacts.clickAndWaitForNewWindow();
		
		//sleep(1000);
		//UiObject message = QQtabs.getChild(new UiSelector().index(0).className("android.widget.RelativeLayout"));
		//message.clickAndWaitForNewWindow();
		
		UiObject qZoneEntry = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/qzone_feed_entry"));
		qZoneEntry.clickAndWaitForNewWindow();
	
		update();   // ����ˢ��
		sleep(2000);
		
		scanRelatedwithMe(10);
		sleep(1000);
		
		scanMainzone(10); 
		sleep(1000);
		
		sendSomething("JUST FOR TESTING!");
		
		
	
		
		//UiObject mainView = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/main"));
		
		//UiScrollable  mainView = new UiScrollable(new UiSelector().resourceId("com.tencent.mobileqq:id/main"));
		//mainView.scrollForward();
		
		
		
	}
	
	private void accountSetting() throws UiObjectNotFoundException{ 
		
		UiObject settingEntry = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/conversation_head"));
		settingEntry.click();
		sleep(1000);
		
		UiObject settingButton = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/settings"));
		settingButton.clickAndWaitForNewWindow();
		
		// �ı��¼״̬
		UiObject accountSwitch = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/account_switch"));
		accountSwitch.clickAndWaitForNewWindow();
		
		UiObject online = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.RelativeLayout").index(4));
		UiObject nowstate0 = online.getChild(new UiSelector().index(1));  // ����
		UiObject hiding = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/name").className("android.widget.RelativeLayout").index(5));
		UiObject nowstate1 = hiding.getChild(new UiSelector().index(1));  // ����
		if(nowstate0.exists()){
			hiding.click();
			System.out.println("Change QQ to the state of hinding");
			
		}else if(nowstate1.exists()){
			online.click();
			System.out.println("Change QQ to the state of online");		
		}
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();
			
		
	}


}
