package myFirstTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class firstTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver <MobileElement> driver;
		URL url =new URL ("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<MobileElement> (url, capabilities);
		Thread.sleep(2000);
		  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Buttons']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.ToggleButton[@content-desc='Toggle']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.ToggleButton[@content-desc='Toggle']")).click();
	        Thread.sleep(2000);
	        
	        System.out.println("Test Complete");
	        
	        
	        
	}

}
