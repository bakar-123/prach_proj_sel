package com.prach_project.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.prach_project.utilities.Readconfig;

public class Baseclass {

	public static WebDriver driver;
	public static Logger logger;

	Readconfig rc = new Readconfig(); // if we create Strings, it will call goodlyy. if not Null pointer Exception

	String urly = rc.getUrl();
	String brow = rc.getBrowser();

	@BeforeTest // enableonlyfor TCIndexpage02
	public void setupapp() {

		String Browsername = "chrome";
		// =================or
//		String Browsername = rc.getBrowser(); // we can call like this, but it is not getting
		// ===============or
//		String Browsername = "brow";    // create object before and call==============even this is not working

		if (Browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(urly);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger = LogManager.getLogger("prach_project");
	}

	@AfterTest // enableonlyfor TCIndexpage02
	public void teardown() {

		driver.close();
		driver.quit();
	}
	
	/*
		this project is created by Bakar
		
		*/ 
//	after writing text ctrl shift ?
	/*
	 * this project is created by Bakar
	 * 
	 */
	
	
	
}
