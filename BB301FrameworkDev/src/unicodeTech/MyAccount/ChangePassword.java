package unicodeTech.MyAccount;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class ChangePassword extends ChildClassMyAccount{

	

	@BeforeTest
	public void checkTestCase() {
		
		boolean output = MyMethods.checkExecutionModeTestCase(myaccount, "TestCases", this.getClass().getSimpleName());

		if(!output) {
	
			throw new SkipException("Execution mode of the testcase "+this.getClass().getSimpleName()+" is set to NO");
		}
	}
	
	
	@Test
	public void testChangePwd() {
		
		MyMethods.signIN("demo@unicodetechnologies.in","unicode");
		
		verifyXpathPropVal("btn_myaccount_xpath").click();
		verifyXpathPropVal("lnk_changePwd_xpath").click();
		verifyNamePropVal("ip_currentPwd_name").sendKeys("unicode");
		verifyNamePropVal("ip_newPwd_name").sendKeys("unicode123");
		verifyNamePropVal("ip_retypePwd_name").sendKeys("unicode123");
		verifyIDPropVal("btn_continue_pwd_id").click();
		
		logs.info("Password has been changed...");
		
		MyMethods.signOUT();
		
		logs.info("Login with new password");
		MyMethods.signIN("demo@unicodetechnologies.in","unicode123");
		
		verifyXpathPropVal("btn_myaccount_xpath").click();
		verifyXpathPropVal("lnk_changePwd_xpath").click();
		verifyNamePropVal("ip_currentPwd_name").sendKeys("unicode123");
		verifyNamePropVal("ip_newPwd_name").sendKeys("unicode");
		verifyNamePropVal("ip_retypePwd_name").sendKeys("unicode");
		verifyIDPropVal("btn_continue_pwd_id").click();
		
		logs.info("Password has been reset");
		
		
		MyMethods.signOUT();
		
		
	}
}
