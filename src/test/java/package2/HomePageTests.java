package package2;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import package1.BasePage;
import package1.DressesPageObject;
import package1.HeaderPageObject;
import package1.HomePageObject;

public class HomePageTests   extends BasePage{
	HomePageObject homepage;
	BasePage bp;
	DressesPageObject dp;
	HeaderPageObject hp;

	public HomePageTests() {
		homepage = new HomePageObject();
		bp = new BasePage();
		dp = new DressesPageObject();
		hp = new HeaderPageObject();
	}

	int value = new Random().nextInt(50000);
	String Name = "TestAutomation" + value + "@gmail.com";
	
	@Test
	public void VerifyHomeTitle() {
		System.out.println(homepage.getHometitle1());
		Assert.assertTrue(bp.ElementFound(homepage.getHometitle1()));
		
	}

	@Test
	public void VerifySubMenuWomen() {
		Assert.assertTrue(homepage.GetMenuWomen1().isDisplayed());
		Assert.assertTrue(homepage.GetMenuDresses1().isDisplayed());
		Assert.assertTrue(bp.ElementFound(homepage.GetMenuTshirts()));
		
	}

	@Test
	public void VerifySubMenuWomen2() {
		homepage.clickWomen();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("WOMEN"),
				"Failed to Find");
		homepage.clicDresses();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("DRESSES"),
				"Failed to Find");
		homepage.clickTshirts();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("T-SHIRTS"),
				"Failed to Find");
	}

	@Test
	public void VerifyNewsLetterBox() {
		
		System.out.println("The name iis " + Name);
		bp.setText(homepage.GetTxtBox(), Name);
		System.out.println("homepage.GetTxtBox(),Name");
		homepage.clickbtn();
		Assert.assertTrue(homepage.PopupBoxVerify().getText().trim().equals(" Newsletter : You have successfully subscribed to this newsletter."), "subscribtion Failed");
	}
	
	@Test
	public void VerifyHeaderProductCount(){
	homepage.clickWomen();
	Assert.assertTrue(homepage.getProductHeader() == homepage.getproductDisplayCount());
	}
	
	@Test
	public void VerifyAllSizeBoxisDisplayed(){
//	Assert.assertTrue(bp.ElementFound(homepage.VerifyAllSizeBoxes()));	
		
	}
	
}
