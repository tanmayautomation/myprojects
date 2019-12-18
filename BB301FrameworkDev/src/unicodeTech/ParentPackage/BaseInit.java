package unicodeTech.ParentPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

public class BaseInit {

	public static WebDriver driver=null;
	public static Properties sitedata = null;
	public static Logger logs = null;
	public static XLSDatatable_Connectivity testsuite=null;
	public static XLSDatatable_Connectivity myaccount=null;
	public static XLSDatatable_Connectivity regressiontest=null;
	
	
	public void startUP() throws IOException {
		
		if(driver==null) {
		
		logs = Logger.getLogger("devpinoyLogger");
		
		logs.info("Properties file is loading now..");
		
		sitedata = new Properties(); //1st step
		//FileInputStream fi = new FileInputStream("D:\\Batches\\BB301\\AutomationFramework\\BB301FrameworkDev\\src\\unicodeTech\\PropertiesData\\SiteData.properties");
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\unicodeTech\\PropertiesData\\SiteData.properties");
		sitedata.load(fi);  //3rd Step
		
		logs.info("Properties file loaded successfully..");

		
		String browserName = sitedata.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			logs.info("Firefox browser launched..");

		}else if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			logs.info("Chrome browser launched..");

		
		}else if(browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logs.info("IE browser launched..");

		
		}
		
		/*
		Options os = driver.manage();
		Window w = os.window();
		w.maximize();
		*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		testsuite = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"\\src\\unicodeTech\\XLSFiles\\TestSuite.xlsx");
		myaccount = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"\\src\\unicodeTech\\XLSFiles\\MyAccount.xlsx");
		regressiontest = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"\\src\\unicodeTech\\XLSFiles\\RegressionTest.xlsx");
		
		logs.info("Excel File objects created");

		}
	}
	
	public static WebElement verifyXpathPropVal(String xpathVal) {
		
		try {
			
			return driver.findElement(By.xpath(sitedata.getProperty(xpathVal)));
			
		}catch(Throwable t) {
			
			logs.info("Xpath Value not found in the properties file");
			
			return null;
		}
	}
	
	
public static WebElement verifyNamePropVal(String nameVal) {
		
		try {
			
			return driver.findElement(By.name(sitedata.getProperty(nameVal)));
			
		}catch(Throwable t) {
			
			logs.info("Name Value not found in the properties file");

			return null;
		}
	}
	

public static WebElement verifyIDPropVal(String idVal) {
	
	try {
		
		return driver.findElement(By.id(sitedata.getProperty(idVal)));
		
	}catch(Throwable t) {
		
		logs.info("ID Value not found in the properties file");

		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
}
