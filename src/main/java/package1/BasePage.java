package package1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	 
	static WebDriver driver;
	public String browser = "chrome";
	
	public BasePage(){
		if(driver==null){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver(); 
			}
		}
		//else if (browser.equals("chrome")){
			//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
				//driver = new ChromeDriver();
			//}
		
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		
		 driver.get("https://www.amazon.in/");
	
	}
	
	      	
	public boolean ElementFound(WebElement element) {
		boolean res = false;
		try{
			res = element.isDisplayed();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		return res;
	}
	
		public void setText(WebElement element , String Name){
			if(Name != null){
				System.out.println("Name1  "+ Name);
				element.clear();
				element.sendKeys(Name);
			}
		}
		public String getTextAttribute(WebElement element){
				return element.getAttribute("value");
				}
		
		public String selectFromDropDown(WebElement element, String options){
			Select obj = new Select(element);
			obj.selectByValue(options);
			return obj.getFirstSelectedOption().getText();
		}
		
		public boolean isElementVisible(WebElement element) {
			
			try{
				WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions.visibilityOf(element));
				return true;
			   }catch(Exception e) {
				   return false;
			   }
		}
		}
	
	


