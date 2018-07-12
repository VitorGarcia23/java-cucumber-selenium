package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import enums.FieldType;

import enums.FieldType;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String url;

	public BasePage(WebDriver driver,String url) {
		this.url = url;
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void navigateByUrl() {
		driver.get(this.url);
	}

	protected String getFieldValue(WebElement elemnt) {
		wait.until(ExpectedConditions.visibilityOf(elemnt));
		return elemnt.getText();
	}

	protected void setFieldValue(WebElement elemnt, Object value) {
		wait.until(ExpectedConditions.visibilityOf(elemnt));
		elemnt.sendKeys(value.toString());
	}

}
