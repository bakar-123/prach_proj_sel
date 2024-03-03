package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.prach_project.utilities.Utilities;

public class Topspage  {
	
	public  WebDriver driver;

	public Topspage(WebDriver driver) {
		this.driver = driver;
	}
	

	Utilities ut = new Utilities();

//	WebElement topsheading = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
	
//	
	
	
	
	
	public void topsPageVerifyLaunch() {
		String actualtitle = driver.getTitle();
		String expectedtitle = "Tops - My Shop";

		Assert.assertTrue(actualtitle.equals(expectedtitle), "Tops's page is verified and launched properly");
	}

	public void scrollTopsPage() {
		WebElement categoryheading = driver.findElement(By.xpath("//form[@id='layered_form']/div//div[2]//div[@class='layered_subtitle_heading']//span"));
		ut.scrollJS(categoryheading);
	}

	public void sortTheTops() {
	WebElement sortoptionsfortops = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		sortoptionsfortops.click();
		Select sel = new Select(sortoptionsfortops);
		sel.selectByVisibleText("Price: Lowest first");
	}
	
	public void addToCompareFirst() {
//		WebElement addtocomparefirst = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]/div/div[3]/div/a"));
		WebElement addtocomparefirst = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]/div/div[3]/div/a"));
		addtocomparefirst.click();
	}
	
	
	//choose colours
	//
	//select product and add to cart
	public Blousepage selectingBlouse() {
//		WebElement selectingblouse = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[2]/span"));
	//checking the elem path
		WebElement selectingblouse = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]"));
//		selectingblouse.click();
//		String sele = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]")).getAttribute("title");
//	    driver.findElement(By.xpath("sele")).click();
		
		ut.explicitlyWait(selectingblouse);
		ut.clickJS(selectingblouse);
		
//		Actions act = new Actions(driver);
//		act.moveToElement(selectingblouse);
//	    act.click().build().perform();
		
//		selectingblouse.click();
		
		return new Blousepage(driver);
//		String actualtitle = driver.getTitle();
//		//verifying it is landed to correct page
//		Assert.assertTrue(actualtitle.contains("Blouse - My Shop"), "you have seleced product: Blouse");
	}
	
	public void addToCart() {
		WebElement addtocart = driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span"));
		addtocart.click();
	}

}
