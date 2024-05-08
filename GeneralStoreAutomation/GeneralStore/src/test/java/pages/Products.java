package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Products {
	
	AndroidDriver driver;
	
	public Products(AndroidDriver driver) {
		this.driver=driver;
	}
	
	//Locator for cart icon on top right of products screen
	By cartIcon = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
	
	//Locator for product names on Product screen
	By productNames = By.id("com.androidsample.generalstore:id/productName");
	
	//Locator for add to cart button on Product screen
	By addToCartBtns = By.id("com.androidsample.generalstore:id/productAddCart");
	
	//Method for checking if user is on Products screen
	public void checkIfUserOnProductsScreen() {
		Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
	}
	
	//Method for selecting product
	public void selectProduct(String nameOfProduct) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+nameOfProduct+"\"));"));
		int countOfProductsOnScreen = driver.findElements(productNames).size();
		
		for(int i=0; i<countOfProductsOnScreen ; i++)
		{
			String productName = driver.findElements(productNames).get(i).getText();
			if(productName.equalsIgnoreCase(nameOfProduct))
			{
				driver.findElements(addToCartBtns).get(i).click();
			}
		}
	}
	
	//Method for tapping on cart icon on top of the screen
	public void tapOnCartIcon() {
		driver.findElement(cartIcon).click();
	}
}
