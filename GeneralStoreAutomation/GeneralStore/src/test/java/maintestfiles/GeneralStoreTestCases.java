package maintestfiles;

import org.testng.Reporter;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.Cart;
import pages.Homescreen;
import pages.Products;
import pages.Website;


public class GeneralStoreTestCases extends BaseTest {
	
	@Test
	public void happyPathTestCase() throws InterruptedException {
		
		
		Homescreen homescreen = new Homescreen(driver);
		Products products = new Products(driver);
		Cart cart = new Cart(driver);
		Website website = new Website(driver);
		Reporter.log("Created objects of all the Page classes.");
		
		homescreen.selectCountry("India");
		Reporter.log("Country selected.");
		
		homescreen.enterName("Nik");
		Reporter.log("Entered the name.");
				
		homescreen.selectGenderFemale();
		Reporter.log("Selected Gender as female.");
		
		homescreen.clickLetsShopBtn();
		Reporter.log("Tapped on Lets shop button.");
		
		products.checkIfUserOnProductsScreen();
		Reporter.log("User is on Products screen.");
		
		products.selectProduct("PG 3");
		products.selectProduct("Nike SFB Jungle");
		Reporter.log("Desired products have been selected.");
		
		products.tapOnCartIcon();
		Reporter.log("Tapped on cart icon at the top right corner");
		
		cart.validateUserIsOnCartScreen();
		Reporter.log("User is on cart screen.");
		
		cart.checkProductInCart("PG 3");
		cart.checkProductInCart("Nike SFB Jungle");
		Reporter.log("Cart consists of correct products that were previously selected.");
		
		cart.validateSumOfProductPrices();
		Reporter.log("Sum of product prices is equal to the total price displayed.");
		
		cart.selectSendMeEmailCheckbox();
		Reporter.log("Selected the send me email check box");
		
		cart.tapOnVisitWebsiteBtn();
		Reporter.log("Tapped on visit the website button.");
		
		//Wait for webview to load.
		Thread.sleep(10000);
		
		//Switching the context to webview.
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		website.enterInSearchField("General Store");
		Reporter.log("Entered 'General Store' in search field on the website."); 
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Reporter.log("Tapped on Back button to navigate back to Home screen.");
		
		//Switch the context to native app
		driver.context("NATIVE_APP");
		homescreen.validateHomescreenElement();
		Reporter.log("User is on Homescreen.");
	}	
}
