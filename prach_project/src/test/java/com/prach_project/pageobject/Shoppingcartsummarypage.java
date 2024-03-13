package com.prach_project.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Shoppingcartsummarypage {
	
	WebDriver driver;

	public Shoppingcartsummarypage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	public Shoppingcartsummarypage() {
		super();
	}

	
	@FindBy(xpath="//div[@id='center_column']/h1/text()[2]")
	WebElement  Shoppingcartsummary;
	
	
	@FindBy(xpath="//*[@id='cart_title']/span/text()")
	WebElement  Yourshoppingcartcontains;
	
	
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	WebElement Proceedtocheckout;
	
	@FindBy (xpath = "//a[@title='Continue shopping']")
	WebElement continueshopping;
	
	public void shoppingCartSummaryPageVerify() {
		String actualtitle = driver.getTitle();
		String expectedtitle = "Order - My Shop";
		System.out.println(actualtitle);
		Assert.assertTrue(actualtitle.contains(expectedtitle), "you have landed on shopping cart summery page");
		
	}
	
	public void shoppingCartSummaryPageVerify1(){
		
		Assert.assertTrue(Shoppingcartsummary.getText().equals("SHOPPING-CART SUMMARY")," shopping cart summary page is not verified correctly 1");
		
	}
	
	public void shoppingCartSummaryPageVerify2(){
		
		Assert.assertTrue(Yourshoppingcartcontains.getText().equals("Your shopping cart contains")," shopping cart summary page is not verified correctly 2");
		
	}
	
	public Youraddresspage proceedToCheckOut() {
		Proceedtocheckout.click();
		return new Youraddresspage();
	}
	
	public void clickOnContinueShopping() {
		
		continueshopping.click();
		
//		if (driver.getTitle().equalsIgnoreCase("Printed Dress - My Shop")) {
//			return new Printeddresspage(driver);
//		}if (driver.getTitle().equalsIgnoreCase("Tops - My Shop")){
//			return new Blousepage(driver);
//		}
		
	}

	
	
}
