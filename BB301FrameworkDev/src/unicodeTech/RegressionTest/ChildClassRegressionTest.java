package unicodeTech.RegressionTest;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import unicodeTech.ParentPackage.BaseInit;
import unicodeTech.Utility.MyMethods;

public class ChildClassRegressionTest extends BaseInit{

	
	@BeforeSuite
	public void checkTestSuite() throws IOException {
		
		startUP();

		boolean output = MyMethods.checkExecutionModeTestSuite(testsuite, "TestSuite", "RegressionTest");
		
		if(!output) {
			
			throw new SkipException("Execution mode of the testsuite RegressionTest is set to NO");
		}
	}
}
