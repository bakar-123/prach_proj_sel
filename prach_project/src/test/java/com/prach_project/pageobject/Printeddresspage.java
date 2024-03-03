package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.prach_project.utilities.Utilities;

public class Printeddresspage  {
	
	
	WebDriver driver;

	public Printeddresspage(WebDriver driver) {
		this.driver = driver;
	}

	public void printedDressesPageVerifyLaunch() {

		String actpridresspagetitle = driver.getTitle();
		System.out.println(actpridresspagetitle);
		String exppridresspagetitle = "Printed Dress - My Shop";

		Assert.assertTrue(actpridresspagetitle.equals(exppridresspagetitle)," launched printed dresses page correctly");
		
	}

	public void printedDressAvalibilityAndSelect() {
		WebElement pridressavailablity = driver.findElement(By.xpath("//p[@id='availability_statut']"));
		Utilities ut = new Utilities();
		ut.explicitlyWait(pridressavailablity);
		String txtofpridressavailability = pridressavailablity.getText();
		System.out.println(txtofpridressavailability);

		if (txtofpridressavailability
				.equals("This product is no longer in stock with those attributes but is available with others.")) {
			// change the colour which is available
			// here iam changing to pink
			WebElement pridresscolourpink = driver.findElement(By.xpath("//a[@name='Pink']"));
			pridresscolourpink.click();
			
			WebElement actpinkdresstxtverify = driver.findElement(By.xpath("//span[@class='label label-success']"));
			String txtactpinkdresstxtverify = actpinkdresstxtverify.getText();
			Assert.assertTrue(txtactpinkdresstxtverify.equals("In stock"), "your proudct si available and is selected");
			
//			WebElement actpinkdresstxtverify = driver.findElement(By.xpath("//div[@itemprop='description']"));
//			Assert.assertEquals(actpinkdresstxtverify,
//					"Printed evening dress with straight sleeves with black thin waist belt and ruffled linings.");
		} else {
			System.out.println("no evening dresses are available even after changing the color");
		}
	}

	public Addtocart addToCart() {
		WebElement addtocart = driver.findElement(By.xpath("//p[@id='add_to_cart']/button"));
		addtocart.click();
//		verifty
//		Addtocart atc = new Addtocart();
//		atc.addToCartPopUp();
		return new Addtocart(driver);
		
	}

}
