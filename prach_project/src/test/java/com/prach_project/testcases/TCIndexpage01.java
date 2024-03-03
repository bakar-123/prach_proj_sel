package com.prach_project.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Topspage;
import com.prach_project.pageobject.Womenpage;

public class TCIndexpage01 extends Baseclass {

	@Test(priority = 0 , groups = {"simple"})
	public void launchTC() {

		Indexpage ip = new Indexpage(driver);
//		setupapp();   //this method comes in before test
		ip.searchBox();				// this test case is correct and it will work
		ip.womenLink();

	}

	@Test(priority = 1, dependsOnMethods = "launchTC" , groups = {"pimple","dimple"})
	public void TC2() {

//		setupapp();  //this method comes in before test
		Indexpage ip = new Indexpage(driver);
		Womenpage wp = ip.womenLink();
		wp.womenPageVerifyLaunch(); // this test case is correct and it will work
	}

	@Test(priority = 2, dependsOnMethods = {"TC2","launchTC"} , groups = {"simple","pimple","dimple"})
	public void TC3() {
//		setupapp();   //this method comes in before test
		Indexpage ip = new Indexpage(driver);
		Womenpage wp = ip.womenLink();
		wp.womenPageVerifyLaunch();
		wp.topsLink();
		Topspage tp = new Topspage(driver);
		tp.topsPageVerifyLaunch();
		tp.scrollTopsPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tp.sortTheTops();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tp.scrollTopsPage();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // script till here works fine, but due to span and element not recognizing, it is not selecting the blouse item to cart
//		tp.addToCompareFirst();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		tp.selectingBlouse();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		tp.addToCart();

	}

}
