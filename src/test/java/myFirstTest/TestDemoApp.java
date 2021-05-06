package myFirstTest;

import static org.junit.Assert.*;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
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

public class TestDemoApp {

	AndroidDriver <MobileElement> driver;
	//AppiumDriver<MobileDriver<WebElement>>

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
	}

	@After
	public void tearDown() throws Exception {
	}




	//@Test
	public void testSeekBar() throws InterruptedException {

		MobileElement reqdRdBtn = null;
		boolean flgFound = false;
		clickView("Views");
		clickView("Seek Bar");
		Thread.sleep(1000);
		MobileElement weSB = driver.findElement(By.xpath("//android.widget.SeekBar"));
		int width = weSB.getSize().getWidth();
		int strtX = weSB.getLocation().getX();
		int posY = weSB.getLocation().getY();
		int endX = strtX + (int)(width*0.5);

		TouchAction action = new TouchAction((MobileDriver)driver);
		action
		.longPress(PointOption.point(strtX, posY))
		.moveTo(PointOption.point(endX, posY))
		.release()
		.perform();

		WebElement touchbar=driver.findElementByClassName("android.widget.SeekBar");
		System.out.println(touchbar.getText());


		if(touchbar.getText().equals("50.0")) {
			System.out.println("Test PASS, 50% width is displayed");
		}
		else {
			System.out.println("Test FAIL");
		}

	}


	//@Test
	public void testRadioButton() {

		MobileElement reqdRdBtn = null;
		boolean flgFound = false;
		clickView("Views");
		clickView("Radio Group");
		List<MobileElement> lstRDBtn = driver.findElements(By.xpath("//android.widget.RadioButton"));
		for (MobileElement RdBtn : lstRDBtn) {
			if (RdBtn.getAttribute("text").equalsIgnoreCase("Snack")) {
				RdBtn.click();
				flgFound = true;
				reqdRdBtn = RdBtn;
				break;
			}


		}


		if(!flgFound) {

			fail("Radio button was not found");
		}


		if (flgFound) {
			String strChecked = reqdRdBtn.getAttribute("checked");
			System.out.println("Checked return value is "+strChecked);
			if (!strChecked.equals("false")) {

				fail("Reqd radio button was checked");
			}
		}


		//android.widget.RadioButton[@text='Dinner']
		//checked
		//		Snack
	}




	public void clickView(String viewName) {
		System.out.println("Clicking on "+viewName);
		boolean flgFound = false;
		while (!flgFound) {
			try {
				MobileElement clkView = driver.findElement(By.xpath("//android.widget.TextView[@text='"+viewName+"']"));
				clkView.click();
				Thread.sleep(2000);
				//android.widget.TextView[@content-desc='Views']
				flgFound = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found; scroll in progress");
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
	public void scrollUp() {
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



	//@Test
	public void Light_Theme() throws InterruptedException {
		clickView("Views");
		clickView("Controls");
		clickView("1. Light Theme");

		MobileElement FirstName = driver.findElement(By.xpath("//android.widget.EditText[@text='hint text']"));
		MobileElement LastName = driver.findElement(By.xpath("//android.widget.Button[@text='Save']"));

		MobileElement chkbox1 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']"));
		chkbox1.click();
		MobileElement chkbox2 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 2']"));
		chkbox2.click();
		MobileElement rdbtn1 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 1']"));
		rdbtn1.click();
		System.out.println("Naresh");
		Thread.sleep(5000);
		MobileElement starIcon = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='io.appium.android.apis:id/star']"));
		starIcon.click();
		FirstName.sendKeys("Naresh");
		LastName.click();
		System.out.println("Khadka");
		
		
		//((MobileDriver)driver).hideKeyboard();
		//driver.navigate().back();
		
		
		if (!chkbox2.getAttribute("checked").equals("true")) {
			chkbox2.click();
		} else {
			System.out.println("Already Checked");
		}
		System.out.println("Test Done");
		
		Thread.sleep(9000);
		
		//Verify
		
		String strFirstName =FirstName.getText();
		String box1=chkbox1.getAttribute("checked");
		String rdbutton1 = rdbtn1.getAttribute("checked");
		String icon =starIcon.getAttribute("checked");
		
		
		Assert.assertEquals(strFirstName, "Naresh", "First Name validated");
		Assert.assertEquals(box1, "true", "Dropdown value validated");
		Assert.assertEquals(rdbutton1, "false", "Act Chkbx value validated");
		
		System.out.println("Test Done1");

		
		//Assert.assertEquals("Pass", strFirstName, "Naresh");
		//Assert.assertEquals(strFirstName, "Naresh", "FirstName validated");
		//Assert.assertEquals(rdbutton1,"checked" , " button checked");
		//Assert.assertEquals(box1,"false" , " box checked");
		
		}
	
	@Test
	public void testDate() throws ParseException, InterruptedException {
		
		clickView("Views");
		//clickView("Controls");
		clickView("Date Widgets");
		clickView("1. Dialog");
		
		String eDate = "10-21-2021";
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		
		 java.util.Date date = format.parse(eDate);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("Expected Date is ");
		System.out.println(localDate.getMonthValue());
		
		MobileElement actDateelement = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/dateDisplay']"));
	    String actDate = actDateelement.getText();
        System.out.println("Act date is ");
        System.out.println(actDate);
        String[] arrdtAct = actDate.split("-");
        System.out.println("Act Month is ");
        System.out.println(arrdtAct[0]);
        driver.findElement(By.xpath("//android.widget.Button[@text='change the date']")).click();
        int intDiff = localDate.getMonthValue() - Integer.parseInt(arrdtAct[0]) ;
        System.out.println("Difference in Month is "+intDiff);
        if(intDiff > 0) {
        	
        	for (int cnt = 0; cnt < intDiff; cnt++) {
        		Thread.sleep(1000);
        		driver.findElement(By.xpath("//*[@content-desc='Next month']")).click();
        		
        		System.out.println("The month now is displayed as October ");
				
			}
        }
        
        
        Thread.sleep(5000);
        

		
		/*
		 * //driver.findElement(By.
		 * xpath("//android.widget.Button[@text='change the date']")).click();
		 * MobileElement actDateelement = driver.findElement(By.xpath(
		 * "//android.widget.TextView[@resource-id='io.appium.android.apis:id/dateDisplay']"
		 * )); System.out.println(actDateelement.getText());
		 * 
		 * 
		 * driver.findElement(By.
		 * xpath("//android.widget.Button[@text='change the date']")).click();
		 * Thread.sleep(3000);
		 * 
		 * driver.findElement(By.
		 * xpath("//android.widget.ImageButton[@content-desc='Next month']")).click();
		 * Thread.sleep(3000);
		 * 
		 * 
		 * 
		 * 
		 * String eDate = "06-21-2021"; SimpleDateFormat format = new
		 * SimpleDateFormat("MM-dd-yyyy");
		 * 
		 * java.util.Date date = format.parse(eDate); LocalDate localDate =
		 * date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 * System.out.println("Month is ");
		 * System.out.println(localDate.getMonthValue());
		 */
               
		
				
	}

}
