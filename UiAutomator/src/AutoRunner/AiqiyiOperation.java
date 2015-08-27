package AutoRunner;

import java.io.IOException;

//import android.os.RemoteException;



import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AiqiyiOperation extends UiAutomatorTestCase{
	/*
	public void testDemo() throws UiObjectNotFoundException, RemoteException{  
		openAiqiyi();
		
		searchandDownloadVideo("woqushangxue");
		
		//searchandWatchVideo("jixiantiaozhan");	
		
		watchDownloadedVideo();
		// �ۿ����� �ͻ��� ��ѡһ
		
	}
	*/
	
	UiDevice uiDevice;	
	// ���캯��
	public AiqiyiOperation(UiDevice device) {
        uiDevice = device;      
    }
	
	
	void openAiqiyi() throws UiObjectNotFoundException{
		
		try {
		    Runtime.getRuntime().exec("am start -n com.qiyi.video/.WelcomeActivity");
		       
		} catch (IOException e) {
			e.printStackTrace();		
		}
		//�ȴ� ����
		try {  
		    Thread.sleep(5000);  
		} catch (InterruptedException e1) {  
		    e1.printStackTrace();  
		}  	
		System.out.println("Open Aiyiqi!");
	}
	
	void searchandDownloadVideo(String some) throws UiObjectNotFoundException{
		
		UiObject searchText = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/titleIndexSearchImage"));
		searchText.clickAndWaitForNewWindow();
		
		UiObject searchEdittext = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phoneSearchKeyword").clickable(true));
		searchEdittext.setText(some);
		
		UiObject searchSubmit = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phoneSearchSubmit"));
		searchSubmit.clickAndWaitForNewWindow();
		
		
		UiObject download_btn = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phone_search_result_adapter_download_btn"));
		if(download_btn.exists()){
			download_btn.click();
			
			UiObject rateChoose = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/rate"));
			rateChoose.click();
			UiObject rate_gq = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/rate_gq"));  // ����
			if(rate_gq.exists()){
				rate_gq.click();
			}
						
			UiScrollable videoListView = new UiScrollable(new UiSelector().resourceId("com.qiyi.video:id/listview").className("android.widget.ListView"));
			if(videoListView.exists()){
				UiObject selectAll = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/select_all"));
				UiObject download = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/download"));
				
				selectAll.click();
				sleep(1000);
				download.click();				
			}
				
		}
		uiDevice.pressBack();
		uiDevice.pressBack();
		
	}
	
	void landscapeSwitch() throws UiObjectNotFoundException{  // ȫ���л�
		
		UiObject landscapeButton = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_tolandscape"));	
		UiObject adslandscapeButton = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_ads_tolandscape")); // ��沥����
			
		UiObject adsBottom =  new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_adsBottom"));  
		
		UiObject playControl = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/playControlMainLayout"));
		UiObject fullButtom = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/player_landscape_bottom_area"));
		if(adsBottom.exists()){  // ��沥��ʱ��
			if(adslandscapeButton.exists()){ // ��ȫ��
				adslandscapeButton.click();	
				System.out.println("switch to full screen!" );
			}else{
				uiDevice.pressBack();
				System.out.println("exit full screen!" );			
			}
		}else{ // ��Ƶ����ʱ��
			if(fullButtom.exists()){ // ȫ����ͣ״̬					
				uiDevice.pressBack();
				System.out.println("exit full screen!" );
					
			}else if(playControl.exists()){ //��ȫ��,��ͣ״̬
				landscapeButton.click();
				System.out.println("switch to full screen!" );
						
			}else{  // ����״̬
				UiObject videoLayout = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/videoLayout").className("android.widget.RelativeLayout"));
				if(videoLayout.exists()){
					videoLayout.click();
					sleep(2000);
					UiObject fulllandscapeBottom =  new UiObject(new UiSelector().resourceId("com.qiyi.video:id/player_landscape_bottom_area"));  	
					if(fulllandscapeBottom.exists()){  // 	ȫ��
						uiDevice.pressBack();
						System.out.println("exit full screen!" );	
					}else{					
						landscapeButton.click();
						System.out.println("switch to full screen!" );
					}								
						
				}				
					
			}							
			
		}
		
	}
	
	void stopbeginSwitch() throws UiObjectNotFoundException{
			
		UiObject adsplayer = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_adsPlayer")); // ��� ��ͣor����
		UiObject pause = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_pause"));  // ��Ƶ ��ͣ or ��ʼ
		UiObject fullPause = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/player_landscape_pauseBtn"));
		
		UiObject playControl = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/playControlMainLayout"));
		
		UiObject fullButtom = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/player_landscape_bottom_area"));
		
		
		UiObject adsBottom =  new UiObject(new UiSelector().resourceId("com.qiyi.video:id/btn_adsBottom"));  
		if(adsBottom.exists()){  // ��沥��ʱ��, bottom������һֱ����
			adsplayer.click();
			System.out.println("ads is is playing!" );
			
		}else{  // ��Ƶ����ʱ��
			if(fullButtom.exists()){ // ȫ����ͣ״̬
				
				fullPause.click();
				System.out.println("full screen and begin the video!" );
				
			}else if(playControl.exists()){ //��ȫ����ͣ״̬
					pause.click();
					System.out.println("begin the video!" );
					
			}else{  // ����״̬
				UiObject videoLayout = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/videoLayout").className("android.widget.RelativeLayout"));
				if(videoLayout.exists()){
					videoLayout.click();
					sleep(2000);
					
					UiObject fulllandscapeBottom =  new UiObject(new UiSelector().resourceId("com.qiyi.video:id/player_landscape_bottom_area"));  
					if(fulllandscapeBottom.exists()){
						fullPause.click();
						System.out.println("full screen and stop the video!" );
						
					}else{
						pause.click();
						System.out.println("stop the video!" );
						
					}
					
				}
				
				
			}
					
		}
		
	}
	
	
    void searchandWatchVideo(String some) throws UiObjectNotFoundException{  
    	UiObject searchText = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/titleIndexSearchImage"));
		searchText.clickAndWaitForNewWindow();
		
		UiObject searchEdittext = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phoneSearchKeyword").clickable(true));
		searchEdittext.setText(some);
		
		UiObject searchSubmit = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phoneSearchSubmit"));
		searchSubmit.clickAndWaitForNewWindow();
				
		UiObject watchnow = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phone_search_result_adapter_first_btn"));
		if(watchnow.exists()){
			watchnow.click();
		}
			
		sleep(10000);  // ���ʱ��
		landscapeSwitch();   // ȫ��
		//stopbeginSwitch();  // ��ͣ
		sleep(2000);
		//stopbeginSwitch();  // ��ʼ
		landscapeSwitch();   // �˳�ȫ��
		sleep(2000);
		landscapeSwitch();   // ȫ��
		
		sleep(100000);  // ��Ƶ����ʱ��
		stopbeginSwitch(); //��ͣ
		sleep(2000); 
		landscapeSwitch(); // �˳�ȫ��
		sleep(2000); 
		stopbeginSwitch();  // ��ʼ
		
		//�����������Ƶ������Ȼ����
	}
	
    void watchDownloadedVideo() throws UiObjectNotFoundException{  
    	
    	UiObject downloadTitle = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/titleDownloadLayout"));
    	downloadTitle.clickAndWaitForNewWindow();
    	
    	UiObject downloadList = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phone_download_list"));
    	int num = downloadList.getChildCount();
    	if(num > 1){
    		UiObject oneitems = downloadList.getChild(new UiSelector().resourceId("com.qiyi.video:id/phone_download_list_item_layout").className("android.widget.RelativeLayout").index(num-1));
    		oneitems.clickAndWaitForNewWindow();
    	
    		UiObject downloadItemList = new UiObject(new UiSelector().resourceId("com.qiyi.video:id/phone_download_list"));
    		int itemnum = downloadItemList.getChildCount();
    		UiObject oneitem = downloadItemList.getChild(new UiSelector().resourceId("com.qiyi.video:id/phone_download_list_item_layout").className("android.widget.RelativeLayout").index(itemnum-1));
    		oneitem.clickAndWaitForNewWindow();
    		//ֻ��ȫ���ۿ�
    	
    		sleep(5000); 
    		stopbeginSwitch(); //��ͣ
    		sleep(2000); 
    		stopbeginSwitch();  // ��ʼ
		
    		//�����������Ƶ������Ȼ����
    	}else{
    		
    		System.out.println("There exists no downloaded video!" );
    	}
    	
    }
    
	

}
