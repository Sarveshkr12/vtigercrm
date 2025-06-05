package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageWiseOr.BasePageOr;
import WebUtil_Generic.GenericMethods;

public class BasePage extends BasePageOr {
	GenericMethods g= 	new GenericMethods();



	@FindBy(xpath="//td[@style=\\\"background-color:#ffffef;border:1px;border-color:black;vertical-align:middle;\\\"]")
	WebElement homePageSearchField;

	@FindBy(xpath="//td[@id='autocom']//parent::tr//following-sibling::tr//input[@class='crmButton small save']")
	WebElement Deletebutton;




	public void homePageSearchField() {


		g.click(homePageSearchField, "Search Box");
		g.type(homePageSearchField, "Sarvesh", "Search box");
	}

	public void Clickondeletebutton() {
		g.click(Deletebutton, "deletebutton");



	}










}
