package AutoRunner;

import android.os.RemoteException;
import android.widget.TextView;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LoginWeibo extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		// ��ȡ��Ļ��С
	    int height = getUiDevice().getDisplayHeight();
	    int width = getUiDevice().getDisplayWidth();
		// view��ͼ
		UiScrollable appview = new UiScrollable (new UiSelector().scrollable(true));
	    appview.setAsHorizontalList();
	    // ��΢��
	    UiObject weiboApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()),"Weibo");
	    weiboApp.clickAndWaitForNewWindow();
	    //�ȴ� ����
	    try {  
	    	Thread.sleep(5000);  
	    } catch (InterruptedException e1) {  
	    	e1.printStackTrace();  
	    }  
	    // �жϴ�ҳ�������
	    // ��ҳ�� ���� ��¼ҳ��		 
	    UiObject share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rl_composer"));
	    if(share.exists()){
	    	share.clickAndWaitForNewWindow();
	    	UiObject close_share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/pop_control_bar_front_close_img"));
	    	close_share.clickAndWaitForNewWindow();
	    	//�����¼ҳ
	    	UiObject Login = new UiObject(new UiSelector().text("Login"));
	    	Login.clickAndWaitForNewWindow();
		 
	    }
	 
	    UiObject logintext = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etLoginUsername"));
	    logintext.clickAndWaitForNewWindow(); 
	    //��������˺ŵ�������
	    UiObject clearbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/login_user_tips_btn"));
	    if(clearbutton.exists()){
		 clearbutton.clickAndWaitForNewWindow();		 
	    }
	    //�����û���
	    logintext.setText("1229480203@qq.com");
	   
	    UiObject Pwdtext = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etPwd"));
	    UiObject pwdclearbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/login_password_tips_btn"));
	    // ���������
	    if(pwdclearbutton.exists()){
	    	pwdclearbutton.clickAndWaitForNewWindow();
	    } 
	    Pwdtext.setText("whlg0902???");
	    // ��¼
	    UiObject Loginbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/bnLogin")); 
	    Loginbutton.clickAndWaitForNewWindow();
	
	    // �ж��Ƿ񵯳���֤�������
	    UiObject captcha = new UiObject(new UiSelector().text("Please enter the captcha")); 		 
	    // �������
	    UiObject pwdwrong = new UiObject(new UiSelector().text("Get Password")); 
	 
	    if(captcha.exists()){
	    	UiObject calcelbutton = new UiObject(new UiSelector().text("Cancel")); 
	    	calcelbutton.clickAndWaitForNewWindow();
		 
	    	getUiDevice().pressHome();
	    }else if((pwdwrong.exists())){
	    	UiObject calcelbutton = new UiObject(new UiSelector().text("Cancel")); 
	    	calcelbutton.clickAndWaitForNewWindow();
	    	getUiDevice().pressHome();
	    }else{
	    	//�ɹ�����΢��
	    	// ����ˢ��
	    	getUiDevice().swipe(width/2, 100, width/2, height-100, 5);
	    	//�ȴ�5��  
	    	try {  
	    		Thread.sleep(5000);  
	    	} catch (InterruptedException e1) {  
	    		e1.printStackTrace();  
	    	}          
		 
	    	UiObject rltitle  = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitleBack"));
	    	rltitle.clickAndWaitForNewWindow();
	    	//�ȴ�5��  
	    	try {  
	    		Thread.sleep(5000);  
	    	} catch (InterruptedException e1) {  
	    		e1.printStackTrace();  
	    	}  
	    	getUiDevice().pressBack();
	     
	    	UiObject Profile = new UiObject(new UiSelector().description("Profile"));
	    	Profile.clickAndWaitForNewWindow();
	    	// �˳���¼
	    	UiObject settings = new UiObject(new UiSelector().description("Setting"));
	    	settings.clickAndWaitForNewWindow();
	     
	    	UiObject account = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/accountLayout"));
	    	account.clickAndWaitForNewWindow();
	     
	    	UiObject Loginout = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/exitAccountContent"));
	    	Loginout.clickAndWaitForNewWindow();
	     
	    	UiObject Okbutton = new UiObject(new UiSelector().text("OK"));
	    	Okbutton.clickAndWaitForNewWindow();
	     
	    	getUiDevice().pressHome();
	          
	    }
	 }
}
