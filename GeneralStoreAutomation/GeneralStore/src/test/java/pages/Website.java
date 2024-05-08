package pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Website {
	
	AndroidDriver driver;
	
	public Website(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for search field on web site
	By searchField = By.name("q");
	
	//Method for entering value in search field
	public void enterInSearchField(String value) {
		driver.findElement(searchField).sendKeys(value);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
