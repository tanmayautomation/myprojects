package unicodeTech.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

import unicodeTech.ParentPackage.BaseInit;

public class MyMethods extends BaseInit{

	
	public static void signIN(String username, String password) {
		
		driver.get(sitedata.getProperty("url"));
		//driver.findElement(By.xpath(sitedata.getProperty("lnk_signIn"))).click();
		verifyXpathPropVal("lnk_signIn").click();
		verifyNamePropVal("ip_email_name").sendKeys(username);
		verifyNamePropVal("ip_pwd_name").sendKeys(password);
		verifyIDPropVal("btn_signIn_id").click();
		
	}
	
	public static void signOUT() {
		
		verifyXpathPropVal("btn_signout_xpath").click();

		verifyXpathPropVal("btn_continue_xpath").click();

	}
	
	public static boolean checkExecutionModeTestSuite(XLSDatatable_Connectivity suite, String sheetName, String testSuiteID) {
		
		int rows = suite.totalRow(sheetName);
		
		for(int row=2;row<=rows;row++) {
			
			String suiteName = suite.getData(sheetName, "TestSuiteID", row);
			
			if(suiteName.equalsIgnoreCase(testSuiteID)) {
				
				String exeMode = suite.getData(sheetName, "Execution", row);
				
				if(exeMode.equalsIgnoreCase("y"))
					
					return true;
				else 
					return false;
				
			}
			
		}
		return false;
		
		
	}
	

public static boolean checkExecutionModeTestCase(XLSDatatable_Connectivity testcase, String sheetName, String testCaseID) {
		
		int rows = testcase.totalRow(sheetName);
		
		for(int row=2;row<=rows;row++) {
			
			String testcaseName = testcase.getData(sheetName, "TestCaseID", row);
			
			if(testcaseName.equalsIgnoreCase(testCaseID)) {
				
				String exeMode = testcase.getData(sheetName, "Execution", row);
				
				if(exeMode.equalsIgnoreCase("y"))
					
					return true;
				else 
					return false;
				
			}
			
		}
		return false;
		
		
	}
	
	public static Object[][] getTestData(XLSDatatable_Connectivity data, String sheetName) {
		
		int cols = data.totalColumn(sheetName);
		int rows = data.totalRow(sheetName);
		
		
		Object myData[][] = new Object[rows-1][cols];
		
		for(int row=2;row<=rows;row++) {
			
			for(int col=0;col<cols;col++) {
				
				myData[row-2][col] = data.getData(sheetName, col, row);
				
			}
		}
		
		return myData;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
