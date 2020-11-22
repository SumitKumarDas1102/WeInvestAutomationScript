package automationForWeInvestPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import weInvestBase.ProjectBase;
import weInvestUtil.TestUtil;

public class AllWeatherStrategyPage extends ProjectBase{
	
	@FindBy(xpath = "//div[contains(@class, 'col-md-11 col-md-offset-1') and contains(., 'ALL WEATHER STRATEGY')]")
	private WebElement pageHeading;
	
	@FindBy(xpath="//a[contains(@class, 'btn btn-success btn-invest btn-md btn-customize-portfolio') and contains(., 'Customize Portfolio')]")
	private WebElement customizePortfolio;
	
	public AllWeatherStrategyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkPageHeading() {
		return pageHeading.isDisplayed();
	}
	
	
	public boolean checkCustomizeButton() {
		return customizePortfolio.isDisplayed();
	}
	
	public CustomizedPortfolioPage clickOnCustomizedProtfolioButton() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(customizePortfolio));
		customizePortfolio.click();
		return new CustomizedPortfolioPage();
		
	}

}
