package steps;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.LiverpolStorePage;
import Pages.LiverpoolBasePage;
import Pages.LiverpoolHomePage;
import base.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropertiesReader;

public class SearchProductSteps {
	WebDriver driver ;
	TestContext testContext;
	LiverpoolHomePage liverpoolHomePage;
	LiverpolStorePage liverpolStorePage;
	
	public SearchProductSteps(TestContext testContext) {
		this.testContext = testContext;
		driver = testContext.getDriver();
		liverpoolHomePage = new LiverpoolHomePage(driver);
		liverpolStorePage = new LiverpolStorePage(driver);
	}

	
	@Given("I am on Home Page")
	public void i_am_on_liverpool_home_page() {
		liverpoolHomePage.validateLiverpoolHomePage();
	}

	@Given("I am not logged in")
	public void i_am_not_logged_in() {
		liverpoolHomePage.validateNotLogged();
	}
	                 
	@When("^I search \"([^\"]*)\" on the search bar$")
	public void i_write_a_product_on_the_search_bar(String article) {
		liverpoolHomePage.seachArticle(article);
	}

	@Then("I will look one or more articles")
	public void clicks_on_the_search_button() {
		liverpolStorePage.validateNonEmptyPage();
		
	}
}
