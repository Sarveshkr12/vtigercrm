package PageWiseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageWiseOr.LoginPageOr;
import WebUtil_Generic.GenericMethods;

public class LoginPage extends LoginPageOr {

	public 	GenericMethods g;
	public LoginPage(GenericMethods obj) {
		g=obj;

		PageFactory.initElements(g.getDriver(), this);
	}
	
	
	public void TypeOnUsername(String UserNAme) {
		g.type(weusername, UserNAme, "Username field");
	}
	
	public void TypeOnPassword(String Password) {
		g.type(wepassword, Password, "Password field");
	}
	
	public void ClickOnLoginButton() {
		g.click(weLoginbutton, "Loginbutton");
	}
	
	public static void main(String[] args) {
		
	}

}



class A{
	    public static void main(String[] args) {
			 set("name", "sarvesh");
			 set("email","ser@gmail.com");
		}
	  public static void set(Object variableName, Object VariableValue) {  
	          
		  variableName=VariableValue;
		    System.out.println(variableName);
}
}
