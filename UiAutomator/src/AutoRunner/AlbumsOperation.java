package AutoRunner;

import java.io.IOException;



//import android.os.RemoteException;
import android.graphics.Rect;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AlbumsOperation extends UiAutomatorTestCase {
	/*
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openAlbums();
		
		scanGallery();
		
		getUiDevice().pressHome();
		
	}
	*/
	
	UiDevice uiDevice;	
	// 构造函数
	public AlbumsOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	void openAlbums() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.vivo.gallery/com.android.gallery3d.vivo.GalleryTabActivity");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //等待5秒  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     } 
	     System.out.println("Open Albums!");
	     
	}
	
	int getPhotoNum() throws UiObjectNotFoundException{
		
		UiObject galleryTabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Albumstabs = galleryTabs.getChild(new UiSelector().resourceId("com.vivo.gallery:id/tab_text").text("All albums"));
		if(!Albumstabs.isSelected()){
			Albumstabs.clickAndWaitForNewWindow();			
		}	
		
		UiObject allAlbulmsList = new UiObject(new UiSelector().resourceId("com.vivo.gallery:id/dreamway_folder_albumset_list"));
		UiObject PhotosByCamera = allAlbulmsList.getChild(new UiSelector().className("android.widget.RelativeLayout").index(0));
		UiObject countInfo = PhotosByCamera.getChild(new UiSelector().resourceId("com.vivo.gallery:id/dreamway_folder_count"));
		int num =  Integer.valueOf(countInfo.getText());
	
		System.out.println("There are: " + num + " photos taken by camera!");
		return num;
	}
	
	
	void scanGallery() throws UiObjectNotFoundException{
		
		int allNum = getPhotoNum();
		
		UiObject galleryTabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Photostabs = galleryTabs.getChild(new UiSelector().resourceId("com.vivo.gallery:id/tab_text").text("Photos"));
		if(!Photostabs.isSelected()){
			Photostabs.clickAndWaitForNewWindow();			
		}		
		// uiautomatorviewer 无法识别相册内内容
		// 只能随意点击查看
		UiObject titleView = new UiObject(new UiSelector().resourceId("com.vivo.gallery:id/title_view_layout"));
		Rect rect = titleView.getBounds();
		
		int top = rect.bottom;		
		int width = uiDevice.getDisplayWidth();	
		int height = uiDevice.getDisplayHeight();
		// 点击右上角的第一张图片
		uiDevice.click(width/8, top + width/8);
		sleep(2000);
		
		for(int i = 0; i < allNum-1 ; i++){
			uiDevice.swipe( width-100, height/2, 100, height/2, 10);
			sleep(1000);
		}
		
		uiDevice.pressBack();
		
		uiDevice.pressBack(); // 回到顶端

	}

}
