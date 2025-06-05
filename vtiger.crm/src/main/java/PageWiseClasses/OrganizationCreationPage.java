package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;

public class OrganizationCreationPage {
	GenericMethods g;
	
	public OrganizationCreationPage(GenericMethods gobj) {
		g=gobj;
		PageFactory.initElements(g.getDriver(), this);
	}
	
	
	@FindBy(xpath="//input[@name=\"accountname\"]")
	private WebElement orgName ;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebutton ;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement Cancelbutton ;
	
	
		public void typeOnOrGField(String value) {
		g.type(orgName, value, " Organization Name");	
	}

		public void clickOnSavebutton() {
		g.click(Savebutton, "Save button");	
	}
		public void clickOncancelbutton() {
			g.click(Cancelbutton, "cancel button");	
		}
	
	
	
	

}
