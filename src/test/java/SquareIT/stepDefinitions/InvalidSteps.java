package SquareIT.stepDefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import testComponents.BaseTest;

public class InvalidSteps extends BaseTest {
	
	 @Then ("Verify the url of current page")
	 public void Verify_the_url_of_current_page() {
		 
		 SoftAssert sa = new SoftAssert();
			String actual = driver.getCurrentUrl();
			String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
			sa.assertEquals(actual, expected);
			tearDown();

			sa.assertAll();
	 }

}
