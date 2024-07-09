package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {
	TestContext testContext;
	public TestHooks(TestContext testContext ){
		this.testContext = testContext;
	}
	
	@Before(order = 0)
	public void setConfigs() {
		testContext.baseSteps.setConfigs();
	}
	
	@Before(order = 1)
	public void beginTest() {
		testContext.baseSteps.beginTest();
	}
	
	@After
	public void endTest() {
		testContext.baseSteps.endTest();
	}
	
}
