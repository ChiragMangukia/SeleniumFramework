package frameworklearning;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import frameworklearning.pageobjects.LandingPage;
import frameworklearning.resources.Base;

public class SignInTest extends Base {
	
	public static Logger log = LogManager.getLogger(SignInTest.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception {
		driver= initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test (dataProvider="getData")
	public void login(String username, String password) {
		String url = properties.getProperty("url");
		driver.get(url);
		log.info("Navigated to " + url);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername().sendKeys(username);
		landingPage.enterPassword().sendKeys(password);
		landingPage.submit().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		
		data[0][0] = "SI004841";
		data[0][1] = "cbm123";
		
		data[1][0] = "SI004842";
		data[1][1] = "cbm123";
		
		return data;
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
		driver=null;
	}

}
