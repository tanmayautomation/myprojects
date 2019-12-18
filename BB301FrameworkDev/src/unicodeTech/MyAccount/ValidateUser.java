package unicodeTech.MyAccount;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class ValidateUser extends ChildClassMyAccount{


	@BeforeTest
	public void checkTestCase() {
		
		boolean output = MyMethods.checkExecutionModeTestCase(myaccount, "TestCases", this.getClass().getSimpleName());

		if(!output) {
	
			throw new SkipException("Execution mode of the testcase "+this.getClass().getSimpleName()+" is set to NO");
		}
	}
	
	
	@Test(dataProvider="getTestDataFromXLS")
	public void testValidateUser(String username, String password) throws InterruptedException {
		
		MyMethods.signIN(username,password);
		Thread.sleep(2000);
		MyMethods.signOUT();
	}
	
	
	@DataProvider //- return 3 rows and 2 columns
	public Object[][] getTestDataFromXLS() {
		
		return MyMethods.getTestData(myaccount, "ValidateUser");
		
	}
	
	
	
	
	
	
	
	
}
