package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdvanceBookingScreen extends ScreenBase{

	public AdvanceBookingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);

	}
	
	public void searchBus() throws InterruptedException {
		
		driver.findElement(By.id("com.gsrtc.mobileweb:id/from_location")).sendKeys("AHMEDABAD NEHRUNAGAR");
		Thread.sleep(2000);
		driver.findElement(By.id("com.gsrtc.mobileweb:id/to_location")).sendKeys("BARODA AMITNAGAR");
		Thread.sleep(2000);

		driver.findElement(By.id("com.gsrtc.mobileweb:id/onward_date")).sendKeys("15/02/2018");
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.gsrtc.mobileweb:id/adultCount")).sendKeys("2");
		driver.findElement(By.id("com.gsrtc.mobileweb:id/onward_date")).sendKeys("15/02/2018");
		Thread.sleep(2000);
		driver.findElement(By.id("com.gsrtc.mobileweb:id/search_btn")).click();
		
	}

}
