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
     
        // �ҵ�  �������� ��,      
        //�����޷�ʶ�����ģ������������ʹ�� index ȥѡ�񡰼������ġ���  
        // index Ϊ 1�Ķ���
        UiObject listIndex1 = new UiObject(new UiSelector().index(1));
        UiObject ChiLanItem = listIndex1.getChild(new UiSelector().className(RelativeLayout.class.getName()));
 
        UiObject ChiBut = ChiLanItem.getChild(new UiSelector().className(RadioButton.class.getName()));
          
        ChiBut.clickAndWaitForNewWindow();  
        
        //������ؼ����ص���������  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        getUiDevice().pressBack();  
        
    
        
         
    }  
}  
