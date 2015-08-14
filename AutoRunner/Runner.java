package AutoRunner;

import android.widget.RadioButton;
import android.widget.RelativeLayout;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Runner extends UiAutomatorTestCase {  
  
    public void testDemo() throws UiObjectNotFoundException, RemoteException{  
    	
    	
        getUiDevice().pressHome();  
        
        //进入“系统设置”菜单。也可以通过点击menu按键来实现  
        UiObject settingApp = new UiObject(new UiSelector().text("Settings"));  
        settingApp.click();  
      
        //等待3秒  
        try {  
            Thread.sleep(3000);  
        } catch (InterruptedException e1) {  
            e1.printStackTrace();  
        }  
      
        // 进入  More Settings
        UiScrollable settingItems = new UiScrollable(  
                new UiSelector().scrollable(true));  

        UiObject moresettingItem = settingItems.getChildByText(  
                new UiSelector().text("More settings"), "More settings",  
                true);  
        moresettingItem.clickAndWaitForNewWindow();
       
        // 进入 language
        UiScrollable moresettingItems = new UiScrollable(  
                new UiSelector().scrollable(true));      
      
        UiObject languageItem = moresettingItems.getChildByText(  
                new UiSelector().text("Language"), "Language",  
                true);  
        languageItem.clickAndWaitForNewWindow();  
     
        // 找到  简体中文 项,      
        //由于无法识别中文，因此我们这里使用 index 去选择“简体中文”项  
        // index 为 1的对象
        UiObject listIndex1 = new UiObject(new UiSelector().index(1));
        UiObject ChiLanItem = listIndex1.getChild(new UiSelector().className(RelativeLayout.class.getName()));
 
        UiObject ChiBut = ChiLanItem.getChild(new UiSelector().className(RadioButton.class.getName()));
          
        ChiBut.clickAndWaitForNewWindow();  
        
        //点击返回键，回到待机界面  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        
    
        
         
    }  
}  
