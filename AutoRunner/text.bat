

D:

cd %ANDROID_HOME%\tools
 
 
android create uitest-project -n AutoRunner -t 1 -p D:\Develop\android\UiAutomator
 
cd D:\Develop\android\UiAutomator

ant build
 
adb push D:\Develop\android\UiAutomator\bin\AutoRunner.jar data/local/tmp
 
adb shell uiautomator runtest AutoRunner.jar -c AutoRunner.Test1



cd %ANDROID_HOME%\tools

uiautomatorviewer 

adb devices


adb logcat -v time -s ActivityManager

adb logcat -v time -b events

adb logcat -v time -s AndroidRuntime

