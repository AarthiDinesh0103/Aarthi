package package1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {
	
	@FindBy(xpath = "//*[@class = 'cat-name']")
	private WebElement header;
	
	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeader() {
		return header;
	}
	}
