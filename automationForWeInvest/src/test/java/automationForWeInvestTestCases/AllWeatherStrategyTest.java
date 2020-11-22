package automationForWeInvestTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationForWeInvestPages.AllWeatherStrategyPage;
import automationForWeInvestPages.CustomizedPortfolioPage;
import automationForWeInvestPages.LandingPage;
import weInvestBase.ProjectBase;

public class AllWeatherStrategyTest extends ProjectBase{
	LandingPage landingPage;
	AllWeatherStrategyPage aWPage;
	CustomizedPortfolioPage CPPage;
	
	public AllWeatherStrategyTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		aWPage = landingPage.redirectAllWeatherStrategyPage();
		
	}
	
	
	@Test(priority=1)
	public void checkAllWeatherStrategyHeading() {
		boolean flag = aWPage.checkPageHeading();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void customizedPortfolioButtonIsVisible() {
		boolean flag = aWPage.checkCustomizeButton();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void clickOnCustomizePortfolio() {
		CPPage = aWPage.clickOnCustomizedProtfolioButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
