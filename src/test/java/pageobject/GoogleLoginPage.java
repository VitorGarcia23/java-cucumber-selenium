package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleLoginPage extends BasePage {

	public GoogleLoginPage(WebDriver driver) {
		super(driver,"https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	/* Elements */
	@FindBy(how = How.ID, using = "identifierId")
	private WebElement loginInput;

	@FindBy(how = How.ID, using = "identifierNext")
	private WebElement nextButton;

	@FindBy(how = How.CSS, using = "form div[jsname=B34EJ]")
	private WebElement errorMessage;
	/* End Elements */

	public String getLogin() {
		return getFieldValue(loginInput);
	}

	public void setLogin(String login) {
		System.out.println(loginInput);
		setFieldValue(loginInput, login);
	}

	public void triggerNext() {
		nextButton.click();
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}
}
