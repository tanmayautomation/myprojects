package unicodeTech.MyAccount;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import unicodeTech.ParentPackage.BaseInit;
import unicodeTech.Utility.MyMethods;

public class ChildClassMyAccount extends BaseInit{

	@BeforeSuite
	public void checkTestSuite() throws IOException {
		
		startUP();
		boolean output = MyMethods.checkExecutionModeTestSuite(testsuite, "TestSuite", "MyAccount");
		
		if(!output) {
			
			throw new SkipException("Execution mode of the testsuite MyAccount is set to NO");
		}
	}
}
