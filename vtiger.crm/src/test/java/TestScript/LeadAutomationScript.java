package TestScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageWiseClasses.CreatingNewLeadsPage;
import PageWiseClasses.HomePage;
import PageWiseClasses.LeadsPage;
import PageWiseClasses.LoginPage;
import WebUtil_Generic.GenericMethods;

public class LeadAutomationScript extends BaseTestClass {

	@Test(priority = 1)
	public void CreateLeadWithRequiredFields() {
		HomePage hp = new HomePage(g);
		hp.ClickonLeadLink();

		LeadsPage lp=	new LeadsPage(g);
		lp.clickOnNewCreateLeadButton();

		CreatingNewLeadsPage cnlp=	new CreatingNewLeadsPage(g);
		cnlp.typeOnLastName("kumar");
		cnlp.typeOnCompanyfield(" Sm web solution");
		cnlp.clickOnSavebutton();
		
	}

	@Test(priority = 2)
	public void CreateLeadWithAllFields() {
		
		HomePage hp = new HomePage(g);
		hp.ClickonLeadLink();
		LeadsPage lp=	new LeadsPage(g);
		lp.clickOnNewCreateLeadButton();

		CreatingNewLeadsPage cnlp=	new CreatingNewLeadsPage(g);
		cnlp.typeOnLastName("kumar");
		cnlp.typeOnCompanyfield(" Sm web solution");
		cnlp.clickOnSavebutton();
	}




}
