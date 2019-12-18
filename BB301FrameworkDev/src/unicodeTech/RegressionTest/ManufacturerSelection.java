package unicodeTech.RegressionTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class ManufacturerSelection extends ChildClassRegressionTest {

	@BeforeTest
	public void checkTestCase() {
		
		boolean output = MyMethods.checkExecutionModeTestCase(regressiontest, "TestCases", this.getClass().getSimpleName());

		if(!output) {
	
			throw new SkipException("Execution mode of the testcase "+this.getClass().getSimpleName()+" is set to NO");
		}
	}
	
	
	@Test
	public void testManufacturers() {

		driver.get(sitedata.getProperty("url"));

		WebElement manufacturers = verifyXpathPropVal("dd_manufacturers_xpath");
		List<WebElement> manuValues = manufacturers.findElements(By.tagName("option"));

		for (int count = 0; count < manuValues.size(); count++) {

			String text = manuValues.get(count).getText();
			
			if(text.equalsIgnoreCase("Spiritual Books")) {
				
				manuValues.get(count).click();
				break;
			}
			
			
		}
	}
}
