package frameworklearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By username = By.xpath("//*[@id=\"txtUserName\"]");
	By password = By.xpath("//*[@id=\"txtPassword\"]");
	By submit = By.xpath("//*[@id=\"btnSubmit\"]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterUsername() {
		return driver.findElement(username);
	}
	
	public WebElement enterPassword() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}

}
