package steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import config.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageobject.GoogleLoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", tags = "@smokeTest")
public class GoogleLoginSteps {

	WebDriver driver = Driver.getDriver();
	GoogleLoginPage page = PageFactory.initElements(driver, GoogleLoginPage.class);
	String expectedErrorMessage = "Não foi possível encontrar sua Conta do Google";

	@When("^I navigate to google login page$")
	public void enterPage() {
		page.navigateByUrl();
	}

	@When("^I put the wrong user$")
	public void fillField() {
		page.setLogin("abc");
	}

	@When("^Click on next button$")
	public void triggerNext() {
		page.triggerNext();
	}

	@Then("^an error message should be displayed$")
	public void assertErrorMessage() {
		String errorMessage = page.getErrorMessage();
		assertThat(errorMessage).contains(expectedErrorMessage);
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
