package package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AmazonDealsObject extends BasePage {

	@FindBy(xpath = "//*[@id='nav-xshop']//a[contains(text(),'Deals')]")
	private WebElement TodaysDeal;

	@FindBy(xpath = ".//div[@id = 'widgetFilters']//div[4]/span[2]")
	private WebElement PriceBox;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'rightCol')]//div[contains(@class,'priceBlock')]/span"))
	List<WebElement> Displayprices;
	
	@FindBy(xpath = ".//*[@class = 'a-size-base']")
	private WebElement SortByName;
	
	@FindBy(xpath = ".//*[@ class = 'a-native-dropdown']")
	private WebElement SortByDropDown;
	

	public AmazonDealsObject() {
		PageFactory.initElements(driver, this);
	}

	public void clickTodaysDeal() {
		TodaysDeal.click();
	}

	public void clickPriceBox() {
		PriceBox.click();
	}
	
	public WebElement checkSortByName() {
		return SortByName;
	}
	
	public void checkSortByDropDown() {
		selectFromDropDown(SortByDropDown, "BY_PRICE_ASCENDING");	
			}
	
	public ArrayList<Double> getProductprices() {
		ArrayList<Double> productprice = new ArrayList<Double>();

		for (WebElement product : Displayprices) {
			String value = product.getText().replace("₹", "").replace(",","").replace("?","").split("-")[0].trim();
            Double FinalValue = Double.parseDouble(value);
        	productprice.add(FinalValue);
		}
		return productprice;
	}
}