package base;

import org.openqa.selenium.WebDriver;

public class TestContext {
	public BaseSteps baseSteps;
	
	public TestContext() {
		baseSteps = new BaseSteps();
	}
	
	public WebDriver getDriver() {
		return baseSteps.driver;
	}
}
