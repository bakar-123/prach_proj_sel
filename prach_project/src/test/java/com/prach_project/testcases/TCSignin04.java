package com.prach_project.testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Loginpage;
import com.prach_project.pageobject.Signinpage;
import com.prach_project.utilities.Utilities;

public class TCSignin04 extends Baseclass{

	
	@Test
	public void signInScenario(Method m) {
		
		Indexpage ip = new Indexpage(driver);
		ip.clickSignIn();
		logger.info("clicked on sign success");
		Loginpage lp = new Loginpage(driver);
		lp.loginPageVerifyLaunch();
		logger.info("login page verified ");
		lp.signInEmail("qwer@gmail.com");
		logger.info("email entered success");
		lp.signInPassword("rambo");	
		logger.info("password entered success");// this test case is correct and it will work
		lp.signInSubmit();
		logger.info("clicked on submit btn success");
		Signinpage sp = new Signinpage(driver);
		logger.info("moving to sign in page");
		sp.signInPageVerifyLaunch();
		logger.info("landed on  signin page  successfully");
		logger.info("this test case is : >> " + m.getName() + " >> is successfully executed");
		
		
	}

		
}
