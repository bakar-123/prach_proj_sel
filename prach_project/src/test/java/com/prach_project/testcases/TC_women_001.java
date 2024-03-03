package com.prach_project.testcases;

import org.testng.annotations.Test;

import com.prach_project.pageobject.Addtocart;
import com.prach_project.pageobject.Eveningdressespage;
import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Loginpage;
import com.prach_project.pageobject.Printeddresspage;
import com.prach_project.pageobject.Signinpage;
import com.prach_project.pageobject.Womenpage;

public class TC_women_001 extends Baseclass {
	@Test
	public void verifyWomenProductIsSelecting() {
		
		
		Indexpage ip = new Indexpage(driver);
		ip.clickSignIn();
		Loginpage lp = new Loginpage(driver);
		lp.loginPageVerifyLaunch();
		lp.signInEmail("qwer@gmail.com");
		lp.signInPassword("rambo");
		lp.signInSubmit();
		Signinpage sp = new Signinpage(driver);
		sp.signInPageVerifyLaunch();
		Womenpage wp = new Womenpage(driver);
//		wp.womenPageVerifyLaunch();  // we should not verify this, because we are not clicking it ..... we just hovering in this test case
		wp.selectTheEveningDresses();
		Eveningdressespage ed = new Eveningdressespage(driver);
		ed.eveningDressesPageVerifyLaunch();
		ed.selectEveningDressProduct();
		Printeddresspage pd = new Printeddresspage(driver);
		pd.printedDressesPageVerifyLaunch();
		pd.printedDressAvalibilityAndSelect();
		pd.addToCart();
		Addtocart atc = new Addtocart(driver);
//		atc.addToCartPopUp();
		atc.proccedToCheckOut();    // this is working fine
		
		
	}
	

}
