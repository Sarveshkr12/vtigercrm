package TestScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PageWiseClasses.HomePage;
import PageWiseClasses.LoginPage;
import WebUtil_Generic.GenericMethods;

public class BaseTestClass {
	protected GenericMethods g;

	@BeforeClass
	public void beforetestclass() {
		g=new  GenericMethods();
		g.launchBrowser("chrome");
		g.openUrl("http://localhost:8888/");
	}

	@AfterClass
	public void aftertestclass() {
		g.closeAllBrowsers();

	}

	@BeforeMethod
	public void beforeTestcase() {

		LoginPage logAutoScr = new LoginPage(g);
		logAutoScr.TypeOnUsername("admin");
		logAutoScr.TypeOnPassword("admin");
		logAutoScr.ClickOnLoginButton();

	}

	
	@AfterMethod
	public void afterTestcase() {

		HomePage hp=	new HomePage(g);
		hp.logout();

	}

}
