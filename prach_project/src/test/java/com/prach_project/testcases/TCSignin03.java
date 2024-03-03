package com.prach_project.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.prach_project.pageobject.Accountcreationpage;
import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Loginpage;
import com.prach_project.pageobject.Signinpage;

public class TCSignin03 extends Baseclass {

	
	@Test
	public void accountCreateScenario(Method m) {
		
		Indexpage ip = new Indexpage(driver);
		Loginpage lp = ip.clickSignIn();
		lp.loginPageVerifyLaunch();
		lp.enteringNewEmail("qwer@gmail.com");
		lp.creatingAccountBtn();					// this test is correct and it works with new emailid everytime
		
		Accountcreationpage acp = new Accountcreationpage(driver);
		acp.AccountcreationPageVerifyLaunch();
		acp.titleMr();
		acp.firstName("bas");
		acp.lastName("bab");
//		acp.emailName();
		acp.password("rambo");
		acp.registerBtn();
		logger.info("this test case is : >> " + m.getName() + " >> is successfully executed");
	}
	
	@Test
	public void signInScenario(Method m) {
		
		Indexpage ip = new Indexpage(driver);
		ip.clickSignIn();
		Loginpage lp = new Loginpage(driver);
		lp.loginPageVerifyLaunch();
		lp.signInEmail("qwer@gmail.com");
		lp.signInPassword("rambo");				// this test case is correct and it will work
		lp.signInSubmit();
		Signinpage sp = new Signinpage(driver);
		sp.signInPageVerifyLaunch();
		logger.info("this test case is : >> " + m.getName() + " >> is successfully executed");
		
	}
	
	
}
