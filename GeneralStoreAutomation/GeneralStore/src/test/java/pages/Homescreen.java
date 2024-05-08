package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Homescreen {
	
	AndroidDriver driver;
	
	public Homescreen(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	//Locator for Select country label
	By selectCountryLabel = By.xpath("//android.widget.TextView[@text=\"Select the country where you want to shop\"]");
	
	//Locator for country picker dropdown
	By countryPicker = By.id("com.androidsample.generalstore:id/spinnerCountry");
	
	//Locator for Name field
	By nameField = By.id("com.androidsample.generalstore:id/nameField");
	
	//Locator for gender radio button
	By genderFemale = By.id("com.androidsample.generalstore:id/radioFemale");
	By genderMale = By.id("com.androidsample.generalstore:id/radioMale");
	
	//Locator for Let's Shop button
	By letsShopBtn = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	//Method for validating if user is on homescreen
	public void validateHomescreenElement() {
		driver.findElement(selectCountryLabel).isDisplayed();
	}
	
	//Method for selecting the country
	public void selectCountry(String country) {
		driver.findElement(countryPicker).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ country +"']")).click();
	}
	
	//Method for entering name
	public void enterName(String name) {
		driver.findElement(nameField).sendKeys(name);
		driver.hideKeyboard();
	}
	
	//Method for selecting gender female
	public void selectGenderFemale() {
		driver.findElement(genderFemale).click();
	}
	
	//Method for selecting gender Male
	public void selectGenderMale() {
		driver.findElement(genderMale).click();
	}
	
	//Method for selecting gender Male
	public void clickLetsShopBtn() {
		driver.findElement(letsShopBtn).click();
	}
		
}
