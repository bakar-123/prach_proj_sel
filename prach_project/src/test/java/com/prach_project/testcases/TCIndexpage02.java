package com.prach_project.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Topspage;
import com.prach_project.pageobject.Womenpage;

public class TCIndexpage02 extends Baseclass {

	@Test(priority = 0)
	public void launchTC() {

		Indexpage ip = new Indexpage(driver);
		ip.searchBox();
		ip.womenLink();
		logger.info("launchTC done successfully");
		logger.error("from now it is getting error");

	}

	@Test(priority = 1, dependsOnMethods = "launchTC")
	public void TC2() {
		Indexpage ip = new Indexpage(driver);
		Womenpage wp = ip.womenLink();
		wp.womenPageVerifyLaunch(); // this test case is correct and it will work
	}

	@Test(priority = 2)
	public void TC3() {
		Indexpage ip = new Indexpage(driver);
		Womenpage wp = ip.womenLink();
		wp.womenPageVerifyLaunch();
		Topspage tp = wp.topsLink();
		tp.topsPageVerifyLaunch();
		tp.scrollTopsPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tp.sortTheTops();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tp.scrollTopsPage();
		logger.error("from now it is getting error");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // script till here works fine, but due to span and element not recognizing, it is not selecting the blouse item to cart
//		tp.addToCompareFirst();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		tp.selectingBlouse();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		tp.addToCart();

	}

}
