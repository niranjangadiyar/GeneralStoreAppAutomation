package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class Cart {
	
	AndroidDriver driver;
	
	public Cart(AndroidDriver driver) {
		this.driver=driver;
	}
	
	//Locator for Title 'Cart'
	By cartScreenTitle = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title' and @text='Cart']");
	
	//Locator for product prices of each product in cart
	By productPrices = By.id("com.androidsample.generalstore:id/productPrice");
	
	//Locator for actual total amount of products displayed in cart
	By actualTotalAmountOfProducts = By.id("com.androidsample.generalstore:id/totalAmountLbl");
	
	//Locator for products in cart
	String productInCart ="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"%s\"]";
	
	//Locator for send me email checkbox
	By sendMeEmailCheckbox = By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
	
	//Locator for Visit the website button
	By visitTheSiteBtn = By.id("com.androidsample.generalstore:id/btnProceed");
	
	//Method for validating user is on Cart screen
	public void validateUserIsOnCartScreen() {
		Assert.assertTrue(driver.findElement(cartScreenTitle).isDisplayed());
	}
	
	//Method for checking correct products are added in the cart
	public void checkProductInCart(String product) {
		Assert.assertTrue(driver.findElement(By.xpath(String.format(productInCart, product))).isDisplayed());
	}
	
	//Method for checking if the sum of product prices matches with the actual Total Price displayed
	public void validateSumOfProductPrices() {
		
		int countOfProductsInCart = driver.findElements(productPrices).size();
		double sum = 0;
		for(int j = 0; j<countOfProductsInCart; j++)
		{
			double productAmount = Double.parseDouble((driver.findElements(productPrices).get(j).getText()).substring(1));
			sum += productAmount;
		}
		
		double actualTotal = Double.parseDouble((driver.findElement(actualTotalAmountOfProducts).getText()).substring(1));
		Assert.assertEquals(actualTotal, sum);
	}
	
	//Method for selecting the send me email check box
	public void selectSendMeEmailCheckbox() {
		driver.findElement(sendMeEmailCheckbox).click();
	}
	
	//Method for tapping on the Visit website button
	public void tapOnVisitWebsiteBtn() {
		driver.findElement(visitTheSiteBtn).click();
	}
}
