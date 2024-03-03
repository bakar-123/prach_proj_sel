package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.prach_project.utilities.Utilities;

public class Eveningdressespage  {
	
	WebDriver driver;
	
	
	public Eveningdressespage(WebDriver driver) {
		this.driver=driver;
	}

	public void eveningDressesPageVerifyLaunch() {

		String actevedresspagetitle = driver.getTitle();
		String expevedresspagetitle = "Evening Dresses - My Shop";

		Assert.assertTrue(actevedresspagetitle.equals(expevedresspagetitle),
				" launched evening dresses page correctly");
	}

	/*
	 * it is imoprtant because it is broken into 2 steps which cannont be handles
	 * using a single statement or using action class.
	 * 
	 */
	public Printeddresspage selectEveningDressProduct() {
		WebElement movetoevedress = driver.findElement(By.xpath("//div[@class='product-container']/div[2]"));
		Utilities ut = new Utilities();
		ut.scrollJS(movetoevedress);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clickonmoreevedress = driver.findElement(By.xpath("//div[@class='right-block']/div[2]/a"));
		clickonmoreevedress.click();
		return new Printeddresspage(driver);
	}

}
