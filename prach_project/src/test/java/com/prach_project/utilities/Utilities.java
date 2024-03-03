package com.prach_project.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prach_project.testcases.Baseclass;

public class Utilities extends Baseclass {

	public void scrollJS(WebElement name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", name);
	}
	public void clickJS(WebElement name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", name);
	}
	public void enterTextJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('give the id of the element').value='enter text what you want';");
	}
	//refresh browser
	public void refreshJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	//get domain name
	public String getdomainnameJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String domainname = js.executeScript("return document.domain;").toString();
//		 System.out.println("Domain is:" + domainname);
		return domainname;
	}
	
	//get title name
	public String gettitlenameJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String titlename = js.executeScript("return document.title;").toString();
//		 System.out.println("title is :" + titlename);
		return titlename;
	}
	//get URL name
	public String geturlnameJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String urlname = js.executeScript("return document.URL;").toString();
//		 System.out.println("url is :" + urlname);
		return urlname;
	}
	//draw broder around web element
	public void drawBorderForElementJS(WebElement name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red';", name);
	}
	//zoom 50%
	public void zoomJS(WebElement name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}
	//Return height and width of web page
	public void zoomJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innerheight = js.executeScript("return window.innerHeight;").toString();
		System.out.println("inner height is :" + innerheight);
		System.out.println(js.executeScript("return window.innerWidth;").toString());
	}
	
	//scroll vertically till the end
	//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	//scroll vertically page up
	//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	//to get alert
	//js.executeScript("alert('This is my alert message.');");

	// to navigate to url
	//	js.executeScript("window.location = 'http://www.google.com'");
		
	
	public void select(WebElement name) {
		Select sel = new Select(name);
		List<WebElement> alloptions = sel.getOptions();
		int countalloptions = sel.getOptions().size();
		System.out.println("no.of elements in this dropdown are : " + alloptions);
		System.out.println("no.of elements in this dropdown are : " + countalloptions);
	}

	public String screenShotM(String tname) {

		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\kahme\\eclipse-workspace\\prach_project\\Screenshorts\\" + tname + " _"
				+ dateFromHere() + ".png";
		File de = new File(dest);
		try {
			FileUtils.copyFile(src, de);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return de.getAbsolutePath();   =======OR

		return dest;
	}

	public String dateFromHere() {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String currentDateTime = dateFormat.format(currentDate);

		return currentDateTime;
	}
	// thought of creating once and call multiple times
//	public String void explicitlywait(WebElement ele) {			// unable to create explicitly wait, don't understand
//		WebElement selwomdress = driver.findElement(By.xpath("//a[@title='Women']"));
//		Web<DriverWait> wait = new WebDriverWait(driver , Duration.ofSeconds(20));
//		wait
//		Object String;
//		return String;
//	}
	  // cleared it by creating in another class and pasted it here
	public void explicitlyWait(WebElement ele) {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

}
