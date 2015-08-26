package AutoRunner;

import android.widget.RadioButton;
import android.widget.RelativeLayout;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


import AutoRunner.AiqiyiOperation;
import AutoRunner.AlbumsOperation;
import AutoRunner.AppStoreOperation;
import AutoRunner.baiduOperation;
import AutoRunner.CameraOperation;
import AutoRunner.FilemanagerOperation;
import AutoRunner.iMusicOperation;
import AutoRunner.QQOperation;
import AutoRunner.WeiboOperation;
import AutoRunner.WeichatOperation;



public class Runner extends UiAutomatorTestCase {  
  
    public void testDemo() throws UiObjectNotFoundException, RemoteException{  
    	
    	AppStoreOperation AppStore = new AppStoreOperation();
    	
    	AiqiyiOperation Aiqiyi = new AiqiyiOperation();
    	
    	AlbumsOperation Albums = new AlbumsOperation();
    	
    	baiduOperation baidu = new baiduOperation();
    	
    	
    	
    	
       
    
        
         
    }  
}  
