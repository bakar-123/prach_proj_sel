package com.prach_project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Indexpage {
	
//	public WebDriver driver; not required since baseclass is extended
	
	
//	WebDriver driver;
	
	WebDriver driver;

	public Indexpage(WebDriver driver) {
		this.driver = driver;
	}

//	WebElement signinbtn = driver.findElement(By.xpath("//a[@class='login']"));
//	WebElement searchbox = driver.findElement(By.xpath("//input[contains(@class,'search_query')]"));
//	WebElement searchbtn = driver.findElement(By.xpath("//button[@name='submit_search']"));
//	WebElement womenlink = driver.findElement(By.xpath("//a[@title='Women']"));
//	WebElement dresseslink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]"));
//	WebElement tshirtslink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]"));
//	WebElement bloglink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[4]"));

	public Loginpage clickSignIn() {
		WebElement signinbtn = driver.findElement(By.xpath("//a[@class='login']"));
		signinbtn.click();
		return new Loginpage(driver);
	}
	
	public void searchBox() {
		WebElement searchbox = driver.findElement(By.xpath("//input[contains(@class,'search_query')]"));
		searchbox.click();
		searchbox.sendKeys("abc");
	}
	
	public void searchBtn() {
		WebElement searchbtn = driver.findElement(By.xpath("//button[@name='submit_search']"));
		searchbtn.click();
	}
	
	public Womenpage womenLink() {
		WebElement womenlink = driver.findElement(By.xpath("//a[@title='Women']"));
		womenlink.click();
		
		return new Womenpage(driver);
		
	}
	
	public void dressesLink() {
		WebElement dresseslink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]"));
		dresseslink.click();
	}
	
	public void tshirtsLink() {
		WebElement tshirtslink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]"));
		tshirtslink.click();
	}
	
	public void blogLink() {
		WebElement bloglink = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[4]"));
		bloglink.click();
	}
	
	public void cartItems() {
		WebElement cartitems = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		cartitems.click();
	}
	

}
