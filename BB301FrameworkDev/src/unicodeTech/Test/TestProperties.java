package unicodeTech.Test;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProperties {

	
	public static void main(String[] args) {

		//System.out.println(System.getProperty("user.dir"));
		
		Logger log = Logger.getLogger("devpinoyLogger");
		
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://localhost/uth/readers_book/catalog/index.php");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
	
		for(int count=0;count<allLinks.size();count++) {
			

			System.out.println(allLinks.get(count).getText());
		}
	
		
		
	}

}
