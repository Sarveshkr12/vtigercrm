package WebUtil_Generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class GenericMethods {

	private WebDriver driver;
	/* this method will launch the browser
	 *  parameter - browser name . ie- chrome
	 *  return type - Object of WebDriver
	 * 
	 * */

	
	public void randomString() {
	//	String emails=	RandomStringUtils.randomAlphabetic(5)+"@gmail.com";

	}
	


	public WebDriver launchBrowser(String browserName) {
		driver =null;
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("Chrome Browser Launched");
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("Firefox Browser Launched");

		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			System.out.println("Edge Browser Launched");

		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		return driver;


	}



	public WebElement searchElement( String xpath)  {

		WebElement we=null;
		try {
			we=getDriver().findElement(By.xpath(xpath));
			System.out.println("element found successfully");
		}catch(NoSuchElementException e) {
			staticWait(20);
			we=getDriver().findElement(By.xpath(xpath));
		}catch(InvalidSelectorException e) {
			System.out.println("xpath syntax is wrong, please check");
			throw e;			
		}catch(Exception e) {

			throw e;
		}
		return we;
	}

	public void clickAllElements(String xpath) {
		List<WebElement> list=getDriver().findElements(By.xpath(xpath));
		for(WebElement we : list) {
			we.click();
		}
	}
	//  getAllElementsText("//a");
	public List<String> getAllElementsText(String xpath) {
		List<WebElement> list=getDriver().findElements(By.xpath(xpath));
		List<String> elementsTextList=new ArrayList<String>();
		for(WebElement we : list) {
			String innerText=we.getText();
			elementsTextList.add(innerText);
		}
		return elementsTextList;
	}

	public void switchToFrame(WebElement weFrame) {
		getDriver().switchTo().frame(weFrame);
	}


	public void staticWait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void switchToFrame(int index) {
		getDriver().switchTo().frame(index);
	}
	public void type( WebElement we, String value, String elementName) {
		try {
			we.sendKeys(value);
			System.out.println(value+" entered in "+elementName+"textbox successfully");
		}catch(ElementNotInteractableException e) {

			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].value='"+value+"'", we);
			System.out.println(value+" entered in "+elementName+" textbox successfully by javascript");

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void click( WebElement we, String elementName) {
		try {
			we.click();
			System.out.println(elementName+" clicked successfully");
		}catch(ElementClickInterceptedException e) {
			jsClick( we);
		}catch(ElementNotInteractableException e) {
			jsClick(we);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void  rightClick( WebElement we, String elmentName) {
		try {

			Actions actob=new Actions(getDriver());
			actob.contextClick(we).build().perform();
			System.out.println(elmentName+" right click performed successfully");
		}catch(ElementNotInteractableException e) {

		}catch(StaleElementReferenceException e) {

		}catch (Exception e) {

		}

	}

	public void switchToWindowByTitle( String pageTitle) {

		Set<String> handleValues =	getDriver().getWindowHandles();
		for(String handleValue : handleValues) {
			getDriver().switchTo().window(handleValue);
			String currentWindowTitle=getDriver().getTitle();
			if(currentWindowTitle.equalsIgnoreCase(pageTitle)) {
				System.out.println("Focus switched in window - its title -"+pageTitle);
				break;
			}
		}

	}


	public void switchToWindowByURL( String pageUrl) {

		Set<String> handleValues =	getDriver().getWindowHandles();
		for(String handleValue : handleValues) {
			getDriver().switchTo().window(handleValue);
			String currentWindowTitle=getDriver().getCurrentUrl();
			if(currentWindowTitle.equalsIgnoreCase(pageUrl)) {
				System.out.println("Focus switched to window - its url -"+pageUrl);
				break;
			}
		}

	}


	public void selectTextFromListBox(WebElement we, String selectText) {
		try {
			Select select=new Select(we);
			select.selectByVisibleText(selectText);
		}catch(Exception e) {

		}
	}

	public void selectTextFromListBoxByIndex(WebElement we, int index) {
		try {
			Select select=new Select(we);
			select.selectByIndex(index);
		}catch(Exception e) {

		}
	}


	public void takesScreenshot( String imageName)  {

		TakesScreenshot  tss=(TakesScreenshot)getDriver();
		File sourceFile=tss.getScreenshotAs(OutputType.FILE);
		File destination= new File("screenshots\\"+imageName+"Image.png");

		try {
			Files.copy(sourceFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void doubleClick( WebElement we) {

		Actions act= new Actions(getDriver());
		act.doubleClick(we).build().perform();

	}

	public void ScollToElement( WebElement we) {
		Actions act= new Actions(getDriver());
		act.scrollToElement(we).build().perform();
		System.out.println("page is scrolled to element successfully");
	} 
	public void mouseOver( WebElement we) {
		Actions act= new Actions(getDriver());
		act.moveToElement(we).build().perform();
	}
	public void openUrl(String url) {

		getDriver().get(url);
		System.out.println(url+" opened");
	}

	/* this method will return innertext of element
	 * parameters - WebELement Object
	 * return type -  String\
	 * Author -  Rahul Yadav
	 * Modified Date - 
	 * Modified By -   */
	public String getInnerText(WebElement we) {
		String innerText=we.getText();
		return innerText;
	}



	public String getAttribute(WebElement we, String attributeName) {
		String attrValue=we.getAttribute(attributeName);
		return attrValue;
	}

	public String getPageTitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
	}

	public String getURL() {
		String url=getDriver().getCurrentUrl();
		return url;
	}

	public void maximize() {
		getDriver().manage().window().maximize();
	}

	public void closeAllBrowsers() {
		getDriver().quit();
	}

	public void closeBrowser() {
		getDriver().close();
	}

	public void setSize(int width, int height) {
		Dimension  dim=new Dimension(width, height);
		getDriver().manage().window().setSize(dim);;
	}


	public void jsClick( WebElement we) {
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", we);
	}

	public void jsType( WebElement we, String value) {
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].value='"+value+"'", we);
	}

	public void jsScrollByAmount(int x, int y) {
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollBy("+x+", "+y+")");
	}

	public void jsScrollToBottom() {
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("document.body.scrollHeight");
	}

	public void jsScrollToElement(WebElement we) {
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", we);
	}

	public void waitForVisibility(WebElement we, int timeout) {
		WebDriverWait wt=new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		wt.until(ExpectedConditions.visibilityOf((we)));
	}

	public void waitForEnabling(WebElement we, int timeout) {
		WebDriverWait wt=new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		wt.until(ExpectedConditions.elementToBeClickable((we)));
	}

	public void waitForDisabling(WebElement we, int timeout) {
		WebDriverWait wt=new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		wt.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((we))));
	}
	public void waitForText(WebElement we, int timeout, String text) {
		WebDriverWait wt=new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		wt.until(ExpectedConditions.textToBePresentInElement(we, text));
	}

	public void waitForInvisibility(WebElement we, int timeout) {
		WebDriverWait wt=new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
		wt.until(ExpectedConditions.not(ExpectedConditions.visibilityOf((we))));
	}

	public void changePageLoadTimeout(int timeout) {
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
	}

	public boolean getElementDisplayStatus(WebElement we) {
		Dimension dim= we.getSize();
		boolean status=false;
		if(dim.getHeight()>0 && dim.getWidth()>0) {
			status=true;
		}
		return status;
	}

	public void validateInnerText(WebElement we, String expectedText) {

		String actualText=we.getText();
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("passed. actual-"+actualText+" && expected-"+expectedText);
		}else {
			System.out.println("failed. actual-"+actualText+" && expected-"+expectedText);
		}

	}


	public void validateAttribute(WebElement we, String expectedAttribute, String attributeName) {

		String actualAttribute=we.getAttribute(attributeName);
		if(actualAttribute.equalsIgnoreCase(expectedAttribute)) {
			System.out.println("passed. actual-"+actualAttribute+" && expected-"+expectedAttribute);
		}else {
			System.out.println("failed. actual-"+actualAttribute+" && expected-"+expectedAttribute);
		}

	}


	public void validateElementIsVisible(WebElement we) {

		boolean actualStatus=we.isDisplayed();
		if(actualStatus==true) {
			System.out.println("passed. actual-"+actualStatus+" && expected- true");
		}else {
			System.out.println("failed. actual-"+actualStatus+" && expected- true");
		}

	}

	public void validateElementIsinvisible(WebElement we) {

		boolean actualStatus=we.isDisplayed();
		if(actualStatus==false) {
			System.out.println("passed. actual-"+actualStatus+" && expected- false");
		}else {
			System.out.println("failed. actual-"+actualStatus+" && expected- false");
		}

	}



	public void validateElementIsEnabled(WebElement we) {

		boolean actualStatus=we.isEnabled();
		if(actualStatus==true) {
			System.out.println("passed. actual-"+actualStatus+" && expected- true");
		}else {
			System.out.println("failed. actual-"+actualStatus+" && expected- true");
		}

	}

	public void validateElementIsDisabled(WebElement we) {

		boolean actualStatus=we.isEnabled();
		if(actualStatus==false) {
			System.out.println("passed. actual-"+actualStatus+" && expected- false");
		}else {
			System.out.println("failed. actual-"+actualStatus+" && expected- false");

		}

	}


	public void validatePageTitle(String expectedTitle) {

		String actualPageTitle=getDriver().getTitle();
		if(actualPageTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("passed. actual-"+actualPageTitle+" && expected- "+expectedTitle);
		}else {
			System.out.println("failed. actual-"+actualPageTitle+" && expected- "+expectedTitle);

		}

	}

	public void validateDropdownSelectedText(WebElement we, String expectedSelectedText) {
		Select select= new Select(we);
		String actualSelectedText=select.getFirstSelectedOption().getText();
		if(actualSelectedText.equalsIgnoreCase(expectedSelectedText)) {
			System.out.println("passed. actual-"+actualSelectedText+" && expected-"+expectedSelectedText);
		}else {
			System.out.println("failed. actual-"+actualSelectedText+" && expected-"+expectedSelectedText);

		}

	}



	public WebDriver getDriver() {
		return driver;
	}



	public void setDriver(WebDriver driver) {
		this.driver = driver;
		
	}



	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
	}

}
