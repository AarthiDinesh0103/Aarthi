package package2;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import package1.AmazonDealsObject;
import package1.BasePage;
import package1.HomePageObject;

public class AmazonTestPage {
	
	BasePage bp;
	AmazonDealsObject ad;
	
	public AmazonTestPage() {
		bp = new BasePage();	
		ad = new AmazonDealsObject();
}

	
	/*@Test
	public void VerifyTodaysDealTab() {
		ad.clickTodaysDeal();
	}
	
	@Test
	public void VerifypriceBox() {
		ad.clickTodaysDeal();
		ad.clickPriceBox();
	}
	@Test
	public void Display() {
		System.out.println("Today\'s Deal");	
	}*/
	
	@Test
	public void VerifyProductpricesList() {
		ad.clickTodaysDeal();
		ad.clickPriceBox();
		bp.isElementVisible(ad.checkSortByName());
		ArrayList<Double> productprice = ad.getProductprices();
		System.out.println(productprice);
		for(int i=0;i<productprice.size()-1;i++){
		Assert.assertTrue((productprice.get(i)>= 500 && productprice.get(i)<= 1000), "Not In Range");	
	}
	}
	
	@Test
	public void VerifyAscendingOder() {
		ad.clickTodaysDeal();
	    ad.checkSortByDropDown();
	    ArrayList<Double> productprice = ad.getProductprices();
		System.out.println(productprice);
		for(int i=0;i<productprice.size()-1;i++){
		Assert.assertTrue((productprice.get(i) <= productprice.get(i+1)), "Not In Ascending Order");	
	}
	}
	
}






