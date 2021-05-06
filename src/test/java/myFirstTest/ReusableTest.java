package myFirstTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ReusableTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver <MobileElement> driver;
		URL url =new URL ("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "com.google.android.deskclock");
		capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");
		driver = new AndroidDriver<MobileElement> (url, capabilities);
		
		Thread.sleep(5000);
		  driver.findElement(By.xpath("//android.widget.TextView[@text='Stopwatch']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
	        Thread.sleep(5000);
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@text='Clock']")).click();
	        Thread.sleep(2000);
	        
	        
	}

}
