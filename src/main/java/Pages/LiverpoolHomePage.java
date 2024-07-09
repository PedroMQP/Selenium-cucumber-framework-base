package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LiverpoolHomePage extends LiverpoolBasePage {
	@FindBy(id = "slideshow-container-headBand")
	private WebElement messageSlider;
	public LiverpoolHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void validateLiverpoolHomePage() {
		validateLiverpoolBasePage();
		assertSoftTrue(messageSlider.isDisplayed());
	}

}
