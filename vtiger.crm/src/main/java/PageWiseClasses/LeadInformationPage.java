package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;

public class LeadInformationPage {

	GenericMethods g;
	public LeadInformationPage(GenericMethods gobj) {
		g=gobj;
		PageFactory.initElements(g.getDriver(), this);
	}
	@FindBy(xpath="//input[@title='Delete [Alt+D]'][1]")
	private WebElement deletebutton;
	public void clickOnDeleteButton() {
		g.click(deletebutton, "Delete button");
	}




}
