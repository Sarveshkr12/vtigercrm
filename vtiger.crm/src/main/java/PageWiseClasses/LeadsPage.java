package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebUtil_Generic.GenericMethods;
import net.bytebuddy.description.type.TypeDescription.Generic;

public class LeadsPage {
	GenericMethods gu;
	public  LeadsPage(GenericMethods g) {
		gu=g;
		PageFactory.initElements(gu.getDriver(), this);
		
	}


	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	protected WebElement CreateLeadButton;

	@FindBy(xpath="//input[@name='search_text']")
	protected WebElement SearchField;

	@FindBy(xpath="//input[@name='search_text']")
	protected WebElement SearchInField;


	@FindBy(xpath = "//input[@id=\"135\"]")
	protected WebElement checkbox;


	public void clickOnNewCreateLeadButton() {
		gu.click(CreateLeadButton, "LeadButton");
	}

	public void typeOnSearchForField(String SearchValue) {
		gu.type(SearchField, SearchValue, "LeadSearchField");
	}

	public void SearchInfield(String VisibleTextOfFDropDown) {
		gu.selectTextFromListBox(checkbox, VisibleTextOfFDropDown);
	}

	public void ClickDeleteButton() {

	}







}
