package AutoRunner;


import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
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
    	
    	// 获取屏幕大小
    	int height = getUiDevice().getDisplayHeight();
    	int width = getUiDevice().getDisplayWidth();
    	if(!getUiDevice().isScreenOn()){			 
    		getUiDevice().wakeUp();  // 唤醒		
    		//等待3秒  
    		try{  
    			Thread.sleep(3000);  
    	    } catch(InterruptedException e1) {  
    			e1.printStackTrace();  
    	    }  
    		// 划屏，解锁
    		getUiDevice().swipe(width/2, (int)(height*0.7), width/2, (int)(height*0.1), 5);  
    	}
    	//等待3秒  
    	try {  
    		Thread.sleep(3000);  
    	} catch (InterruptedException e1) {  
    		 e1.printStackTrace();  
    	}  
     

    	AppStoreOperation AppStore = new AppStoreOperation(getUiDevice());
    	AppStore.openAppstore();
    	
    	AppStore.DownloadOrOpen("IN");
		sleep(1000);		 
		AppStore.DownloadOrOpen("TempleRun");
		sleep(1000);	 
		AppStore.updateApps();		 
		getUiDevice().pressHome();
    	
    	
		FilemanagerOperation FileManager = new FilemanagerOperation(getUiDevice());
		FileManager.openFilemanager();
		FileManager.deleteAllApks();	
		FileManager.copyAllImages();
		getUiDevice().pressHome();
		
		
		iMusicOperation iMusic = new iMusicOperation(getUiDevice());
		iMusic.openiMusic();
		UiObject nosongsIndicate = new UiObject(new UiSelector().resourceId("com.android.bbkmusic:id/nosongtext"));
		if(nosongsIndicate.exists()){
			
			System.out.println("There is no songs in this phone");
			iMusic.SearchandDownloadSong("See You Again");
			sleep(1000);					
			iMusic.SearchandDownloadSong("mygod");
			sleep(1000);
			iMusic.SearchandDownloadSong("Better");
			sleep(1000);
			iMusic.SearchandDownloadSong("You Raise Me Up");
			sleep(1000);
			iMusic.SearchandDownloadSong("haha");
					
		}else{
			
			iMusic.SearchandPlaySong("hha");
			sleep(1000);
			iMusic.SearchandPlaySong("Better");
			 
			iMusic.SearchandDownloadSong("Nothing");
			 
			iMusic.PlaySongRandomly(); 
			
		}		
		getUiDevice().pressHome();
		
		
		WeiboOperation Weibo = new WeiboOperation(getUiDevice());
		Weibo.openWeibo();	 
		Weibo.update();			 
		Weibo.scanHomepage();			 
		Weibo.scanFriendcircle();		
		Weibo.scanMyWeibo();		
		Weibo.shareSomething();		
		Weibo.clearCache();		
		getUiDevice().pressHome();
		
    	
    	QQOperation QQ = new QQOperation(getUiDevice());
    	QQ.openQQ();	
		QQ.update();	
		QQ.readUnreadmsg();	
		QQ.scanQQZone();	
		QQ.accountSetting();		
		QQ.addsomeone("772097770");		
		getUiDevice().pressHome();
		
		
		WeichatOperation Weichat = new WeichatOperation(getUiDevice());
		Weichat.openWeiChat();		
		Weichat.readUnreadmsg();	
		Weichat.scanMyPosts();	
		Weichat.scanFriendCircle(10);		
		Weichat.saySomething("JUST FOR TESTING!");	
		Weichat.readUnreadSubscription(); 
		getUiDevice().pressHome();
		
		CameraOperation Camera = new CameraOperation(getUiDevice());
		Camera.openCamera();		
		Camera.takePhotoWithModule("Beauty");
		sleep(2000);	
		Camera.takeVideoWithTime(5);   // 录制5秒	
		getUiDevice().pressHome();
		
		
		AlbumsOperation Albums = new AlbumsOperation(getUiDevice());
		Albums.openAlbums();	
		Albums.scanGallery();	
		getUiDevice().pressHome();
		
		
		baiduOperation baidu = new baiduOperation(getUiDevice());		
		baidu.openBaidu();		
		baidu.searchSomething("haha");
		sleep(3000);
		baidu.changeSkin(10); 		
		getUiDevice().pressHome();
		
		
    	AiqiyiOperation Aiqiyi = new AiqiyiOperation(getUiDevice());
    	Aiqiyi.openAiqiyi();
		Aiqiyi.searchandDownloadVideo("woqushangxue");	
		Aiqiyi.searchandWatchVideo("jixiantiaozhan");	
			
		//Aiqiyi.watchDownloadedVideo();
    	
    	
    	
    
    	
    	
    	
          
         
    }  
}  
