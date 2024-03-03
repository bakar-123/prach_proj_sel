package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.prach_project.testcases.Baseclass;

public class Signinpage  {
	
	WebDriver driver;

	public Signinpage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public WebDriver driver; not required since baseclass is extended

	public void signInPageVerifyLaunch() {
		WebElement login_name = driver.findElement(By.xpath("//nav/div[1]/a[@rel='nofollow']"));
		String actualvalue2 = login_name.getText();

		Assert.assertTrue(actualvalue2.equals("Bas bab"), "this verify is wrong");
//		if (actualvalue2.equals("Bas bb")) {            //Bas bab  ==> correct
//			Assert.assertTrue(true);
//		} else {
//			try {
//				screenShotM("signInPageVerifyLaunch");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Assert.assertTrue(false);
//		}
	}
}
