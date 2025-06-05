package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;

public class CreatingNewLeadsPage {

	private GenericMethods g;
	public CreatingNewLeadsPage(GenericMethods gobj) {
		g=gobj;
		PageFactory.initElements(g.getDriver(),this);

	}

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnamefield;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnamefield;

	@FindBy(xpath="//input[@name='company']")
	private WebElement companyfield;

	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savebutton;

	@FindBy(xpath="//input[@title='Cancel [Alt+X]'][1]")
	private WebElement cancelButton;

	public void typefirstnamefield(String name) {
		g.type(firstnamefield,name, " First name filed");
	}
	public void typeOnCompanyfield(String companyname) {
		g.type(companyfield, companyname, " company name field");
	}
	public void clickOnSavebutton() {
		g.click(savebutton, " Save button");
	}
	
	public void clickOnVCancelButton() {
		g.click(cancelButton, " Cancel button");
	}

public void typeOnLastName(String LAstname) {
	g.type(lastnamefield, LAstname, "Last Name field");
}







}
