package TestScript;

//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import PageWiseClasses.HomePage;
import PageWiseClasses.OrganizationCreationPage;
import PageWiseClasses.OrganizationsPage;
import WebUtil_Generic.GenericMethods;

public class OrganizationAutomation extends BaseTestClass {
	
	
	@Test (priority = 1)
	public void verifyOrgCreationwithRequiredField() {

	//	String emails=	RandomStringUtils.randomAlphabetic(5)+"@gmail.com";

		HomePage hp = new HomePage(g);
		hp.ClickonOrganizationLink();

		OrganizationsPage org=	new OrganizationsPage(g);
		org.clickOnorganizationcreationLink();
		OrganizationCreationPage orginfo =new OrganizationCreationPage(g);
		orginfo.typeOnOrGField("my new org3");
		orginfo.clickOnSavebutton();
		g.staticWait(10);
		g.acceptAlert();

	}
	@Test (priority = 2)
	public void verifyOrgcreationwithoutRequiredField() {

		HomePage hp = new HomePage(g);
		hp.ClickonOrganizationLink();

		OrganizationsPage org=	new OrganizationsPage(g);
		org.clickOnorganizationcreationLink();
		OrganizationCreationPage orginfo =new OrganizationCreationPage(g);
		orginfo.clickOnSavebutton();
		g.acceptAlert();
       
	}
	
	@Test(priority = 3)
	public void verifyOrganizationCreationWithCancelButton() {

		HomePage hp = new HomePage(g);
		hp.ClickonOrganizationLink();

		OrganizationsPage org=	new OrganizationsPage(g);
		org.clickOnorganizationcreationLink();
		OrganizationCreationPage orginfo =new OrganizationCreationPage(g);
		orginfo.clickOncancelbutton();
		g.staticWait(10);
		g.acceptAlert();

	}




}
