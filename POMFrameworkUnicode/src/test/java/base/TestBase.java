package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.MyMethods;

//This will be the parent class of all testcases

public class TestBase {

	
	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertiesFile = "Android_selendroid.properties";
	//public static XLSDatatable_Connectivity data = new XLSDatatable_Connectivity(system.get);
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUP() throws IOException {
		
		if(driver==null) {
			
			AppiumServer.start();
			log.debug("Appium server started");
			
			
			if(loadPropertiesFile.startsWith("Android")) {
				
				MyMethods.loadPropertiesFile(loadPropertiesFile);
				log.debug("Properties file loaded");
				MyMethods.setAndroidCapability();
				log.info("Setting up android capabilities");
				
				driver = MyMethods.getAndroidDriver();
				log.info("driver returned");
			}
		}
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
		AppiumServer.stop();
	}
}


