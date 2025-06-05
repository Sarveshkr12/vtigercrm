package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;

public class HomePage {
	GenericMethods wu;
	public HomePage(GenericMethods wuobj) {
		wu=wuobj;
		PageFactory.initElements(wu.getDriver(), this);
	}




	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	protected WebElement LeadLinkButton;

	@FindBy(xpath="")
	protected WebElement contactsLinkButton;

	@FindBy(xpath="//a[text()='Organizations']/parent::td[@class='tabUnSelected']")
	protected WebElement OrganizationLinkButton;

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	protected WebElement adminicon;

	@FindBy(xpath="//a[text()='Sign Out']")
	protected WebElement logout;

	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")
	protected WebElement administartorMouseOver;


	public void MovetoIdminIcon() {

	}


	public void ClickonLeadLink() {
		wu.click(LeadLinkButton, "Lead Link Button");
	}

	public void ClickonContactsLink() {
		wu.click(LeadLinkButton, "orglink");
	}

	public void ClickonOrganizationLink() {
		wu.click(OrganizationLinkButton, "Organization link");
	}

	public void logout() {
		wu.mouseOver(administartorMouseOver);
		wu.click(logout, "SingOut");
		
		
	}





}
