package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import enums.Labels;

public class LiverpoolBasePage extends BasePage{

	@FindBy(className = "m-boutiques-links")
	private WebElement boutiquesBar;
	@FindBy(xpath = "//img[@title='Liverpool Logo']")
	private WebElement liverpoolLogo;
	@FindBy(id = "mainSearchbar")
	private WebElement searchBar;
	@FindBy(className = "icon-zoom")
	private WebElement searchButton;
	@FindBy(xpath = "//*[contains(text(),'Categorías')]")
	private WebElement categoriesButton;
	@FindBy(xpath = "//*[text() ='Iniciar sesión']")
	private WebElement loginButton;
	
	public LiverpoolBasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void seachArticle(String article) {
		searchBar.sendKeys(article);
		searchButton.click();
	}
	
	//Validate a few elements in order to know if the page is being shown correctly
	public void validateLiverpoolBasePage() {
		waitForElementVisibilityExplicit(boutiquesBar);
		assertTrue(boutiquesBar.isDisplayed());
		assertTrue(liverpoolLogo.isDisplayed());
		assertHardEqual(categoriesButton.getText(),Labels.category_button.get());
	}
	
	public void validateNotLogged() {
		assertTrue(loginButton.isDisplayed());
	}
}
