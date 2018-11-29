package package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;



public class HomePageObject extends BasePage {
	
	
	
	@FindBy(xpath = "//*[contains (@ alt , 'My Store')]")
	private WebElement Hometitle;
	
	@FindBy(xpath = ".//a[@title = 'Women']")
	private WebElement MenuWomen;
	
	@FindBy(xpath = "//ul [contains(@class,'menu-content')]/li[2]//a[@title ='Dresses']")
	private WebElement MenuDresses;
	
	@FindBy(xpath = "//ul [contains(@class,'menu-content')]/li[3]//a[@title ='T-shirts']")
	private WebElement MenuTshirts;
	
	@FindBy(id = "newsletter-input")
	private WebElement NewsLetterbox;
	
	@FindBy(name = "submitNewsletter")
	private WebElement btnclick;
	
	@FindBy(xpath = ".//*[contains(@class , 'alert')]")
	private WebElement PopupMsgVerify;
	
	@FindBy(xpath = ".//*[@class = 'heading-counter']")
	private WebElement ProductHeadercount;
	
	@FindBys(@FindBy(xpath = ".//*[@class = 'product_list grid row']/li"))
	private List<WebElement> DisplayProductCount;
	
	@FindBys(@FindBy(xpath = ".//ul[@id = 'ul_layered_id_attribute_group_1']//li[@class = 'nomargin hiddable col-lg-6']"))
	private ArrayList<WebElement> SizesisDisplayed;
	
	public HomePageObject() {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getHometitle1(){
		return Hometitle;
	}
	public WebElement GetMenuWomen1() {
	return MenuWomen;
	}
	
	public WebElement GetMenuDresses1(){
		return MenuDresses;
	}
	
	public WebElement GetMenuTshirts(){
		return MenuTshirts;
	}
		
	public void clickWomen() {
		 MenuWomen.click();	
	}
	
	public void clicDresses() {
		MenuDresses.click();;	
	}
	
	public void clickTshirts() {
		MenuTshirts.click();	
	}
		
	public WebElement GetTxtBox() {
		return NewsLetterbox;
	}
	
	public void clickbtn() {
		btnclick.click();	
	}

	public WebElement PopupBoxVerify() {
		return PopupMsgVerify;	
	}
	
	public int getProductHeader() {
	String HeaderText = ProductHeadercount.getText();
	System.out.println(HeaderText);
	String arr[] = HeaderText.split(" ");
    String num = arr[2];
    int count = Integer.parseInt(num);
	System.out.println(count);
	return count;
	}

    public int getproductDisplayCount() {
    	int Totalcount = DisplayProductCount.size();
    	System.out.println(Totalcount);
    	return Totalcount;
    }
    
    
    
    
   
			
    }
	








