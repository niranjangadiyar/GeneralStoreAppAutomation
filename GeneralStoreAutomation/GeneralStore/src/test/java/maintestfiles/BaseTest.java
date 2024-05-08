package maintestfiles;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureDriver() throws URISyntaxException, MalformedURLException {
	
	UiAutomator2Options option = new UiAutomator2Options();
	option.setDeviceName("NiranjanPhone");
	option.setApp("C:\\Users\\ASUS\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
	option.setChromedriverExecutable("C:\\Users\\ASUS\\GeneralStoreAutomation\\GeneralStore\\src\\test\\java\\resources\\chromedriver.exe");
	driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),option);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void quitDriver()
	{
		driver.quit();
	}
}
