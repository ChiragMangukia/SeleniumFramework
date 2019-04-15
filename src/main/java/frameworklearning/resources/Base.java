package frameworklearning.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {

	public static WebDriver driver;
	public Properties properties;

	public WebDriver initializeDriver() throws Exception {

		properties = new Properties();
		File file = new File("src/main/java/FrameworkLearning/resources", "data.properties");
		FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
		properties.load(fileInputStream);

		String browserName = properties.getProperty("browser");

		if (browserName.equals("chrome")) {
			File chromeFile = new File("src/main/java/FrameworkLearning/Binaries", "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			File firefoxFile = new File("src/main/java/FrameworkLearning/Binaries", "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", firefoxFile.getAbsolutePath());
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			File edgeFile = new File("src/main/java/FrameworkLearning/Binaries", "MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", edgeFile.getAbsolutePath());
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public void getScreenshot(String fileName) throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("Screenshots//" + fileName + ".png"));
	}

}
