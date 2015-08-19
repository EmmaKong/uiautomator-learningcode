package AutoRunner;


//import java.io.IOException;

import java.io.IOException;

//import android.widget.TextView;
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
		 
		 // 获取屏幕大小
		 int height = getUiDevice().getDisplayHeight();
		 int width = getUiDevice().getDisplayWidth();
		 if(!getUiDevice().isScreenOn()){			 
			 getUiDevice().wakeUp();  // 唤醒		
			//等待3秒  
		     try {  
		         Thread.sleep(3000);  
		     } catch (InterruptedException e1) {  
		         e1.printStackTrace();  
		     }  
			// 划屏，解锁
			 getUiDevice().swipe(width/2, (int)(height*0.9), width/2, (int)(height*0.1), 5); 	 
		 }
		 //等待3秒  
	     try {  
	         Thread.sleep(3000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     getUiDevice().pressHome();   
		
		 // view视图
		// UiScrollable appview = new UiScrollable (new UiSelector().scrollable(true));
	    // appview.setAsHorizontalList();
	     
	     //int appNum = appview.getChildCount();
	    // System.out.println("The Number of horizontal view: " + appNum);
	     
	     try {
	         Runtime.getRuntime().exec("am start -n com.android.settings/.Settings");
		          	
	     } catch (IOException e) {
				e.printStackTrace();
				
	     }

		 //UiObject settingApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()), "Settings");
		// settingApp.clickAndWaitForNewWindow();
		
	     
	     UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));  
	     
	     UiObject vivoiceItem = settingItems.getChildByText(new UiSelector().text("vivoice"), "vivoice", true);  
	     vivoiceItem.clickAndWaitForNewWindow();
	     getUiDevice().pressBack();  
	     getUiDevice().pressHome(); 
	     
	     try {
	         Runtime.getRuntime().exec("am start -n com.android.filemanager/.FileManagerActivity");
	       
	     } catch (IOException e) {
				e.printStackTrace();		
	     }

	    // UiObject FileManagerApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()), "File Manager");
		// FileManagerApp.clickAndWaitForNewWindow();
	     
	     UiObject CatagoryItem = new UiObject(new UiSelector().resourceId("com.android.filemanager:id/category_browse"));
	     CatagoryItem.click();
	     
	     UiObject apksItem = new UiObject(new UiSelector().text("Apks"));
	     apksItem.clickAndWaitForNewWindow();
	     
	     UiObject apksListView = new UiObject(new UiSelector().className(ListView.class.getName())); 
	     int apksNum = apksListView.getChildCount();
	     if(apksNum > 0){
	    	 // 获取 第一个 apk
	    	 UiObject firstItem = apksListView.getChild(new UiSelector().index(0));
	 	    
		     firstItem.clickAndWaitForNewWindow();
		     UiObject cancelBut = new UiObject(new UiSelector().text("Cancel"));
		     cancelBut.click();
	     }
	    
	     getUiDevice().pressBack();
	  
	     getUiDevice().pressHome(); 
	        
	     try {
	         Runtime.getRuntime().exec("am start -n com.sina.weibo/.MainTabActivity");
	       
	     } catch (IOException e) {
				e.printStackTrace();		
	     }
	     // 打开微博
	    // UiObject weiboApp = appview.getChildByText(new UiSelector().className(TextView.class.getName()),"Weibo");
		// weiboApp.clickAndWaitForNewWindow();
		 //等待 缓冲
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
         
	     // 刷新
	     UiObject weiboHome = new UiObject(new UiSelector().description("Home"));
		 weiboHome.clickAndWaitForNewWindow();
		 
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
		     
		 UiObject weiboMessage = new UiObject(new UiSelector().description("Message"));
		 weiboMessage.clickAndWaitForNewWindow();
		 
		 UiObject newmessage  = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/tvItemNum"));
	     if(newmessage.exists()){
	    	 newmessage.clickAndWaitForNewWindow();
	    	 getUiDevice().pressBack();
	     }
	     
	     
		 UiObject weiboProfile = new UiObject(new UiSelector().description("Profile"));
		 weiboProfile.clickAndWaitForNewWindow();
		 
		 UiObject weiboSettings = new UiObject(new UiSelector().description("Settings"));
		 weiboSettings.clickAndWaitForNewWindow();
		 
		 UiObject clearcache  = new UiObject(new UiSelector().resourceId("com.sina.weibo:id/cleanCacheLayout"));
		 clearcache.clickAndWaitForNewWindow();  
		 
		 UiObject clearOk  = new UiObject(new UiSelector().text("OK"));
		 if(clearOk.exists()){
			 clearOk.click();  
		 }
		 getUiDevice().pressBack();
		 
		 getUiDevice().pressHome();
		          
		   
	     // 打开 蘑菇街
	     try {
	         Runtime.getRuntime().exec("am start -n com.mogujie/.index.MGInitAct");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
	     //等待10秒  
	     try {  
	         Thread.sleep(10000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  

	     UiObject mogujieFollow = new UiObject(new UiSelector().resourceId("com.mogujie:string/follow"));
		 mogujieFollow.clickAndWaitForNewWindow();
		 
		 UiObject mogujieTriple = new UiObject(new UiSelector().resourceId("com.mogujie:string/triple"));
		 mogujieTriple.clickAndWaitForNewWindow();
		 
		 UiObject shangyi = new UiObject(new UiSelector().resourceId("com.mogujie:id/rl_category1"));
		 shangyi.clickAndWaitForNewWindow();
		 
		 
		 UiObject themeone =  new UiObject(new UiSelector().resourceId("com.mogujie:id/fastfashion_theme_1"));
		 themeone.clickAndWaitForNewWindow();
		 // 最新
		 UiObject latest =  new UiObject(new UiSelector().resourceId("com.mogujie:id/latest"));
		 latest.clickAndWaitForNewWindow();
		 //等待1秒  
	     try {  
	         Thread.sleep(1000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
		 	     
	     UiObject RecyclerView = new UiObject(new UiSelector().className("android.support.v7.widget.RecyclerView"));
	     UiObject oneItem = RecyclerView.getChild(new UiSelector().index(0));
	     oneItem.clickAndWaitForNewWindow();
	     
	     // UiScrollable, 滑到指定位置
	     UiScrollable goodsdetails = new UiScrollable(new UiSelector().scrollable(true));  
	     goodsdetails.scrollIntoView(new UiSelector().resourceId("com.mogujie:id/detail_add_to_cart_btn"));  // 滚动到条件元素所在位置，并且尽量让其居于屏幕中央	      
	    //等待5秒  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     UiObject addtocart = new UiObject(new UiSelector().resourceId("com.mogujie:id/detail_add_to_cart_btn")); 
	
	     addtocart.click();
	     
	     //等待2秒  
	     try {  
	         Thread.sleep(2000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     
	     // 检测不出弹出框的内容。why？
	     getUiDevice().pressBack();
	     
	     UiObject cart = new UiObject(new UiSelector().resourceId("com.mogujie:id/detail_shopping_cart"));
		 cart.clickAndWaitForNewWindow();
	     
		 getUiDevice().pressBack();
		 getUiDevice().pressBack();
		 getUiDevice().pressBack();
		 getUiDevice().pressBack();  // 退回至 主页面
		 
	     UiObject slidetoogle = new UiObject(new UiSelector().resourceId("com.mogujie:id/slide_toogle"));
	     slidetoogle.click();
	     
	     UiObject logininfo = new UiObject(new UiSelector().resourceId("com.mogujie:id/login_info"));
	     logininfo.clickAndWaitForNewWindow();
	     
	     UiObject nickname = new UiObject(new UiSelector().resourceId("com.mogujie:id/user_info_nick_name_layout"));
	     nickname.clickAndWaitForNewWindow();
	     // 修改昵称
	     UiObject nicknametext = new UiObject(new UiSelector().resourceId("com.mogujie:id/username_edit"));
	     if(nicknametext.getText() != "Emma_Kong"){
	    	 //nicknametext.click();
	    	 nicknametext.clearTextField();
	    	 nicknametext.setText("Emma_Kong");
	    	 UiObject saveButton = new UiObject(new UiSelector().resourceId("com.mogujie:id/right_btn"));
	    	 saveButton.click();
	     
	     }else{
	    	 getUiDevice().pressBack();
	     }
	     getUiDevice().pressBack();
	     
	     UiObject settinglist = new UiObject(new UiSelector().resourceId("com.mogujie:id/setting_list"));
	     UiObject memberhome = settinglist.getChild(new UiSelector().index(7));
	     memberhome.clickAndWaitForNewWindow();
	     
	     UiScrollable mymember = new UiScrollable(new UiSelector().scrollable(true));  

	     UiObject signin = mymember.getChild(new UiSelector().index(3));  
	     signin.clickAndWaitForNewWindow();
	     getUiDevice().pressBack();
	     getUiDevice().pressBack();
	     
	     UiObject myorder = settinglist.getChild(new UiSelector().index(1));
	     myorder.clickAndWaitForNewWindow();
	     
	     getUiDevice().pressBack();
	     getUiDevice().pressBack();
	     
	     getUiDevice().pressHome();
	     
		 try {
	         Runtime.getRuntime().exec("am start -n com.bbk.appstore/.ui.AppStore");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //等待5秒  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     
	     UiObject search = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/key_label"));
	     search.setText("QQ");	     
	     //等待1秒  
	     try {  
	         Thread.sleep(1000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  
	     
	     UiObject searchresult = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/package_list_item_info_layout"));
	     // 捕获 下载 或 打开  按钮
	     UiObject downButton =  searchresult.getChild(new UiSelector().resourceId("com.bbk.appstore:id/download_status"));  
	     UiObject openButton =  searchresult.getChild(new UiSelector().resourceId("com.bbk.appstore:id/open_status")); 
	     if(downButton.exists()){
	    	 downButton.click();
	    	 
	    	 UiObject downloadContainer = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/download_container"));
	    	 downloadContainer.clickAndWaitForNewWindow();
	    	 
	    	 UiObject downloadingItems = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/downloading_item"));
	    	 UiObject downloadButton = downloadingItems.getChild(new UiSelector().index(5)); 
	         downloadButton.click();
	    	 
	    	//等待3秒  
		     try {  
		         Thread.sleep(3000);  
		     } catch (InterruptedException e1) {  
		         e1.printStackTrace();  
		     }
	    	 
		     downloadButton.click();
		     
		     UiObject indicator = downloadingItems.getChild(new UiSelector().index(6)); 
		     indicator.clickAndWaitForNewWindow();
		     
		     UiObject downloadcancel = new UiObject(new UiSelector().resourceId("com.bbk.appstore:id/cancel_layout"));
		     downloadcancel.click();
		     
		     getUiDevice().pressBack();
		     getUiDevice().pressBack();
		     
		     getUiDevice().pressHome();
		     
		         	 
	     }else if(openButton.exists()){
	    	 openButton.click();
	     }
	    		 
	 }

}
