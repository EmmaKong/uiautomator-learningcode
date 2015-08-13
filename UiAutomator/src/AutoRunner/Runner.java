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
        
        //���롰ϵͳ���á��˵���Ҳ����ͨ�����menu������ʵ��  
        UiObject settingApp = new UiObject(new UiSelector().text("Settings"));  
        settingApp.click();  
      
        //�ȴ�3��  
        try {  
            Thread.sleep(3000);  
        } catch (InterruptedException e1) {  
            e1.printStackTrace();  
        }  
      
        // ����  More Settings
        UiScrollable settingItems = new UiScrollable(  
                new UiSelector().scrollable(true));  

        UiObject moresettingItem = settingItems.getChildByText(  
                new UiSelector().text("More settings"), "More settings",  
                true);  
        moresettingItem.clickAndWaitForNewWindow();
       
        // ���� language
        UiScrollable moresettingItems = new UiScrollable(  
                new UiSelector().scrollable(true));      
      
        UiObject languageItem = moresettingItems.getChildByText(  
                new UiSelector().text("Language"), "Language",  
                true);  
        languageItem.clickAndWaitForNewWindow();  
      
      
        //�ҵ���English���Ŀɵ�����Ϊ��ǰ��Ӣ�Ļ�����  
        UiObject setLanItem = new UiObject(new UiSelector().text("English"));  
        setLanItem.clickAndWaitForNewWindow();  
           
        //Log���  
        System.out.println("setLanItem-->" + setLanItem.getPackageName());  
      
        //�����޷�ʶ�����ģ������������ʹ������ȥѡ�񡰼������ġ���  
        getUiDevice().click(1004, 349);  
          
        //������ؼ����ص���������  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        
    
        
         
    }  
}  