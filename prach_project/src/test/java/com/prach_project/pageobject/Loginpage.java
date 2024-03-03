package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Loginpage  {
	
//	public WebDriver driver; not required since baseclass is extended
	
	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginPageVerifyLaunch() {
		WebElement authentext = driver.findElement(By.xpath("//div[@id='center_column']/h1"));
		String actualtext = authentext.getText();
		String expectedtext = "AUTHENTICATION";

		Assert.assertTrue(actualtext.equals(expectedtext), "you are not in login page");
	}

	public void enteringNewEmail(String newmail) {
		WebElement newemail = driver.findElement(By.xpath("//input[@id='email_create']"));
		newemail.click();
		newemail.sendKeys(newmail);
	}

	public void creatingAccountBtn() {
		WebElement createingaccountbtn = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		createingaccountbtn.click();

	}

	public void signInEmail(String mail) {
		WebElement signinemail = driver.findElement(By.xpath("//input[@id='email']"));
		signinemail.sendKeys(mail);

	}

	public void signInPassword(String pwd) {
		WebElement signinpassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		signinpassword.sendKeys(pwd);

	}

	public Signinpage signInSubmit() {
		WebElement signinsubmit = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signinsubmit.click();
		return new Signinpage(driver);

	}

}
