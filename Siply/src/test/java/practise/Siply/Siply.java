package practise.Siply;
//This is Extent report 
//This application is not for automation testing, so there is no much elements to perform some actions, in some place used coordinates to perform task 

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import practise.Sip.cap3;


public class Siply extends cap3{
	
	ExtentReports extent;
	ExtentTest logger;
	String MN = "9876754557";
	
	@BeforeTest
	public void killAllProcess() throws IOException, InterruptedException
	{
		//i am ensuring before any of my test starts if the appium server is up and running
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
		service = startServer();
		extent = new ExtentReports(System.getProperty("user.dir")+"//Test_Output//SiplyTestReport.html",true);
		extent.addSystemInfo("User Name", "Venugopala");
		extent.assignProject("Siply");
		extent.loadConfig(new File (System.getProperty("user.dir")+"//src//main//resources//extent-config.xml"));
		
	}
		
	@Test(priority = 0)
	public void Registration() throws IOException, InterruptedException
	{
		
		logger = extent.startTest("Registration");
		 
		
		AndroidDriver<AndroidElement> driver = HybridCapability(apppackage, appactivity, platformName, deviceName);
		//is to implement implicitwait 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
			logger.log(LogStatus.PASS, "Mobile App Opened");
			Object ele = driver.findElementByClassName("android.widget.EditText");
			((WebElement) ele).click();
			((WebElement) ele).sendKeys(MN);
			driver.hideKeyboard();
			logger.log(LogStatus.INFO, "Entered Mobile No. "+ MN);
			
			Thread.sleep(3000);
			driver.findElementByAccessibilityId("Continue").click();
			logger.log(LogStatus.PASS, "Clicked on Continue button");
			
			TouchAction action = new TouchAction(driver);
			Thread.sleep(9000);
			//there is no any interactive elements to use send keys
	        action.tap(PointOption.point(146, 1800)).perform();
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
	        logger.log(LogStatus.INFO, "OTP Entered");
	        
	        driver.findElementByClassName("android.widget.CheckBox").click();
	        logger.log(LogStatus.INFO, "Agreed Terms and conditions");
	        
	        
	        driver.findElementByAccessibilityId("Verify OTP").click();
	        logger.log(LogStatus.PASS, "Clicked on verify OTP button");
	       
	        Thread.sleep(5000);
	        driver.findElementByAndroidUIAutomator("text(\"Enter Name\")").click();
	        driver.findElementByAndroidUIAutomator("text(\"Enter Name\")").sendKeys("User");
	 
	        logger.log(LogStatus.INFO, "Entered Username");
	
	        
	        driver.findElementByAccessibilityId("   Select State").click();
	        Thread.sleep(2000);
	        //there is no such element to use scroll to element statement
	        Dimension dimension = driver.manage().window().getSize();
	        int startx = (int) (dimension.width * 0.5);
	        int starty = (int) (dimension.height * 0.6);
	        
	        int endx = (int) (dimension.width * 0.5);
	        int endy = (int) (dimension.height * 0.2);
	        
	        TouchAction act = new TouchAction(driver);
	        act.press(PointOption.point(startx,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, endy)).release().perform();
	        Thread.sleep(2000);
	        driver.findElementByAccessibilityId("Karnataka").click();
	        
	        Thread.sleep(2000);
	        if (driver.findElementByAccessibilityId("Complete Registration").isEnabled())
		       {
	        	driver.findElementByAccessibilityId("Complete Registration").click();
		    	logger.log(LogStatus.PASS, "Clicked on Complete Registration button");
		       }
		       else 
		        logger.log(LogStatus.FAIL, "Clicked on Complete Registration button");
		    
	        Thread.sleep(12000);
	        String name = driver.findElementsByClassName("android.widget.ImageView").get(0).getText();
	        logger.log(LogStatus.PASS, "Home page displayed "+name);
	        Thread.sleep(5000);
	        driver.quit();
	}
	
	
	@Test(priority = 1)
	public void Chits_Basic_flow() throws InterruptedException, IOException
	{
		
		logger = extent.startTest("Basic flow of Chits");
		 
		
		AndroidDriver<AndroidElement> driver = HybridCapability(apppackage, appactivity, platformName, deviceName);
		//is to implement implicitwait 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
			logger.log(LogStatus.PASS, "Mobile App Opened");
			Object ele = driver.findElementByClassName("android.widget.EditText");
			((WebElement) ele).click();
			((WebElement) ele).sendKeys(MN);
			logger.log(LogStatus.INFO, "Entered Mobile No. "+ MN);
			
			Thread.sleep(3000);
			driver.findElementByAccessibilityId("Continue").click();
			logger.log(LogStatus.PASS, "Clicked on Continue button");
			
			TouchAction action = new TouchAction(driver);
			Thread.sleep(9000);
	        action.tap(PointOption.point(146, 1800)).perform();
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
	        logger.log(LogStatus.PASS, "OTP Entered");
	        
	        driver.findElementByAccessibilityId("Verify OTP").click();
	        logger.log(LogStatus.PASS, "Clicked on verify OTP button");
	        
	        Thread.sleep(12000);
	        driver.findElementByXPath("(//android.view.View[@content-desc=\"Know More\"])[1]").click();
	        logger.log(LogStatus.PASS, "Clicked on Siply Chits");
	        
	        Thread.sleep(6000);
	        driver.findElementsByClassName("android.widget.Button").get(0).click();
	        logger.log(LogStatus.INFO, "Ads");
	        
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("Explore Plans").click();
	        logger.log(LogStatus.PASS, "Clicked on Explore Plans button");
	        Thread.sleep(5000);
	     
	        driver.findElementsByClassName("android.view.View").get(0).click();
	        if(driver.findElementsByClassName("android.view.View").get(0).isEnabled())
	        {
	        	logger.log(LogStatus.PASS, "Selected a chit plan");
	        }
	        else {
	        	logger.log(LogStatus.FAIL, "Selected a chit plan");
			}
	        
	       if (driver.findElementByAccessibilityId("Complete Your KYC").isEnabled())
	       {
	    	   driver.findElementByAccessibilityId("Complete Your KYC").click();
	    	   logger.log(LogStatus.PASS, "Clicked on complete your KYC button");
	       }
	       else 
	            logger.log(LogStatus.FAIL, "Clicked on complete your KYC button");
	       Thread.sleep(3000);
	       
	        
	}  
	
	@AfterMethod
	public void method(ITestResult result)
    {
    	if (result.getStatus()==ITestResult.FAILURE)
		{
			 logger.log(LogStatus.FAIL, "Test case failed "+result.getName());
			 logger.log(LogStatus.FAIL, "Test case failed "+result.getThrowable());
			 
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			 logger.log(LogStatus.SKIP, "Test case failed "+result.getName());
			 logger.log(LogStatus.SKIP, "Test case failed "+result.getThrowable());
		}
    	extent.endTest(logger);
		
		
	}
	@AfterTest
	public void AT()
	{

		
		extent.flush();
		extent.close();
		
	}
}





