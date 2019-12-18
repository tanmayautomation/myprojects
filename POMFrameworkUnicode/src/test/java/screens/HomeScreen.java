package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase{

	@AndroidFindBys({ 
		@AndroidFindBy(className="android.widget.LinearLayout"),
		@AndroidFindBy(className="android.widget.Button"),
	
	})
	public List<WebElement> buttonCount;
	
	
	@AndroidFindBy(id="com.gsrtc.mobileweb:id/advance_booking_btn")
	public WebElement advanceBooking;
	
	@AndroidFindBy(id="com.gsrtc.mobileweb:id/current_booking_btn")
	public WebElement currentBooking;
	
	@AndroidFindBy(id="com.gsrtc.mobileweb:id/track_my_bus_btn")
	public WebElement trackMyBus;
	
	
	
	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS), this);
	}

	public void validateButtonCount() {
		
		buttonCount.size();
	}
	
	
	public AdvanceBookingScreen advanceBooking() {
		
		advanceBooking.click();
		
		return new AdvanceBookingScreen(driver);
	}
	
	public void currentBooking() {
		
		currentBooking.click();
	}
	
	public void trackMyBus() {
		
		trackMyBus.click();
	}

}
