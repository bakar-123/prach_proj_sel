package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public Printeddresspage selectEveningDressProduc() {
		WebElement movetoevedress = driver.findElement(By.xpath("//div[@class='product-container']/div[2]"));    //another reference   //div[@class='button-container']/a[@title='View']
		Utilities ut = new Utilities();		
		ut.scrollJS(movetoevedress);
		try {											//=== IMP== below method created for alternatively
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clickonmoreevedress = driver.findElement(By.xpath("//div[@class='right-block']/div[2]/a"));
		clickonmoreevedress.click();
		return new Printeddresspage(driver);
	}
	
	// alternate for  selectEveningDressProduct  method ==========
	
	public Printeddresspage selectEveningDressProduct() {
		
		WebElement movetoevedress1 = driver.findElement(By.xpath("//div[@class='product-container']/div[2]"));
//		Utilities ut = new Utilities();		
//		ut.scrollJS(movetoevedress1);   //u can use it if not also ok
		
		WebElement movetoevedressmore = driver.findElement(By.xpath("//div[@class='button-container']/a[@title='View']"));
		
		Actions act = new Actions(driver);
		// actions class given global, let see it runs...earlier it is working fine
		act.moveToElement(movetoevedress1).click(movetoevedressmore).build().perform();
		return new Printeddresspage(driver);
		
	}
	
	
//	========================================CATALOG =======
	
	public void sizeS() {
		WebElement sizes = driver.findElement(By.xpath("//input[@value='1_1']"));
	}
	public void sizeM() {
		WebElement sizem = driver.findElement(By.xpath("//input[@value='2_1']"));
	}
	public void sizeL() {
		WebElement sizel = driver.findElement(By.xpath("//input[@value='3_1']"));
	}
	public void colorBeige() {
		WebElement colorbeige = driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_7']"));
	}
	public void colorPink() {
		WebElement colorpink = driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_24']"));
	}
	public void propertiesShortDress() {
		WebElement propertiesshortdress = driver.findElement(By.xpath("//input[@id='layered_id_feature_19']"));
	}
	public void compositionsViscous() {
		WebElement compositionsviscous = driver.findElement(By.xpath("//input[@id='layered_id_feature_3']"));
	}
	public void stylesDressy() {
		WebElement stylesdressy = driver.findElement(By.xpath("//input[@id='layered_id_feature_16']"));
	}
	public void availibilityInStock() {
		WebElement availibilityinstock = driver.findElement(By.xpath("//input[@id='layered_quantity_1']"));
	}
	public void conditionNew() {
		WebElement conditionnew = driver.findElement(By.xpath("//input[@id='layered_condition_new']"));
	}
	public void priceRange() throws InterruptedException {
		WebElement pricerange = driver.findElement(By.xpath("//div[@id='layered_price_slider']/a[1]"));
		
		
		WebElement priceranging = driver.findElement(By.xpath("//div[@id='layered_price_slider']"));
		Point point = priceranging.getLocation();
		System.out.println(point.getX());	     	//output = 184
		System.out.println(point.getY());  		 //output = 1087
		
		//====IMP====here price is only 3 dollars difference so, givening 50 is just moving to 50 out  of 184
		// since it is drag and drop ====no need to change the y-axis co ordinate
		Actions act = new Actions(driver);
		act.dragAndDropBy(pricerange, 50, 0).build().perform();   //tried with 50 and 184 also
		
		Thread.sleep(10000);
	}
	
	

}
