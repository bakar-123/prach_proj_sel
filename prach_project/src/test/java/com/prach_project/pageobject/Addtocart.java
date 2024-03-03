package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Addtocart  {
	
	WebDriver driver;

	public Addtocart(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCartPopUp() {
		WebElement addtocartpopup = driver.findElement(By.xpath("//div[@class='clearfix']/div[1]/h2"));
		addtocartpopup.getText();

		Assert.assertTrue(addtocartpopup.equals("Product successfully added to your shopping cart\r\n"
				+ "				"));
		// if this is wrong, it will stop here

	}

	
	public void clickOnContinueShopping() {

		
	}

	
	public void proccedToCheckOut() {
		WebElement proccedtocheckout = driver.findElement(By.xpath("//div[4]/a[@rel='nofollow']/span"));
		proccedtocheckout.click();

	}

}
