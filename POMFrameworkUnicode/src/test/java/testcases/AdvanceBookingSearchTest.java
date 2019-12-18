package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.AdvanceBookingScreen;

public class AdvanceBookingSearchTest extends TestBase{

	AdvanceBookingScreen ab;
	
	
	
	@BeforeTest
	public void intialization() {
		
		ab = new AdvanceBookingScreen(driver);
	}
	
	@Test
	public void testAdvanceBookingSearchTest() throws InterruptedException {
		
		ab.searchBus();
		
	}
}
