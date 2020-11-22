package automationForWeInvestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import weInvestBase.ProjectBase;

public class InvestmentNowPage extends ProjectBase{
	
	@FindBy(xpath="//div//h3[@class = 'header-text']")
	private WebElement headerText;
	
	@FindBy(xpath="//div//span[contains(@class, 'header-text') and contains(., 'What does your portfolio contain?')]")
	private WebElement yourPorfolioContain;
	
	

}
