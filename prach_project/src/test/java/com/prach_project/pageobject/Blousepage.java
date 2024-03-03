package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.prach_project.utilities.Utilities;

public class Blousepage  {
	
	public WebDriver driver;
	
	Utilities ut = new Utilities();
	
	public Blousepage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void blouseconfirmPageVerifyLaunch() {
		String  actualtitle = driver.getTitle();
		String expectedtitle = "Tops - My Shop";   //actually it is showing Blouse - My Shop , but this is correct
		System.out.println(actualtitle);
		Assert.assertTrue(actualtitle.contains(expectedtitle), "you have seleced product: Blouse");
	 
	}
	
		
	
	public void blouseDressAvalibilityAndSelect() {
		
		WebElement samplewordavailabilityinthispage = driver.findElement(By.xpath("//span[@id='availability_value']"));
		
		WebElement blousedressavailablity = driver.findElement(By.xpath("//span[@id='availability_value']"));
		
		ut.explicitlyWait(blousedressavailablity);
		String txtofblousedressavailablity = blousedressavailablity.getText();
		System.out.println(txtofblousedressavailablity);

		if (txtofblousedressavailablity
				.equals("This product is no longer in stock with those attributes but is available with others.")) {
			// change the colour which is available
			// here iam changing to white
			WebElement blousedresscolourwhite = driver.findElement(By.xpath("//a[@name='White']"));
			blousedresscolourwhite.click();
			
			WebElement actwhitedresstxtverify = driver.findElement(By.xpath("//span[@class='label label-success']"));
			String txtactwhitedresstxtverify = actwhitedresstxtverify.getText();
			Assert.assertTrue(txtactwhitedresstxtverify.equals("In stock"), "your proudct si available and is selected");
			
//			WebElement actpinkdresstxtverify = driver.findElement(By.xpath("//div[@itemprop='description']"));
//			Assert.assertEquals(actpinkdresstxtverify,
//					"Printed evening dress with straight sleeves with black thin waist belt and ruffled linings.");
		} else {
			System.out.println("no Blouses dresses are available even after changing the color");
		}
	}

}
