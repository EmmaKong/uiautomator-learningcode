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
		 
		 if(!getUiDevice().isScreenOn()){			 
			 getUiDevice().wakeUp();  // ����			 
		 }
		//�ȴ�3��  
	     try {  
	         Thread.sleep(3000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	        
		 // ��ȡ��Ļ��С
		 int height = getUiDevice().getDisplayHeight();
		 int width = getUiDevice().getDisplayWidth();
		 
         // ����������
		 getUiDevice().swipe(width/2, (int)(height*0.9), width/2, (int)(height*0.1), 2); 
		 getUiDevice().pressHome(); 
		 
		 getUiDevice().openNotification();  //��֪ͨ��
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
	     int apksNum = apksListView.getChildCount();
	     if(apksNum > 0){
	    	 // ��ȡ ��һ�� apk
	    	 UiObject firstItem = apksListView.getChild(new UiSelector().index(0));
	 	    
		     firstItem.clickAndWaitForNewWindow();
		     UiObject cancelBut = new UiObject(new UiSelector().text("Cancel"));
		     cancelBut.click();
	     }
	    
	     getUiDevice().pressBack();
	  
	     getUiDevice().pressHome(); 
	        
	     // ������һ ��
	     getUiDevice().swipe(0, height/2, width, height/2, 2); 
	     
	     // ��΢��
	     UiObject weiboApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()),"Weibo");
		 weiboApp.clickAndWaitForNewWindow();
		 
		 UiObject share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rl_composer"));
		 share.clickAndWaitForNewWindow();
		 UiObject close_share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/pop_control_bar_front_close_img"));
		 close_share.clickAndWaitForNewWindow();
		 
		 //�����¼ҳ
		 UiObject Login = new UiObject(new UiSelector().text("Login"));
		 Login.clickAndWaitForNewWindow();
		 
		 UiObject logintext =new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etLoginUsername"));
		 logintext.clickAndWaitForNewWindow(); 
		 	 
		 UiObject clearbutton =new UiObject(new UiSelector().resourceId("com.sina.weibo:id/login_user_tips_btn"));//��������˺ŵ�������
		 clearbutton.clickAndWaitForNewWindow();
		 
		 //�����û���������
		 logintext.setText("1229480203@qq.com");
		 
		 UiObject Pwdtext =new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etPwd"));
		 Pwdtext.setText("whlg0902???");
		 // m��¼
		 UiObject Loginbutton =new UiObject(new UiSelector().resourceId("com.sina.weibo:id/bnLogin")); 
		 Loginbutton.clickAndWaitForNewWindow();
		
		 // �ж��Ƿ񵯳���֤�������
		 UiObject Loginbutton =new UiObject(new UiSelector().resourceId("com.sina.weibo:id/bnLogin")); 
		 Loginbutton.clickAndWaitForNewWindow();
		 if
		 //getUiDevice().pressHome(); 
		 
	     
	     
	 
	 }

}
