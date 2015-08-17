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
		
		// 获取屏幕大小
	    int height = getUiDevice().getDisplayHeight();
	    int width = getUiDevice().getDisplayWidth();
		// view视图
		UiScrollable appview = new UiScrollable (new UiSelector().scrollable(true));
	    appview.setAsHorizontalList();
	    // 打开微博
	    UiObject weiboApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()),"Weibo");
	    weiboApp.clickAndWaitForNewWindow();
	    //等待 缓冲
	    try {  
	    	Thread.sleep(5000);  
	    } catch (InterruptedException e1) {  
	    	e1.printStackTrace();  
	    }  
	    // 判断打开页面的内容
	    // 主页面 或者 登录页面		 
	    UiObject share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rl_composer"));
	    if(share.exists()){
	    	share.clickAndWaitForNewWindow();
	    	UiObject close_share = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/pop_control_bar_front_close_img"));
	    	close_share.clickAndWaitForNewWindow();
	    	//进入登录页
	    	UiObject Login = new UiObject(new UiSelector().text("Login"));
	    	Login.clickAndWaitForNewWindow();
		 
	    }
	 
	    UiObject logintext = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etLoginUsername"));
	    logintext.clickAndWaitForNewWindow(); 
	    //点击输入账号的清除叉叉
	    UiObject clearbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/login_user_tips_btn"));
	    if(clearbutton.exists()){
		 clearbutton.clickAndWaitForNewWindow();		 
	    }
	    //输入用户名
	    logintext.setText("1229480203@qq.com");
	   
	    UiObject Pwdtext = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/etPwd"));
	    UiObject pwdclearbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/login_password_tips_btn"));
	    // 先清除内容
	    if(pwdclearbutton.exists()){
	    	pwdclearbutton.clickAndWaitForNewWindow();
	    } 
	    Pwdtext.setText("whlg0902???");
	    // 登录
	    UiObject Loginbutton = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/bnLogin")); 
	    Loginbutton.clickAndWaitForNewWindow();
	
	    // 判断是否弹出验证码输入框
	    UiObject captcha = new UiObject(new UiSelector().text("Please enter the captcha")); 		 
	    // 密码错误
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
	    	//成功进入微博
	    	// 下拉刷新
	    	getUiDevice().swipe(width/2, 100, width/2, height-100, 5);
	    	//等待5秒  
	    	try {  
	    		Thread.sleep(5000);  
	    	} catch (InterruptedException e1) {  
	    		e1.printStackTrace();  
	    	}          
		 
	    	UiObject rltitle  = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/rltitleBack"));
	    	rltitle.clickAndWaitForNewWindow();
	    	//等待5秒  
	    	try {  
	    		Thread.sleep(5000);  
	    	} catch (InterruptedException e1) {  
	    		e1.printStackTrace();  
	    	}  
	    	getUiDevice().pressBack();
	     
	    	UiObject Profile = new UiObject(new UiSelector().description("Profile"));
	    	Profile.clickAndWaitForNewWindow();
	    	// 退出登录
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
