package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	WebDriver driver;
	WebDriverWait explicitWait;
	FluentWait fluentWait;
	int generalExplicitWaitInSeconds;
	static boolean driverSetup = false;
	SoftAssert sa;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		explicitWait = new WebDriverWait(driver, Duration.ofMillis(3000));
		generalExplicitWaitInSeconds = 2100;
		fluentWait = new FluentWait(driver);
		//Specify the timout of the wait
		fluentWait.withTimeout(Duration.ofMillis(generalExplicitWaitInSeconds));
		//Sepcify polling time
		fluentWait.pollingEvery(Duration.ofMillis(250));
		sa = new SoftAssert();
		//Specify what exceptions to ignore
		//fluentWait.ignoring(NoSuchElementException.class);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement waitForElementVisibilityExplicit(WebElement element) {
		return explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementClickableExplicit(WebElement element) {
		return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void assertHardEqual(String value, String expected) {
		Assert.assertEquals(value, expected);
	}
	
	public void assertHardNegativeEqual(String value, String expected) {
		Assert.assertNotEquals(value, expected);
	}
	
	public void assertTrue(boolean b) {
		Assert.assertTrue(b);
	}
	
	public void assertSoftEqual(String expected, String value) {
		sa.assertEquals(value, expected, " The expected value is "+ expected + " but the test got "+value);
	}
	
	public void assertSoftTrue(boolean b) {
		sa.assertTrue(b);
	}
	
}
