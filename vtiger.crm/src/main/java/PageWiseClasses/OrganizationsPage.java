package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;

public class OrganizationsPage {
GenericMethods g;
	
	public OrganizationsPage(GenericMethods gobj) {
		g=gobj;
		PageFactory.initElements(g.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement orglink ;
	
	
		public void clickOnorganizationcreationLink() {
			g.click(orglink, "organization link");
		}
		

		
		

}
