package myFirstTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableTestMethods {

	static AndroidDriver <MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		URL url =new URL ("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<MobileElement> (url, capabilities);
		Thread.sleep(2000);
		clickView("Views");
		Thread.sleep(2000);
//		scrollUp();
//		Thread.sleep(2000);
		clickView("Switches");
		//	       
		//	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Buttons']")).click();
		//	        Thread.sleep(2000);
		//	        driver.findElement(By.xpath("//android.widget.ToggleButton[@content-desc='Toggle']")).click();
		//	        Thread.sleep(2000);
		//	        driver.findElement(By.xpath("//android.widget.ToggleButton[@content-desc='Toggle']")).click();
		Thread.sleep(360000);
		//	        System.out.println("Test Complete");

	}

	public static void clickView(String viewName) {
		System.out.println("Clicking on "+viewName);
		boolean flgFound = false;
		while (!flgFound) {
			try {
				MobileElement clkView = driver.findElement(By.xpath("//android.widget.TextView[@text='"+viewName+"']"));
				clkView.click();
				//android.widget.TextView[@content-desc='Views']
				flgFound = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found in this scroll");
			}
		
//			List<MobileElement> lstViews = driver.findElements(By.xpath
//					("//android.widget.TextView"));
//			for (MobileElement crntView : lstViews) {
//				if (crntView.getAttribute("text").equalsIgnoreCase(viewName)) {
//					crntView.click();
//					flgFound = true;
//					break;
//				}
//			}
			if(!flgFound) {
				scrollUp();
			}
		}
	}
	public static void scrollUp() {
		//		HT
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		//		WD


		//		startY = ht * 0.9
		int strtY = (int)(height * 0.9);
		//		endY = ht * 0.1
		//		srtX = wd * 0.5
		int endY = (int)(height * 0.1);

		int strtX = (int)(width * 0.5);


		TouchAction action = new TouchAction((MobileDriver)driver);
		action
		.longPress(PointOption.point(strtX, strtY))
		.moveTo(PointOption.point(strtX, endY))
		.release()
		.perform();

	}


}
