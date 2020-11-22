package automationForWeInvestPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import weInvestBase.ProjectBase;
import weInvestUtil.TestUtil;

public class CustomizedPortfolioPage extends ProjectBase {
	TestUtil testUtil;
	
	@FindBy(xpath="//div[contains(@class, 'panel-heading') and contains(., 'Portfolio Performance')]")
	private WebElement portfolioPerformanceGraph;
	
	@FindBy(xpath="//div//a[contains(@class, 'model-portfolio-btn btn btn-dange btn-black btn-md invest pull-right') and contains(., 'Customise')]")
	private WebElement customizeButton;
	
	@FindBy(xpath="//input [@data-isin='SPY']")
	private WebElement spySlider;
	
	@FindBy(xpath="//div//a[contains(@class, 'model-portfolio-btn btn btn-danger btn-md invest pull-right') and contains(., 'Rebalance')]")
	private WebElement reBalance;
	
	@FindBy(xpath="//div//a[contains(@class, 'model-portfolio-btn btn btn-danger btn-md invest') and contains(., 'Invest Now')]")
	private WebElement inVest;
	
	@FindBy(xpath="//div[@class='col-md-3 text-danger']//div[@class='col-md-3']")
	private List<WebElement> investValue;
	private WebElement getSPDRSPValue = investValue.get(0);
	
	public CustomizedPortfolioPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}
	
	public boolean isGraphDisplay() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(customizeButton));
		return portfolioPerformanceGraph.isDisplayed();
	}
	
	public boolean isCustomiseButtonVisible() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(customizeButton));
		return customizeButton.isDisplayed();	
	}
	
	public boolean onCustomiseClick() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(customizeButton));
		customizeButton.click();
		testUtil.scrollDown(spySlider);
        return spySlider.isEnabled(); 		
		
	}
	
	public String changeSPYValue() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(customizeButton));
		testUtil.scrollDown(spySlider);
		Actions action= new Actions(driver);
	    action.clickAndHold(spySlider);
	    action.moveByOffset(50,0);
	    action.release().build();
	    testUtil.scrollUP(getSPDRSPValue);
	    WebElement inVestValueElement = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.elementToBeClickable(getSPDRSPValue));
	    return getSPDRSPValue.getText();
	}

}
