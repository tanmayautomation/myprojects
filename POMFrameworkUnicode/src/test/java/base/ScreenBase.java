package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

//This will be the parent class of all screens

public class ScreenBase {

	
	public AppiumDriver<MobileElement> driver;
	
	public ScreenBase(AppiumDriver<MobileElement> driver) {
		
		this.driver=driver;
	}
}
