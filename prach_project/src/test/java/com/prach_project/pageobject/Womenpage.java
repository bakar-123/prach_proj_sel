package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.prach_project.utilities.Utilities;

public class Womenpage {

	public WebDriver driver;
	
	public Womenpage(WebDriver driver) {
		this.driver = driver;
	}

	Actions act;
	Utilities ut;
	
	
	public void womenPageVerifyLaunch() {
		String actualtitle = driver.getTitle();
		String expectedtitle = "Women - My Shop";

//		Assert.assertTrue(actualtitle.equals(expectedtitle), "Women's page is verified and launched properly");  // this may be wrong because having 2 arguments
		Assert.assertTrue(actualtitle.equals(expectedtitle));

	}

	
		public Topspage topsLink() {
			WebElement selwomdress1 = driver.findElement(By.xpath("//a[@title='Women']"));
			ut = new Utilities();
			ut.explicitlyWait(selwomdress1);
			WebElement topslink = driver.findElement(By.xpath("//a[@title='Tops']"));
			
			act = new Actions(driver);
			act.moveToElement(selwomdress1).click(topslink).build().perform();
			return null;
			
//			return new Topspage(driver);   // if writing this, getting null pointer exception
		}
		
		
		
	
	public Eveningdressespage selectTheEveningDresses() {

		
		WebElement selwomdress = driver.findElement(By.xpath("//a[@title='Women']"));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(selwomdress));
		
		ut = new Utilities();
		ut.explicitlyWait(selwomdress);
		
		WebElement selevedress = driver.findElement(By.xpath("(//a[@title='Evening Dresses'][normalize-space()='Evening Dresses'])[1]"));
		act = new Actions(driver);
		act.moveToElement(selwomdress).click(selevedress).build().perform();	

		return new Eveningdressespage(driver);
	}
	
}
