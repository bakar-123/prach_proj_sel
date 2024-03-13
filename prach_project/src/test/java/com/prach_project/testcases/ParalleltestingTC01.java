package com.prach_project.testcases;

import org.testng.annotations.Test;

import com.prach_project.pageobject.Addtocart;
import com.prach_project.pageobject.Eveningdressespage;
import com.prach_project.pageobject.Indexpage;
import com.prach_project.pageobject.Loginpage;
import com.prach_project.pageobject.Printeddresspage;
import com.prach_project.pageobject.Shoppingcartsummarypage;
import com.prach_project.pageobject.Signinpage;
import com.prach_project.pageobject.Womenpage;

public class ParalleltestingTC01 extends Baseclass {
	@Test ()
	public void verifyWomenProductIsSelecting() throws InterruptedException {
		
		
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
		Shoppingcartsummarypage scsp = new Shoppingcartsummarypage(driver);
		scsp.shoppingCartSummaryPageVerify();
//		scsp.proceedToCheckOut();
		scsp.clickOnContinueShopping();
		
		//adding 2nd item continuously    ====IMP====if taking old references, its failing so created 2nd reference
		
		Printeddresspage pd1 = new Printeddresspage(driver);  //declared 2nd time, its working   ==or== its failing
		pd1.printedDressAvalibilityAndSelect();
		pd1.addToCart();
		Addtocart atc1 = new Addtocart(driver); 		//declared 2nd time, its working   ==or== its failing
		atc1.proccedToCheckOut();    // this is working fine
		Shoppingcartsummarypage scsp1 = new Shoppingcartsummarypage(driver);		//declared 2nd time, its working   ==or== its failing
		scsp1.shoppingCartSummaryPageVerify();
		scsp1.proceedToCheckOut();           // till here it is working fine , when i ran seperately
		
		
		
	}
	

}
