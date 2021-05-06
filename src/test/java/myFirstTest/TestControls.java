package myFirstTest;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TestControls {

	AndroidDriver <MobileElement> driver;

	@Before
	public void setUp() throws Exception {
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
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Light Theme']")).click();
	        Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
	}




	@Test
	public void testcheckbox(){

		List<MobileElement> lstchbox = driver.findElements(By.xpath("//android.widget.CheckBox"));
		for (MobileElement chkbox : lstchbox) {
			if (chkbox.getAttribute("text").equalsIgnoreCase("Checkbox 1")) {
				chkbox.click();
				}
				else {
					System.out.println("Test FAIL");
				}
			}
		}
			

	@Test
	public void testRadioButton() {

		List<MobileElement> lstrdbtn = driver.findElements(By.xpath("android.widget.RadioButton"));
		for (MobileElement rdbtn : lstrdbtn) {
			if (rdbtn.getAttribute("text").equalsIgnoreCase("RadioButton 1")) {
				rdbtn.click();
			}
			else {
				System.out.println("Test FAIL");
			}
		}
	}


		


		}
