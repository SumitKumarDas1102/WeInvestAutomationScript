package weInvestUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import weInvestBase.ProjectBase;

public class TestUtil extends ProjectBase{
	
	public static long Page_load_timeout = 100;
	public static long implicit_wait = 50;
	public static long explicit_wait = 60;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("indx");
	}
	
	public void scrollDown(WebElement webElement) {
		System.out.println("Here should print the webelement value----------------------------------------" + webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}
	
	public void scrollUP(WebElement webElement) {
		System.out.println("Here should print the webelement value----------------------------------------" + webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);		
	}

}
