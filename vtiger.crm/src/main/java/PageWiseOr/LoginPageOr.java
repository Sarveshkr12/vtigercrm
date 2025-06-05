package PageWiseOr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageWiseClasses.BasePage;

public class LoginPageOr extends BasePage {
	public LoginPageOr() {

	}

	@FindBy(xpath="//input[@name='user_name']")
	protected WebElement weusername;
	@FindBy(xpath="//input[@name='user_password']")
	protected WebElement wepassword;
	@FindBy(xpath="//input[@id = 'submitButton']")
	protected WebElement weLoginbutton;

}
