package SquareIT.SeleniumFramework2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.BaseTest;

public class VerifyInvalidLogin extends BaseTest {
	
	@Test 
	
	public void VerifyLoginWithInvalidCreds() throws IOException {
	WebDriver driver = initBrowser();
	LandingPage lp = new LandingPage(driver);
	LoginPage login = lp.navigateToLoginPage();
	HomePage hp = login.LoginAction("savalkarprash14@gmail.com", "Prasha@123");
	
	SoftAssert sa = new SoftAssert();
	String actual = driver.getCurrentUrl();
	String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
	sa.assertEquals(actual, expected);
	tearDown();

	sa.assertAll();
	}

}
