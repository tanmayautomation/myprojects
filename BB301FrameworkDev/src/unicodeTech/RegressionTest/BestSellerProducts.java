package unicodeTech.RegressionTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class BestSellerProducts extends ChildClassRegressionTest{

	@BeforeTest
	public void checkTestCase() {
		
		boolean output = MyMethods.checkExecutionModeTestCase(regressiontest, "TestCases", this.getClass().getSimpleName());

		if(!output) {
	
			throw new SkipException("Execution mode of the testcase "+this.getClass().getSimpleName()+" is set to NO");
		}
	}
	
	
	
	
	
	@Test
	public void testBestSellerProducts() {
		
		driver.get(sitedata.getProperty("url"));
		
		WebElement bestSellers = verifyXpathPropVal("div_bestsellers_xpath");
		List<WebElement> bestsellerLinks = bestSellers.findElements(By.tagName("a"));
		
		for(int count=0;count<bestsellerLinks.size();count++) {
			

			logs.info(bestsellerLinks.get(count).getText());
		}
		
		
		
	}
	
}
