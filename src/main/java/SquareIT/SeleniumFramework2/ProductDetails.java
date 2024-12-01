package SquareIT.SeleniumFramework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;

public class ProductDetails extends BasePageClass {
	
	static WebDriver driver;
	
	@FindBy(xpath = "(//h1[text()='Nikon D300']/..//following-sibling::ul[@class='list-unstyled'])[2]//h2")
	private WebElement price;
	
	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement qty;
	
	@FindBy (id="button-cart")
	private WebElement setQuantity;
	
	public ProductDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		String prodPrice = price.getText();
		return prodPrice;
	}
	
	public CartPage setQuantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		setQuantity.click();
		ClickOnCart();
		CartPage cartPage = new CartPage(driver);
		return cartPage;

	}
	
	

}
