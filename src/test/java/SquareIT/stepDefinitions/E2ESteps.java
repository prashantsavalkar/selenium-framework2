package SquareIT.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import SquareIT.SeleniumFramework2.CartPage;
import SquareIT.SeleniumFramework2.CheckOutPage;
import SquareIT.SeleniumFramework2.HomePage;
import SquareIT.SeleniumFramework2.LandingPage;
import SquareIT.SeleniumFramework2.LoginPage;
import SquareIT.SeleniumFramework2.ProductDetails;
import SquareIT.SeleniumFramework2.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseTest;

public class E2ESteps extends BaseTest {
	
	LoginPage login;
	HomePage hp;
	ProductPage pp;
	CheckOutPage checkOutPage;
	
	@Given ("Navigate to baseUrl")
	public void Navigate_to_baseUrl() throws IOException {
	    initBrowser();
		LandingPage lp = new LandingPage(driver);
	    login = lp.navigateToLoginPage();    
	   }
	
	@Given ("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String name, String password) {
	    hp = login.LoginAction(name, password);
	}
	
	@When ("^Added product (.+) to cart and checkout$")
	public void Added_product_to_cart_and_checkout(String product) {
		 pp = hp.clickOnCameraTab();
		 ProductDetails productDetails = pp.addProductToCart(product);
		Assert.assertEquals(productDetails.getPrice(), "$98.00");
		CartPage cartPage = productDetails.setQuantity("2");
	    checkOutPage = cartPage.goToCheckOutPage();
		checkOutPage.clickToCheckOut();
	}
	
	@Then("Verify the details {string}")
	public void Verify_the_details(String string) {
		checkOutPage.closeErrorMassage();        		
		boolean isSucces = checkOutPage.getSuccessMassage().equalsIgnoreCase("***");
		Assert.assertTrue(isSucces);
		tearDown();
	}
	
	

}
