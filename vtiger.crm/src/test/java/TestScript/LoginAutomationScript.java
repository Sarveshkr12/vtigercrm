package TestScript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageWiseClasses.LoginPage;
import WebUtil_Generic.GenericMethods;
//ctrl+sift+/ for xml cmt
public class LoginAutomationScript extends BaseTestClass {

	////tr[@id='headerrow_8']/ancestor::table[@class='small']/following-sibling::table[@class='small']/descendant::div[text()='No Data Found']


	@Test

	public void VarifyLoginWithValidCredentialField() {
		GenericMethods g= new GenericMethods();
		g.launchBrowser("Chrome");
		g.openUrl("http://localhost:8888/");

	
		LoginPage login=	new LoginPage(g);
		login.TypeOnUsername("admin");
		login.TypeOnPassword("admin");
		login.ClickOnLoginButton();
	}
	
	public void testVarifyLoginWithWrongPassword() {

//		GenericMethods g= new GenericMethods();
//		g.launchBrowser("Chrome");
//		g.openUrl("http://localhost:8888/");

		LoginPage login=	new LoginPage(g);
		login.TypeOnUsername("admin");
		login.TypeOnPassword("1qwerfgh");
		login.ClickOnLoginButton();
	}


	public void validLogin() {

			LoginPage login=	new LoginPage(g);
		login.TypeOnUsername("admin");
		login.TypeOnPassword("admin");
		login.ClickOnLoginButton();

	}


}