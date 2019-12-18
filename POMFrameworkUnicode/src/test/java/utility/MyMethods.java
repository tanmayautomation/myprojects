package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyMethods {

	
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PACKAGE;
	public static String BASE_ACTIVITY;
	public static String DEVICE_NAME;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String APPIUM_PORT;
	public static String APP_PATH;
	
	public static Properties pro = new Properties();
	public static DesiredCapabilities capability = new DesiredCapabilities();
	public static AppiumDriver<MobileElement> driver;
	public static URL serverURL;
	
	
	public static void loadPropertiesFile(String propFileName) throws IOException {
		
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+propFileName);
		pro.load(fi);
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(pro.getProperty("implicitWait"));
		//EXPLICIT_WAIT_TIME = Integer.parseInt(pro.getProperty("implicitWait"));
		APP_PATH =pro.getProperty("application.path");
		BASE_PACKAGE =pro.getProperty("base.pkg");
		BASE_ACTIVITY =pro.getProperty("package.activity");
		DEVICE_NAME =pro.getProperty("device.name");
		BROWSER_NAME =pro.getProperty("browser.name");
		PLATFORM_NAME =pro.getProperty("platform.name");
		PLATFORM_VERSION =pro.getProperty("platform.version");
		APPIUM_PORT =pro.getProperty("appium.port");
		System.out.println(IMPLICIT_WAIT_TIME);
		System.out.println(APP_PATH);
		System.out.println(BASE_PACKAGE);
		System.out.println(BASE_ACTIVITY);
		System.out.println(DEVICE_NAME);
		System.out.println(BROWSER_NAME);
		System.out.println(PLATFORM_NAME);
		System.out.println(PLATFORM_VERSION);
		System.out.println(APPIUM_PORT);
		
		
	}
	
	public static void setAndroidCapability() {
		
		//capability.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		//capability.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		//capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PACKAGE);
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, BASE_ACTIVITY);

		
	}
	
	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException{
		
		serverURL = new URL("http://localhost:"+APPIUM_PORT+"/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverURL,capability);
		
		return driver;
	}
}
