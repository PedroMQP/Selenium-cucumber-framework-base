package base;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utils.PropertiesReader;

public class BaseSteps {
	public WebDriver driver;
	String host;	
	String browser;
	TestContext testContext;

	private void setupBrowserDrivers() {
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString().replace('\\', '/');
		System.setProperty("webdriver.chrome.driver",path+"/driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", path+"/driver/geckodriver.exe");
		System.setProperty("webdriver.edge.driver", path+"/driver/msedgedriver.exe");
	}
	
	public void setConfigs() {
		setupBrowserDrivers();
		PropertiesReader configs = new PropertiesReader();
		host = configs.getURL();

		// Launching the browser
		browser = configs.getBrowser();
		System.out.println("Chosing driver");
		if (browser.equals("Chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver =  new ChromeDriver(opt);
		}else if (browser.equals("Firefox")) {
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver =  new FirefoxDriver(opt);
		}else {
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver =  new EdgeDriver(opt);
		}
	}
	
	public void beginTest() {
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get(host);
	}
	
	public void endTest() {
		driver.quit();
	}
	
}
