package AutoRunner;

import java.io.IOException;

import android.os.RemoteException;
import android.graphics.Rect;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AlbumsOperation extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		
		openAlbums();
		
		scanGallery();
		
		getUiDevice().pressHome();
		
	}
	
	private void openAlbums() throws UiObjectNotFoundException{
		
		try {
	         Runtime.getRuntime().exec("am start -n com.vivo.gallery/com.android.gallery3d.vivo.GalleryTabActivity");

	     } catch (IOException e) {
				e.printStackTrace();
	     }
		 //�ȴ�5��  
	     try {  
	         Thread.sleep(5000);  
	     } catch (InterruptedException e1) {  
	         e1.printStackTrace();  
	     }  			
	}
	
	private int getPhotoNum() throws UiObjectNotFoundException{
		
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
	
	
	private void scanGallery() throws UiObjectNotFoundException{
		
		int allNum = getPhotoNum();
		
		UiObject galleryTabs = new UiObject(new UiSelector().resourceId("android:id/tabs"));
		UiObject Photostabs = galleryTabs.getChild(new UiSelector().resourceId("com.vivo.gallery:id/tab_text").text("Photos"));
		if(!Photostabs.isSelected()){
			Photostabs.clickAndWaitForNewWindow();			
		}		
		// uiautomatorviewer �޷�ʶ�����������
		// ֻ���������鿴
		UiObject titleView = new UiObject(new UiSelector().resourceId("com.vivo.gallery:id/title_view_layout"));
		Rect rect = titleView.getBounds();
		
		int top = rect.bottom;		
		int width = getUiDevice().getDisplayWidth();	
		int height = getUiDevice().getDisplayHeight();
		// ������Ͻǵĵ�һ��ͼƬ
		getUiDevice().click(width/8, top + width/8);
		sleep(2000);
		
		for(int i = 0; i < allNum-1 ; i++){
			getUiDevice().swipe( width-100, height/2, 100, height/2, 10);
			sleep(1000);
		}
		
		getUiDevice().pressBack();
		
		getUiDevice().pressBack(); // �ص�����

	}

}
