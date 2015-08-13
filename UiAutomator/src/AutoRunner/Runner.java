package AutoRunner;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Runner extends UiAutomatorTestCase {  
  
    public void testDemo() throws UiObjectNotFoundException {  
    	
    	//getUiDevice().wakeUp();
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
      
      
        //找到“English”的可点击项（因为当前是英文环境）  
        UiObject setLanItem = new UiObject(new UiSelector().text("English"));  
        setLanItem.clickAndWaitForNewWindow();  
           
        //Log输出  
        System.out.println("setLanItem-->" + setLanItem.getPackageName());  
      
        //由于无法识别中文，因此我们这里使用坐标去选择“简体中文”项  
        getUiDevice().click(1004, 349);  
          
        //点击返回键，回到待机界面  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        
    
        
         
    }  
}  
