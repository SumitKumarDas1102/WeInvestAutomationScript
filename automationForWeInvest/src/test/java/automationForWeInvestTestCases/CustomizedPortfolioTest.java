package automationForWeInvestTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationForWeInvestPages.AllWeatherStrategyPage;
import automationForWeInvestPages.CustomizedPortfolioPage;
import automationForWeInvestPages.LandingPage;
import weInvestBase.ProjectBase;

public class CustomizedPortfolioTest extends ProjectBase{
	LandingPage landingPage;
	AllWeatherStrategyPage aWPage;
	CustomizedPortfolioPage CPPage;
	
	public CustomizedPortfolioTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		aWPage = landingPage.redirectAllWeatherStrategyPage();
		CPPage = aWPage.clickOnCustomizedProtfolioButton();
	}
	
	@Test(priority=1)
	public void checkPortfolioPerformanceGraph() {
		boolean flag = CPPage.isGraphDisplay();
		Assert.assertTrue(flag, "The graph is visible");	
	}
	
	@Test(priority=2)
	public void checkIsCustomiseButtonVisible() {
		boolean flag = CPPage.isCustomiseButtonVisible();
		Assert.assertTrue(flag, "Customized button is visible");
	}
	
	@Test(priority=3)
	public void checkOnCustomiseClick() {
		boolean flag = CPPage.onCustomiseClick();	
		Assert.assertTrue(flag, "Edit Section is enable for editing");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
