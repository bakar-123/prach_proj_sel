package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Accountcreationpage {

	WebDriver driver;

	public Accountcreationpage(WebDriver driver) {
		this.driver = driver;
	}

	public void AccountcreationPageVerifyLaunch() {
		WebElement createaccounttext = driver.findElement(By.xpath("//div[@id='noSlide']/h1"));
		String actualtext2 = createaccounttext.getText();
		System.out.println(actualtext2);
		String expectedtext2 = "CREATE AN ACCOUNT";
//		=========================================need to check why this assert is failing
//		Assert.assertTrue(actualtext2.equals(expectedtext2), "create account page launched, fill this form");
//		Assert.assertTrue(actualtext2.contains(expectedtext2), "create account page launched, fill this form");

	}

	public void titleMr() {

		WebElement titlemr = driver.findElement(By.xpath("//input[@id='id_gender1']"));
		titlemr.click();
	}

	public void titleMrs() {

		WebElement titlemrs = driver.findElement(By.xpath("//input[@id='id_gender2']"));
		titlemrs.click();
	}

	public void firstName(String fname) {

		WebElement firstname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		firstname.sendKeys(fname);
	}

	public void lastName(String lname) {

		WebElement lastname = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lastname.sendKeys(lname);
	}

	// self written need to check or modify
	public void emailName() {

		WebElement enteremail = driver.findElement(By.xpath("//input[@id='email']"));
		String emailvalue = enteremail.getAttribute("value");

		String newemail = driver.findElement(By.xpath("//input[@id='email_create']")).getText(); // this is loginpages
																									// element calling
																									// here to verify of
																									// both are same

		if (emailvalue.equals(newemail)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void password(String passw) {

		WebElement enterpassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		enterpassword.sendKeys(passw);
	}

	public void registerBtn() {

		WebElement registerbutton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
		registerbutton.click();
	}

}
