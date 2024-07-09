package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LiverpolStorePage extends LiverpoolBasePage {
	
	@FindBy(className ="m-product__card")
	List<WebElement> searchResults;
	@FindBy(className ="searchNum-result")
	WebElement numberSearchResults;
	public LiverpolStorePage(WebDriver driver) {
		super(driver);
	}
	
	public int getNumberOfResults() {
		
		return searchResults.size();
	}
	
	public void validateNonEmptyPage() {
		waitForElementVisibilityExplicit(numberSearchResults);
		validateLiverpoolBasePage();
		assertTrue(getNumberOfResults() > 0);
	}

}
